package com.meubolso.mappers;

import com.meubolso.dto.EmpresaDTO;
import com.meubolso.model.Empresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaDTO toDto(Empresa empresa);
    Empresa toEntity(EmpresaDTO empresaDTO);

}
