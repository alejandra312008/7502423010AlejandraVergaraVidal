package com.jcaa.hexagonal.port.in;

import com.jcaa.hexagonal.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioUseCase {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    Optional<Usuario> obtenerUsuarioPorUsername(String username);
    Optional<Usuario> obtenerUsuarioPorEmail(String email);
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
    boolean validarCredenciales(String username, String password);
}

