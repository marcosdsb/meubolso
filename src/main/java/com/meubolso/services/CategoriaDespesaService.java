package com.meubolso.services;

import com.meubolso.dto.CategoriaDespesaDTO;

import java.util.List;

public interface CategoriaDespesaService {
    List<CategoriaDespesaDTO> listarTodos();
    CategoriaDespesaDTO buscarPorId(Long id);
    CategoriaDespesaDTO salvar(CategoriaDespesaDTO dto);
    CategoriaDespesaDTO atualizar(Long id, CategoriaDespesaDTO dto);
    void deletar(Long id);
}
