package com.jcaa.hexagonal.adapter.databases.sql.repository;

import com.jcaa.hexagonal.adapter.databases.sql.entity.TokenRecuperacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRecuperacionJpaRepository extends JpaRepository<TokenRecuperacionEntity, Long> {
    Optional<TokenRecuperacionEntity> findByToken(String token);
    void deleteByUsuarioId(Long usuarioId);
}

