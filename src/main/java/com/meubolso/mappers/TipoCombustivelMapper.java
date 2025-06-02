package com.meubolso.mappers;

import com.meubolso.dto.TipoCombustivelDTO;
import com.meubolso.model.TipoCombustivel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoCombustivelMapper {
    TipoCombustivelDTO toDto(TipoCombustivel entity);
    TipoCombustivel toEntity(TipoCombustivelDTO dto);
}
