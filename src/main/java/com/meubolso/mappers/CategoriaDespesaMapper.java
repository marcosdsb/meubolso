package com.meubolso.mappers;

import com.meubolso.dto.CategoriaDespesaDTO;
import com.meubolso.model.CategoriaDespesa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaDespesaMapper {
    CategoriaDespesaDTO toDto(CategoriaDespesa categoria);
    CategoriaDespesa toEntity(CategoriaDespesaDTO dto);
}
