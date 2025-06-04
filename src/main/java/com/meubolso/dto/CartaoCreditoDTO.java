package com.meubolso.dto;

public record CartaoCreditoDTO (
    Long id,
    String nome,
    Integer melhorDiaCompra,
    Integer diaVencimentoFatura
) {}
