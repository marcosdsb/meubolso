package com.meubolso.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimentacaoFinanceiraDTO {
    private Long id;
    private String descricao;

    @NotNull
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull
    private String tipoMovimentacao;

    @NotNull
    private LocalDate dataLancamento;

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private Long formaPagamentoId;
    private Long cartaoCreditoId;
    private String localCompra;
    private Integer numeroParcela;
    private Integer totalParcelas;
    private Boolean recorrente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long mesReferenciaId;
    private Long statusPagamentoId;
    private Long categoriaDespesaId;
    private Long empresaId;
}

