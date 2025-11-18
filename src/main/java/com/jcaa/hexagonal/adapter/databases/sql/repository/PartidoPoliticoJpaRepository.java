package com.jcaa.hexagonal.adapter.databases.sql.repository;

import com.jcaa.hexagonal.adapter.databases.sql.entity.PartidoPoliticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoPoliticoJpaRepository extends JpaRepository<PartidoPoliticoEntity, Long> {
    List<PartidoPoliticoEntity> findByPais(String pais);
    List<PartidoPoliticoEntity> findByNombreContaining(String nombre);
}

