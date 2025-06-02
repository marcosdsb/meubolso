package com.meubolso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "credito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @DecimalMin("0.00")
    @Column(name = "VALOR")
    private BigDecimal valor;

    @NotNull
    @Column(name = "DATA")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "mes_id")
    private MesReferencia mesReferencia;
}
