package com.meubolso.mappers;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.enumerate.TipoMovimentacaoEnum;
import com.meubolso.model.MovimentacaoFinanceira;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimentacaoFinanceiraMapper {

    @Mapping(target = "tipoMovimentacao", source = "tipoMovimentacaoEnum")
    MovimentacaoFinanceiraDTO toDto(MovimentacaoFinanceira entity);

    @Mapping(target = "tipoMovimentacaoEnum", source = "tipoMovimentacao")
    MovimentacaoFinanceira toEntity(MovimentacaoFinanceiraDTO dto);

    default TipoMovimentacaoEnum mapStringToTipoMovimentacaoEnum(String tipoString) {
        if (tipoString == null) return null;
        for (TipoMovimentacaoEnum tipo : TipoMovimentacaoEnum.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(tipoString.trim())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de movimentação inválido: " + tipoString);
    }

    default String mapTipoMovimentacaoEnumToString(TipoMovimentacaoEnum tipoEnum) {
        return tipoEnum != null ? tipoEnum.getDescricao() : null;
    }
}

