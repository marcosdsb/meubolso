package com.meubolso.services;

import com.meubolso.dto.TipoCombustivelDTO;

import java.util.List;

public interface TipoCombustivelService {
    List<TipoCombustivelDTO> listarTodos();
    TipoCombustivelDTO buscarPorId(Long id);
    TipoCombustivelDTO salvar(TipoCombustivelDTO dto);
    TipoCombustivelDTO atualizar(Long id, TipoCombustivelDTO dto);
    void deletar(Long id);
}
