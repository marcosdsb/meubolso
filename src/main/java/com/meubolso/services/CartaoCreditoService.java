package com.meubolso.services;

import com.meubolso.dto.CartaoCreditoDTO;

import java.util.List;

public interface CartaoCreditoService {
    List<CartaoCreditoDTO> listarTodos();
    CartaoCreditoDTO buscarPorId(Long id);
    CartaoCreditoDTO salvar(CartaoCreditoDTO dto);
    CartaoCreditoDTO atualizar(Long id, CartaoCreditoDTO dto);
    void deletar(Long id);
}
