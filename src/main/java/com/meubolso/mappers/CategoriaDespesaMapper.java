package com.meubolso.mappers;

import com.meubolso.dto.CategoriaDespesaDTO;
import com.meubolso.enumerate.TipoCategoriaEnum;
import com.meubolso.model.CategoriaDespesa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaDespesaMapper {

    @Mapping(target = "tipoCategoria", source = "tipoCategoriaEnum")
    CategoriaDespesaDTO toDto(CategoriaDespesa categoria);

    @Mapping(target = "tipoCategoriaEnum", source = "tipoCategoria")
    CategoriaDespesa toEntity(CategoriaDespesaDTO dto);

    default TipoCategoriaEnum mapStringToTipoCategoriaEnum(String tipoCategoriaString) {
        if(tipoCategoriaString == null) {
            return null;
        }
        for(TipoCategoriaEnum tipoCategoria : TipoCategoriaEnum.values()) {
            if(tipoCategoria.getDescricao().equalsIgnoreCase(tipoCategoriaString.trim())){
                return tipoCategoria;
            }
        }
        throw new IllegalArgumentException("Tipo de categoria inválido: " + tipoCategoriaString);
    }

    default String mapTipoCategoriaEnumToString(TipoCategoriaEnum tipoCategoriaEnum) {
        return tipoCategoriaEnum != null ? tipoCategoriaEnum.getDescricao() : null;
    }

}
