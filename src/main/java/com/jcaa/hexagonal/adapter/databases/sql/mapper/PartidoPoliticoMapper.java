package com.jcaa.hexagonal.adapter.databases.sql.mapper;

import com.jcaa.hexagonal.adapter.databases.sql.entity.PartidoPoliticoEntity;
import com.jcaa.hexagonal.domain.PartidoPolitico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartidoPoliticoMapper {
    PartidoPoliticoEntity toEntity(PartidoPolitico domain);
    PartidoPolitico toDomain(PartidoPoliticoEntity entity);
    List<PartidoPolitico> toDomainList(List<PartidoPoliticoEntity> entities);
}

