package com.meubolso.mappers;

import com.meubolso.dto.PostoCombustivelDTO;
import com.meubolso.model.PostoCombustivel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostoCombustivelMapper {
    PostoCombustivelDTO toDto(PostoCombustivel entity);
    PostoCombustivel toEntity(PostoCombustivelDTO dto);
}
