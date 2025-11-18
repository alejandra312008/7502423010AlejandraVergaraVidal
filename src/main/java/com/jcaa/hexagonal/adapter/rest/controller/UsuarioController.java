package com.jcaa.hexagonal.adapter.rest.controller;

import com.jcaa.hexagonal.adapter.rest.dto.UsuarioRequest;
import com.jcaa.hexagonal.adapter.rest.dto.UsuarioResponse;
import com.jcaa.hexagonal.adapter.rest.mappers.UsuarioRestMapper;
import com.jcaa.hexagonal.port.in.UsuarioUseCase;
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
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Endpoints para gestión de usuarios")
@SecurityRequirement(name = "bearer-jwt")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;
    private final UsuarioRestMapper mapper;

    @PostMapping
    @Operation(summary = "Crear usuario", description = "Crea un nuevo usuario")
    public ResponseEntity<UsuarioResponse> crear(@Valid @RequestBody UsuarioRequest request) {
        var usuario = usuarioUseCase.crearUsuario(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(usuario));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Retorna un usuario por su ID")
    public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id) {
        return usuarioUseCase.obtenerUsuarioPorId(id)
                .map(u -> ResponseEntity.ok(mapper.toResponse(u)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos los usuarios", description = "Retorna una lista de todos los usuarios")
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        var usuarios = usuarioUseCase.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(mapper.toResponseList(usuarios));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente")
    public ResponseEntity<UsuarioResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioRequest request) {
        var usuario = usuarioUseCase.actualizarUsuario(id, mapper.toDomain(request));
        return ResponseEntity.ok(mapper.toResponse(usuario));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioUseCase.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

