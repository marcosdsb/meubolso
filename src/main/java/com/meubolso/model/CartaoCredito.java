package com.meubolso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "cartao_credito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;

    @Column(name = "MELHOR_DIA_COMPRA")
    private Integer melhorDiaCompra;

    @Column(name = "DIA_VENCIMENTO_FATURA")
    private Integer diaVencimentoFatura;


    public CartaoCredito(Long id) {
        this.id = id;
    }
}
