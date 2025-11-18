package com.jcaa.hexagonal.adapter.databases.sql;

import com.jcaa.hexagonal.adapter.databases.sql.mapper.PartidoPoliticoMapper;
import com.jcaa.hexagonal.adapter.databases.sql.repository.PartidoPoliticoJpaRepository;
import com.jcaa.hexagonal.domain.PartidoPolitico;
import com.jcaa.hexagonal.port.out.PartidoPoliticoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PartidoPoliticoRepositoryAdapter implements PartidoPoliticoRepositoryPort {

    private final PartidoPoliticoJpaRepository jpaRepository;
    private final PartidoPoliticoMapper mapper;

    @Override
    public PartidoPolitico save(PartidoPolitico partidoPolitico) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(partidoPolitico)));
    }

    @Override
    public Optional<PartidoPolitico> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<PartidoPolitico> findAll() {
        return mapper.toDomainList(jpaRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<PartidoPolitico> findByPais(String pais) {
        return mapper.toDomainList(jpaRepository.findByPais(pais));
    }

    @Override
    public List<PartidoPolitico> findByNombreContaining(String nombre) {
        return mapper.toDomainList(jpaRepository.findByNombreContaining(nombre));
    }
}

