package com.meubolso.mappers;

import com.meubolso.dto.MesReferenciaDTO;
import com.meubolso.model.MesReferencia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesReferenciaMapper {
    MesReferenciaDTO toDTO(MesReferencia mesReferencia);
    MesReferencia toEntity(MesReferenciaDTO mesReferenciaDTO);
}
