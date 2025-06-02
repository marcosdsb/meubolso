package com.meubolso.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvestimentoDTO(
    Long id,
    String tipo, // Pode mapear enum para string
    String descricao,
    BigDecimal valor,
    LocalDate data,
    Integer mesReferenciaId
) {}
