package com.meubolso.mappers;

import com.meubolso.dto.CartaoCreditoDTO;
import com.meubolso.model.CartaoCredito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoCreditoMapper {
    CartaoCreditoDTO toDto(CartaoCredito entity);
    CartaoCredito toEntity(CartaoCreditoDTO dto);
}