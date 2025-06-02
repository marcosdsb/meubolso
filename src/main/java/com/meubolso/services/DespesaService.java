package com.meubolso.services;

import com.meubolso.dto.DespesaDTO;

import java.util.List;

public interface DespesaService {
    List<DespesaDTO> listarTodos();
    DespesaDTO buscarPorId(Long id);
    DespesaDTO salvar(DespesaDTO dto);
    DespesaDTO atualizar(Long id, DespesaDTO dto);
    void deletar(Long id);
}
