package com.meubolso.mappers;

import com.meubolso.dto.AbastecimentoDTO;
import com.meubolso.model.Abastecimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AbastecimentoMapper {
    AbastecimentoDTO toDto(Abastecimento entity);
    Abastecimento toEntity(AbastecimentoDTO dto);
}
