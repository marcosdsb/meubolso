package com.meubolso.mappers;

import com.meubolso.dto.FormaPagamentoDTO;
import com.meubolso.model.FormaPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper {
    FormaPagamentoDTO toDto(FormaPagamento entity);
    FormaPagamento toEntity(FormaPagamentoDTO dto);
}
