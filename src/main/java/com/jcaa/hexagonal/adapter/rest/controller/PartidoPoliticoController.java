package com.jcaa.hexagonal.adapter.rest.controller;

import com.jcaa.hexagonal.adapter.rest.dto.PartidoPoliticoRequest;
import com.jcaa.hexagonal.adapter.rest.dto.PartidoPoliticoResponse;
import com.jcaa.hexagonal.adapter.rest.mappers.PartidoPoliticoRestMapper;
import com.jcaa.hexagonal.port.in.PartidoPoliticoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos-politicos")
@RequiredArgsConstructor
@Tag(name = "Partidos Políticos", description = "Endpoints para gestión de partidos políticos")
@SecurityRequirement(name = "bearer-jwt")
public class PartidoPoliticoController {

    private final PartidoPoliticoUseCase partidoPoliticoUseCase;
    private final PartidoPoliticoRestMapper mapper;

    @PostMapping
    @Operation(summary = "Crear partido político", description = "Crea un nuevo partido político")
    public ResponseEntity<PartidoPoliticoResponse> crear(@Valid @RequestBody PartidoPoliticoRequest request) {
        var partido = partidoPoliticoUseCase.crearPartidoPolitico(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(partido));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener partido político por ID", description = "Retorna un partido político por su ID")
    public ResponseEntity<PartidoPoliticoResponse> obtenerPorId(@PathVariable Long id) {
        return partidoPoliticoUseCase.obtenerPartidoPoliticoPorId(id)
                .map(partido -> ResponseEntity.ok(mapper.toResponse(partido)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos los partidos políticos", description = "Retorna una lista de todos los partidos políticos")
    public ResponseEntity<List<PartidoPoliticoResponse>> listarTodos() {
        var partidos = partidoPoliticoUseCase.obtenerTodosLosPartidosPoliticos();
        return ResponseEntity.ok(mapper.toResponseList(partidos));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar partido político", description = "Actualiza un partido político existente")
    public ResponseEntity<PartidoPoliticoResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PartidoPoliticoRequest request) {
        var partido = partidoPoliticoUseCase.actualizarPartidoPolitico(id, mapper.toDomain(request));
        return ResponseEntity.ok(mapper.toResponse(partido));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar partido político", description = "Elimina un partido político por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        partidoPoliticoUseCase.eliminarPartidoPolitico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/pais")
    @Operation(summary = "Buscar por país", description = "Busca partidos políticos por país")
    public ResponseEntity<List<PartidoPoliticoResponse>> buscarPorPais(@RequestParam String pais) {
        var partidos = partidoPoliticoUseCase.buscarPorPais(pais);
        return ResponseEntity.ok(mapper.toResponseList(partidos));
    }

    @GetMapping("/buscar/nombre")
    @Operation(summary = "Buscar por nombre", description = "Busca partidos políticos por nombre")
    public ResponseEntity<List<PartidoPoliticoResponse>> buscarPorNombre(@RequestParam String nombre) {
        var partidos = partidoPoliticoUseCase.buscarPorNombre(nombre);
        return ResponseEntity.ok(mapper.toResponseList(partidos));
    }
}

