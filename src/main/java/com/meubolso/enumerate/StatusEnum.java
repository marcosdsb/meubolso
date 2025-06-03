package com.meubolso.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    PAGO("Pago"),
    A_VENCER("A vencer"),
    VENCIDO("Vencido");

    private final String descricao;

}
