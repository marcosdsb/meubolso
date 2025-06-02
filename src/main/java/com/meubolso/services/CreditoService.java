package com.meubolso.services;

import com.meubolso.dto.CreditoDTO;

import java.util.List;

public interface CreditoService {
    List<CreditoDTO> listarTodos();
    CreditoDTO buscarPorId(Long id);
    CreditoDTO salvar(CreditoDTO dto);
    CreditoDTO atualizar(Long id, CreditoDTO dto);
    void deletar(Long id);
}
