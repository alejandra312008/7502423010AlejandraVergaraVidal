package com.jcaa.hexagonal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRecuperacion {
    private Long id;
    private String token;
    private Long usuarioId;
    private LocalDateTime fechaExpiracion;
    private Boolean usado;
}

