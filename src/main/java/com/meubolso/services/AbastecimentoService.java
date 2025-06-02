package com.meubolso.services;

import com.meubolso.dto.AbastecimentoDTO;

import java.util.List;

public interface AbastecimentoService {
    List<AbastecimentoDTO> listarTodos();
    AbastecimentoDTO buscarPorId(Long id);
    AbastecimentoDTO salvar(AbastecimentoDTO dto);
    AbastecimentoDTO atualizar(Long id, AbastecimentoDTO dto);
    void deletar(Long id);
}
