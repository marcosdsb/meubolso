package com.meubolso.services;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;

import java.util.List;

public interface MovimentacaoFinanceiraService {
    List<MovimentacaoFinanceiraDTO> listarTodos();
    MovimentacaoFinanceiraDTO buscarPorId(Long id);
    MovimentacaoFinanceiraDTO salvar(MovimentacaoFinanceiraDTO dto);
    MovimentacaoFinanceiraDTO atualizar(Long id, MovimentacaoFinanceiraDTO dto);
    void deletar(Long id);
}
