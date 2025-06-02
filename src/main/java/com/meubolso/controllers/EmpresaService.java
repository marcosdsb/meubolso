package com.meubolso.controllers;

import com.meubolso.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaService {
    List<EmpresaDTO> listarTodos();
    EmpresaDTO buscarPorId(Long id);
    EmpresaDTO salvar(EmpresaDTO dto);
    EmpresaDTO atualizar(Long id, EmpresaDTO dto);
    void deletar(Long id);
}
