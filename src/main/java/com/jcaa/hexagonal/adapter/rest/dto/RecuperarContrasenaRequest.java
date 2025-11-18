package com.jcaa.hexagonal.adapter.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecuperarContrasenaRequest {
    @NotBlank(message = "El email es obligatorio")
    private String email;
}

