package com.jcaa.hexagonal.adapter.databases.sql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partidos_politicos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartidoPoliticoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String eslogan;
    private String presidente;
    private String secretario;
    private String tesorero;
    private String pais;

    @Column(name = "num_presidentes")
    private Integer numPresidentes;

    @Column(name = "num_gobernadores")
    private Integer numGobernadores;

    @Column(name = "num_alcaldes")
    private Integer numAlcaldes;

    @Column(name = "num_concejales")
    private Integer numConcejales;

    @Column(name = "num_congresistas")
    private Integer numCongresistas;
}

