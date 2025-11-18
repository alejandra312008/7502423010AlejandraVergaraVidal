package com.jcaa.hexagonal.service;

import com.jcaa.hexagonal.domain.TokenRecuperacion;
import com.jcaa.hexagonal.domain.Usuario;
import com.jcaa.hexagonal.port.in.AutenticacionUseCase;
import com.jcaa.hexagonal.port.out.JwtServicePort;
import com.jcaa.hexagonal.port.out.TokenRecuperacionRepositoryPort;
import com.jcaa.hexagonal.port.out.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AutenticacionService implements AutenticacionUseCase {

    private final UsuarioRepositoryPort usuarioRepository;
    private final JwtServicePort jwtService;
    private final TokenRecuperacionRepositoryPort tokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        if (!usuario.getActivo()) {
            throw new RuntimeException("Usuario inactivo");
        }

        usuario.setUltimoAcceso(LocalDateTime.now());
        usuarioRepository.save(usuario);

        return jwtService.generarToken(username);
    }

    @Override
    public void logout(String token) {
        jwtService.invalidarToken(token);
    }

    @Override
    public String solicitarRecuperacionContrasena(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ese email"));

        String token = UUID.randomUUID().toString();
        TokenRecuperacion tokenRecuperacion = TokenRecuperacion.builder()
                .token(token)
                .usuarioId(usuario.getId())
                .fechaExpiracion(LocalDateTime.now().plusHours(24))
                .usado(false)
                .build();

        tokenRepository.save(tokenRecuperacion);
        return token;
    }

    @Override
    public String recuperarContrasena(String token, String nuevaPassword) {
        TokenRecuperacion tokenRecuperacion = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido"));

        if (tokenRecuperacion.getUsado()) {
            throw new RuntimeException("Token ya utilizado");
        }

        if (tokenRecuperacion.getFechaExpiracion().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expirado");
        }

        Usuario usuario = usuarioRepository.findById(tokenRecuperacion.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setPassword(passwordEncoder.encode(nuevaPassword));
        usuarioRepository.save(usuario);

        tokenRecuperacion.setUsado(true);
        tokenRepository.save(tokenRecuperacion);

        return "Contraseña recuperada exitosamente";
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioAutenticado(String token) {
        String username = jwtService.extraerUsername(token);
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}

