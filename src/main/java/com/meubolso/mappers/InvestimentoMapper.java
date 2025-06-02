package com.meubolso.mappers;

import com.meubolso.dto.InvestimentoDTO;
import com.meubolso.model.Investimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvestimentoMapper {
    InvestimentoDTO toDTO(Investimento investimento);
    Investimento toEntity(InvestimentoDTO investimentoDTO);
}
