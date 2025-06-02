package com.meubolso.dto;

public record CategoriaDespesaDTO(
        Long id,
        String tipo, // enum como string
        String descricao
) {}
