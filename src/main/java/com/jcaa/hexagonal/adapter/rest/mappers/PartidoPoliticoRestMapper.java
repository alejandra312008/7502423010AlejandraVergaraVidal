package com.jcaa.hexagonal.adapter.rest.mappers;

import com.jcaa.hexagonal.adapter.rest.dto.PartidoPoliticoRequest;
import com.jcaa.hexagonal.adapter.rest.dto.PartidoPoliticoResponse;
import com.jcaa.hexagonal.domain.PartidoPolitico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartidoPoliticoRestMapper {
    PartidoPolitico toDomain(PartidoPoliticoRequest request);
    PartidoPoliticoResponse toResponse(PartidoPolitico domain);
    List<PartidoPoliticoResponse> toResponseList(List<PartidoPolitico> domains);
}

