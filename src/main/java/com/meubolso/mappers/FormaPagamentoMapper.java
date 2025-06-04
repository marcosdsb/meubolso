package com.meubolso.mappers;

import com.meubolso.dto.FormaPagamentoDTO;
import com.meubolso.enumerate.TipoFormaPagamentoEnum;
import com.meubolso.model.FormaPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper {

    @Mapping(target = "tipoFormaPagamento", source = "tipoFormaPagamentoEnum")
    FormaPagamentoDTO toDto(FormaPagamento entity);

    @Mapping(target = "tipoFormaPagamentoEnum", source = "tipoFormaPagamento")
    FormaPagamento toEntity(FormaPagamentoDTO dto);

    // Conversão String -> Enum
    default TipoFormaPagamentoEnum mapStringToTipoFormaPagamentoEnum(String tipoFormaPagamentoString) {
        if (tipoFormaPagamentoString == null) {
         return null;
        }
        for (TipoFormaPagamentoEnum tipoFormaPagamento : TipoFormaPagamentoEnum.values()) {
            if(tipoFormaPagamento.getDescricao().equalsIgnoreCase(tipoFormaPagamentoString.trim())) {
                return tipoFormaPagamento;
            }

        }
        throw new IllegalArgumentException("Forma de pagamento inválida inválido: " + tipoFormaPagamentoString);
    }

    // Conversão Enum -> String
    default String mapTipoFormaPagamentoEnumToString(TipoFormaPagamentoEnum tipoFormaPagamentoEnum) {
        return tipoFormaPagamentoEnum != null ? tipoFormaPagamentoEnum.getDescricao() : null;
    }

}
