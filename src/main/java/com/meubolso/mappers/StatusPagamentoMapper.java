package com.meubolso.mappers;

import com.meubolso.dto.StatusPagamentoDTO;
import com.meubolso.enumerate.StatusEnum;
import com.meubolso.model.StatusPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusPagamentoMapper {

    @Mapping(target = "status", source = "status")
    StatusPagamentoDTO toDto(StatusPagamento entity);

    @Mapping(target = "status", source = "status")
    StatusPagamento toEntity(StatusPagamentoDTO dto);

    // Conversão String -> Enum
    default StatusEnum mapStringToStatusEnum(String status) {
        if (status == null) return null;
        for (StatusEnum e : StatusEnum.values()) {
            if (e.getDescricao().equalsIgnoreCase(status.trim())) {
                return e;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + status);
    }

    // Conversão Enum -> String
    default String mapStatusEnumToString(StatusEnum statusEnum) {
        return statusEnum != null ? statusEnum.getDescricao() : null;
    }

}

