package com.meubolso.services;

import com.meubolso.dto.StatusPagamentoDTO;

import java.util.List;

public interface StatusPagamentoService {
    List<StatusPagamentoDTO> listarTodos();
    StatusPagamentoDTO buscarPorId(Long id);
    StatusPagamentoDTO salvar(StatusPagamentoDTO dto);
    StatusPagamentoDTO atualizar(Long id, StatusPagamentoDTO dto);
    void deletar(Long id);
}
