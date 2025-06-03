package com.meubolso.services;

import com.meubolso.dto.InvestimentoDTO;

import java.util.List;

public interface InvestimentoService {
    List<InvestimentoDTO> listarTodos();
    InvestimentoDTO buscarPorId(Long id);
    InvestimentoDTO salvar(InvestimentoDTO dto);
    InvestimentoDTO atualizar(Long id, InvestimentoDTO dto);
    void deletar(Long id);
}
