package com.meubolso.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMovimentacaoEnum {

    ENTRADA("Entrada"),
    SAIDA("Saida");

    private final String descricao;
}

