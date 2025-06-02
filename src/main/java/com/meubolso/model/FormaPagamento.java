package com.meubolso.model;

import com.meubolso.enumerate.TipoFormaPagamentoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "forma_pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private TipoFormaPagamentoEnum tipoFormaPagamentoEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARTAO_CREDITO")
    private CartaoCredito cartaoCredito; // Só se tipo == CARTAO_CREDITO

}
