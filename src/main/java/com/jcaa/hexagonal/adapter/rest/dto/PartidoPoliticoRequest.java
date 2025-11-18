package com.jcaa.hexagonal.adapter.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidoPoliticoRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String eslogan;
    private String presidente;
    private String secretario;
    private String tesorero;
    private String pais;

    @NotNull(message = "El número de presidentes es obligatorio")
    private Integer numPresidentes;

    @NotNull(message = "El número de gobernadores es obligatorio")
    private Integer numGobernadores;

    @NotNull(message = "El número de alcaldes es obligatorio")
    private Integer numAlcaldes;

    @NotNull(message = "El número de concejales es obligatorio")
    private Integer numConcejales;

    @NotNull(message = "El número de congresistas es obligatorio")
    private Integer numCongresistas;
}

