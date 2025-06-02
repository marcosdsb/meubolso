package com.meubolso.mappers;

import com.meubolso.dto.DespesaDTO;
import com.meubolso.model.Despesa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DespesaMapper {
    DespesaDTO toDto(Despesa entity);
    Despesa toEntity(DespesaDTO dto);
}
