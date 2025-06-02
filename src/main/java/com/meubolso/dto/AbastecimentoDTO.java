package com.meubolso.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AbastecimentoDTO(
    Long id,
    LocalDate data,
    Integer tipoCombustivelId,
    BigDecimal valorTotal,
    BigDecimal litros,
    Integer kmAtual,
    Integer mesReferenciaId,
     Integer postoCombustivelId
) {}
