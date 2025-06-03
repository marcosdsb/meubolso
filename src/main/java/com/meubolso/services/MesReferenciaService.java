package com.meubolso.services;

import com.meubolso.dto.MesReferenciaDTO;

import java.util.List;

public interface MesReferenciaService {
    List<MesReferenciaDTO> listarTodos();
    MesReferenciaDTO buscarPorId(Long id);
    MesReferenciaDTO salvar(MesReferenciaDTO dto);
    MesReferenciaDTO atualizar(Long id, MesReferenciaDTO dto);
    void deletar(Long id);
}
