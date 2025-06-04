package com.meubolso.mappers;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.enumerate.TipoMovimentacaoEnum;
import com.meubolso.model.MovimentacaoFinanceira;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MovimentacaoFinanceiraMapper {

    @Mapping(target = "tipoMovimentacao", source = "tipoMovimentacaoEnum", qualifiedByName = "mapTipoMovimentacaoEnumToString")
    MovimentacaoFinanceiraDTO toDto(MovimentacaoFinanceira entity);

    @Mapping(target = "tipoMovimentacaoEnum", source = "tipoMovimentacao", qualifiedByName = "mapStringToTipoMovimentacaoEnum")
    MovimentacaoFinanceira toEntity(MovimentacaoFinanceiraDTO dto);

    @Named("mapStringToTipoMovimentacaoEnum")
    default TipoMovimentacaoEnum mapStringToTipoMovimentacaoEnum(String tipoString) {
        if (tipoString == null) return null;
        for (TipoMovimentacaoEnum tipo : TipoMovimentacaoEnum.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(tipoString.trim())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de movimentação inválido: " + tipoString);
    }

    @Named("mapTipoMovimentacaoEnumToString")
    default String mapTipoMovimentacaoEnumToString(TipoMovimentacaoEnum tipoEnum) {
        return tipoEnum != null ? tipoEnum.getDescricao() : null;
    }
}

