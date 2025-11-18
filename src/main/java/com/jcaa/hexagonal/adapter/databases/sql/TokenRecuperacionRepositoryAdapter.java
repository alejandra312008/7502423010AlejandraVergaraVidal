package com.jcaa.hexagonal.adapter.databases.sql;

import com.jcaa.hexagonal.adapter.databases.sql.mapper.TokenRecuperacionMapper;
import com.jcaa.hexagonal.adapter.databases.sql.repository.TokenRecuperacionJpaRepository;
import com.jcaa.hexagonal.domain.TokenRecuperacion;
import com.jcaa.hexagonal.port.out.TokenRecuperacionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenRecuperacionRepositoryAdapter implements TokenRecuperacionRepositoryPort {

    private final TokenRecuperacionJpaRepository jpaRepository;
    private final TokenRecuperacionMapper mapper;

    @Override
    public TokenRecuperacion save(TokenRecuperacion token) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(token)));
    }

    @Override
    public Optional<TokenRecuperacion> findByToken(String token) {
        return jpaRepository.findByToken(token).map(mapper::toDomain);
    }

    @Override
    public void deleteByToken(String token) {
        jpaRepository.findByToken(token).ifPresent(jpaRepository::delete);
    }

    @Override
    public void deleteByUsuarioId(Long usuarioId) {
        jpaRepository.deleteByUsuarioId(usuarioId);
    }
}

