package com.meubolso.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "despesa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria")
    private CategoriaDespesa categoria;

    @Column(name = "TOTAL")
    private BigDecimal valor;

    @Column(name = "DATA")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mes")
    private MesReferencia mes;

    @ManyToOne(fetch = FetchType.LAZY)
    private FormaPagamento formaPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusPagamento statusPagamento;

    @Column(name = "VALOR_PARCELA")
    private BigDecimal valorParcela;

    @Column(name = "NUMERO_PARCELA")
    private Integer numeroParcela;

    @Column(name = "TOTAL_PARCELAS")
    private Integer totalParcelas;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDate dataVencimento;

    @Column(name = "RECORRENTE")
    private Boolean recorrente;

    @Column(name = "DATA_INICIO")
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;
}
