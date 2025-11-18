package com.jcaa.hexagonal.port.out;

import com.jcaa.hexagonal.domain.TokenRecuperacion;

import java.util.Optional;

public interface TokenRecuperacionRepositoryPort {
    TokenRecuperacion save(TokenRecuperacion token);
    Optional<TokenRecuperacion> findByToken(String token);
    void deleteByToken(String token);
    void deleteByUsuarioId(Long usuarioId);
}

