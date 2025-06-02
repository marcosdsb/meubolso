package com.meubolso.mappers;

import com.meubolso.dto.TipoPagamentoDTO;
import com.meubolso.model.TipoPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoPagamentoMapper {
    TipoPagamentoDTO toDto(TipoPagamento entity);
    TipoPagamento toEntity(TipoPagamentoDTO dto);
}
