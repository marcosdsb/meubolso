package com.meubolso.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoFormaPagamentoEnum {
    CARTAO_CREDITO("Cartão de Crédido"),
    PIX("Pix"),
    DEBITO("Cartão de Debito"),
    DINHEIRO("Dinheiro");

    private final String descricao;

}
