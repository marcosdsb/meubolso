package com.meubolso.services;

import com.meubolso.dto.FormaPagamentoDTO;

import java.util.List;

public interface FormaPagamentoService {
    List<FormaPagamentoDTO> listarTodos();
    FormaPagamentoDTO buscarPorId(Long id);
    FormaPagamentoDTO salvar(FormaPagamentoDTO dto);
    FormaPagamentoDTO atualizar(Long id, FormaPagamentoDTO dto);
    void deletar(Long id);
}
