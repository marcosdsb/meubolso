package com.meubolso.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExtratoLancamentoDTO(
        LocalDate data,
        BigDecimal valor,
        String tipo, // "CREDITO" ou "DESPESA"
        String descricao
) {}

