package com.jcaa.hexagonal.port.out;

import com.jcaa.hexagonal.domain.PartidoPolitico;

import java.util.List;
import java.util.Optional;

public interface PartidoPoliticoRepositoryPort {
    PartidoPolitico save(PartidoPolitico partidoPolitico);
    Optional<PartidoPolitico> findById(Long id);
    List<PartidoPolitico> findAll();
    void deleteById(Long id);
    List<PartidoPolitico> findByPais(String pais);
    List<PartidoPolitico> findByNombreContaining(String nombre);
}

