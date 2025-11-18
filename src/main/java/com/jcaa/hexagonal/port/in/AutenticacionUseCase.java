package com.jcaa.hexagonal.port.in;

import com.jcaa.hexagonal.domain.Usuario;

public interface AutenticacionUseCase {
    String login(String username, String password);
    void logout(String token);
    String solicitarRecuperacionContrasena(String email);
    String recuperarContrasena(String token, String nuevaPassword);
    Usuario obtenerUsuarioAutenticado(String token);
}

