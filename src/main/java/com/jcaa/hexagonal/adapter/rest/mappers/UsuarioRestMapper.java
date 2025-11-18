package com.jcaa.hexagonal.adapter.rest.mappers;

import com.jcaa.hexagonal.adapter.rest.dto.UsuarioRequest;
import com.jcaa.hexagonal.adapter.rest.dto.UsuarioResponse;
import com.jcaa.hexagonal.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioRestMapper {
    Usuario toDomain(UsuarioRequest request);
    UsuarioResponse toResponse(Usuario domain);
    List<UsuarioResponse> toResponseList(List<Usuario> domains);
}

