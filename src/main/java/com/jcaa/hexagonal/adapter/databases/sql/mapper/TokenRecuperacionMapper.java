package com.jcaa.hexagonal.adapter.databases.sql.mapper;

import com.jcaa.hexagonal.adapter.databases.sql.entity.TokenRecuperacionEntity;
import com.jcaa.hexagonal.domain.TokenRecuperacion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TokenRecuperacionMapper {
    TokenRecuperacionEntity toEntity(TokenRecuperacion domain);
    TokenRecuperacion toDomain(TokenRecuperacionEntity entity);
}

