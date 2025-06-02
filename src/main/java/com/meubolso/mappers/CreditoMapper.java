package com.meubolso.mappers;

import com.meubolso.dto.CreditoDTO;
import com.meubolso.model.Credito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditoMapper {

    CreditoDTO toDto(Credito entity);
    Credito toEntity(CreditoDTO dto);

}
