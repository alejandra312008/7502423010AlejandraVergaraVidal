package com.jcaa.hexagonal.adapter.rest.controller;

import com.jcaa.hexagonal.adapter.rest.dto.LoginRequest;
import com.jcaa.hexagonal.adapter.rest.dto.LoginResponse;
import com.jcaa.hexagonal.adapter.rest.dto.RecuperarContrasenaRequest;
import com.jcaa.hexagonal.adapter.rest.dto.ResetPasswordRequest;
import com.jcaa.hexagonal.port.in.AutenticacionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "Endpoints para autenticación y recuperación de contraseña")
public class AuthController {

    private final AutenticacionUseCase autenticacionUseCase;

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Autentica un usuario y retorna un token JWT")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String token = autenticacionUseCase.login(request.getUsername(), request.getPassword());
        LoginResponse response = LoginResponse.builder()
                .token(token)
                .username(request.getUsername())
                .message("Login exitoso")
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    @Operation(summary = "Cerrar sesión", description = "Invalida el token JWT del usuario")
    public ResponseEntity<Map<String, String>> logout(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        autenticacionUseCase.logout(token);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout exitoso");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/recuperar-contrasena")
    @Operation(summary = "Solicitar recuperación de contraseña", description = "Genera un token para recuperar la contraseña")
    public ResponseEntity<Map<String, String>> solicitarRecuperacion(@Valid @RequestBody RecuperarContrasenaRequest request) {
        String token = autenticacionUseCase.solicitarRecuperacionContrasena(request.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Token de recuperación generado. Revise su email.");
        response.put("token", token); // En producción, esto se enviaría por email
        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset-password")
    @Operation(summary = "Restablecer contraseña", description = "Restablece la contraseña usando el token de recuperación")
    public ResponseEntity<Map<String, String>> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        String message = autenticacionUseCase.recuperarContrasena(request.getToken(), request.getNuevaPassword());
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }
}

