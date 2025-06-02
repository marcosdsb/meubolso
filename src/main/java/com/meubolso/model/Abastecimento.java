package com.meubolso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Abastecimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "data")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_combustivel_id")
    private TipoCombustivel tipoCombustivel;

    @NotNull @DecimalMin("0.00")
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;

    @NotNull @DecimalMin("0.00")
    @Column(name = "LITROS")
    private BigDecimal litros;

    @NotNull
    @Column(name = "KM_ATUAL")
    private Integer kmAtual;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mes_id")
    private MesReferencia mesReferencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posto_id")
    private PostoCombustivel postoCombustivel;
}
