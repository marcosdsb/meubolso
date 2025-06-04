package com.meubolso.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCategoriaEnum {
    FIXA("fixa"),
    VARIAVEL("Variavel"),
    ADICIONAL("Adicional"),
    EXTRA("Extra");

    private final String descricao;

}
