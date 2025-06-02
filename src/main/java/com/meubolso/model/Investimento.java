package com.meubolso.model;

import com.meubolso.enumerate.TipoInvestimentoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "investimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 30, name = "tipo")
    private TipoInvestimentoEnum tipo;

    @Size(max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull @DecimalMin("0.00")
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mes_id")
    private MesReferencia mesReferencia;
}
