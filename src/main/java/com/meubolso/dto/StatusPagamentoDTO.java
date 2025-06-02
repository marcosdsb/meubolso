package com.meubolso.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusPagamentoDTO {
    private Long id;
    private String status;
}