package com.meubolso.mappers;

import com.meubolso.dto.StatusPagamentoDTO;
import com.meubolso.model.StatusPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusPagamentoMapper {
    StatusPagamentoDTO toDto(StatusPagamento entity);
    StatusPagamento toEntity(StatusPagamentoDTO dto);
}

