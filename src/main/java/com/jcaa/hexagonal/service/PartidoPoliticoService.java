package com.jcaa.hexagonal.service;

import com.jcaa.hexagonal.domain.PartidoPolitico;
import com.jcaa.hexagonal.port.in.PartidoPoliticoUseCase;
import com.jcaa.hexagonal.port.out.PartidoPoliticoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PartidoPoliticoService implements PartidoPoliticoUseCase {

    private final PartidoPoliticoRepositoryPort repository;

    @Override
    public PartidoPolitico crearPartidoPolitico(PartidoPolitico partidoPolitico) {
        return repository.save(partidoPolitico);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PartidoPolitico> obtenerPartidoPoliticoPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartidoPolitico> obtenerTodosLosPartidosPoliticos() {
        return repository.findAll();
    }

    @Override
    public PartidoPolitico actualizarPartidoPolitico(Long id, PartidoPolitico partidoPolitico) {
        return repository.findById(id)
                .map(existing -> {
                    partidoPolitico.setId(id);
                    return repository.save(partidoPolitico);
                })
                .orElseThrow(() -> new RuntimeException("Partido Político no encontrado con id: " + id));
    }

    @Override
    public void eliminarPartidoPolitico(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartidoPolitico> buscarPorPais(String pais) {
        return repository.findByPais(pais);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartidoPolitico> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }
}

