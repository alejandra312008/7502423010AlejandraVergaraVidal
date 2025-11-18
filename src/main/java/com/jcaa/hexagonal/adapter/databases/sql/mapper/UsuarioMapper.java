package com.jcaa.hexagonal.adapter.databases.sql.mapper;

import com.jcaa.hexagonal.adapter.databases.sql.entity.UsuarioEntity;
import com.jcaa.hexagonal.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {
    UsuarioEntity toEntity(Usuario domain);
    Usuario toDomain(UsuarioEntity entity);
    List<Usuario> toDomainList(List<UsuarioEntity> entities);
}

