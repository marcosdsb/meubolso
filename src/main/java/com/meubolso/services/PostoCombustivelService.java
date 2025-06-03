package com.meubolso.services;

import com.meubolso.dto.PostoCombustivelDTO;

import java.util.List;

public interface PostoCombustivelService {
    List<PostoCombustivelDTO> listarTodos();
    PostoCombustivelDTO buscarPorId(Long id);
    PostoCombustivelDTO salvar(PostoCombustivelDTO dto);
    PostoCombustivelDTO atualizar(Long id, PostoCombustivelDTO dto);
    void deletar(Long id);
}
