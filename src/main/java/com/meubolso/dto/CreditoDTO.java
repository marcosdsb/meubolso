package com.meubolso.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreditoDTO(
     Long id,
     BigDecimal valor,
     LocalDate data,
     Integer empresaId,
     Integer mesReferenciaId
)  {
    
}
