package com.meubolso.dto;

public record FormaPagamentoDTO (
     Long id,
     String tipoFormaPagamento,
     CartaoCreditoDTO cartaoCredito
){}