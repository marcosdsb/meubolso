package com.meubolso.dto;

import java.math.BigDecimal;
import java.util.List;

public record ExtratoCompletoDTO(
        List<ExtratoLancamentoDTO> lancamentos,
        BigDecimal saldoAtual
) {}
