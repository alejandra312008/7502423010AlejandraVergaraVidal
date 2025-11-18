package com.jcaa.hexagonal.port.in;

import com.jcaa.hexagonal.domain.PartidoPolitico;

import java.util.List;
import java.util.Optional;

public interface PartidoPoliticoUseCase {
    PartidoPolitico crearPartidoPolitico(PartidoPolitico partidoPolitico);
    Optional<PartidoPolitico> obtenerPartidoPoliticoPorId(Long id);
    List<PartidoPolitico> obtenerTodosLosPartidosPoliticos();
    PartidoPolitico actualizarPartidoPolitico(Long id, PartidoPolitico partidoPolitico);
    void eliminarPartidoPolitico(Long id);
    List<PartidoPolitico> buscarPorPais(String pais);
    List<PartidoPolitico> buscarPorNombre(String nombre);
}

