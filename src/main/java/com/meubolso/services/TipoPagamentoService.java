package com.meubolso.services;

import com.meubolso.dto.TipoPagamentoDTO;

import java.util.List;

public interface TipoPagamentoService {
    List<TipoPagamentoDTO> listarTodos();
    TipoPagamentoDTO buscarPorId(Long id);
    TipoPagamentoDTO salvar(TipoPagamentoDTO dto);
    TipoPagamentoDTO atualizar(Long id, TipoPagamentoDTO dto);
    void deletar(Long id);
}
