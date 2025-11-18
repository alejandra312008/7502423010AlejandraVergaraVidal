package com.jcaa.hexagonal.adapter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidoPoliticoResponse {
    private Long id;
    private String nombre;
    private String eslogan;
    private String presidente;
    private String secretario;
    private String tesorero;
    private String pais;
    private Integer numPresidentes;
    private Integer numGobernadores;
    private Integer numAlcaldes;
    private Integer numConcejales;
    private Integer numCongresistas;
}

