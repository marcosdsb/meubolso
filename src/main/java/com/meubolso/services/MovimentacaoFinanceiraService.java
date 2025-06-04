package com.meubolso.services;

import com.meubolso.dto.MovimentacaoFinanceiraDTO;
import com.meubolso.filtro.MovimentacaoFinanceiraFiltro;

import java.time.LocalDate;
import java.util.List;

public interface MovimentacaoFinanceiraService {
    List<MovimentacaoFinanceiraDTO> listarTodos();
    MovimentacaoFinanceiraDTO buscarPorId(Long id);
    MovimentacaoFinanceiraDTO salvar(MovimentacaoFinanceiraDTO dto);
    MovimentacaoFinanceiraDTO atualizar(Long id, MovimentacaoFinanceiraDTO dto);
    void deletar(Long id);
    List<MovimentacaoFinanceiraDTO> filtrar(LocalDate dataInicio, LocalDate dataFim, Long statusPagamentoId);
    List<MovimentacaoFinanceiraDTO> filtrar(MovimentacaoFinanceiraFiltro filtro);
}
