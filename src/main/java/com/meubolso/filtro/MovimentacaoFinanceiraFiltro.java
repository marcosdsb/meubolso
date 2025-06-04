package com.meubolso.filtro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoFinanceiraFiltro {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long statusPagamentoId;
    private Long mesReferenciaId;
    private Long empresaId;
    private String tipoMovimentacao; // ENTRADA ou SAIDA
}
