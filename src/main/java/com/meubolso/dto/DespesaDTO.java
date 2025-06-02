package com.meubolso.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Representa uma despesa")
public class DespesaDTO {
    @Schema(description = "ID da despesa, gerado pelo sistema", example = "1")
    private Long id;

    @Schema(description = "ID da categoria da despesa, gerado pelo sistema", example = "2")
    private Integer categoriaDespesaId;

    @Schema(description = "Valor da despesa", example = "20.00")
    private BigDecimal valor;

    @Schema(description = "Data da despesa, formato YYYY-MM-DD", example = "2025-03-01")
    private LocalDate data;

    @Schema(description = "Mês de referência da despesa, gerado do cadastro mês", example = "01")
    private Integer mesReferenciaId;

    @Schema(description = "Indica a forma de pagamento da despensa.", example = "01")
    private Integer formaPagamentoId;

    @Schema(description = "Indica de o pagamento está em aberto, pago etc.", example = "01")
    private Integer statusPagamentoId;

    @Schema(description = "Indica o valor de parcela do pagamento", example = "50.55")
    private BigDecimal valorParcela;

    @Schema(description = "Informe um número que indica em quantas parcelas a despesa foi dividida", example = "10")
    private Integer numeroParcela;

    @Schema(description = "Informe um valor decimal que indica o total de todas as parcelas", example = "150.40")
    private Integer totalParcelas;

    @Schema(description = "Informe uma data que indica o vencimento das parcelas", example = "2025-03-01")
    private LocalDate dataVencimento;

    @Schema(description = "Inform se é um pagamento que deve ser feito todo mês, exemplo de uma mensalidade de escola, ", example = "TRUE")
    private Boolean recorrente;

    @Schema(description = "Informe a data de inicio do pagamento no formato YYYY-MM-DD", example = "2025-12-31")
    private LocalDate dataInicio;

    @Schema(description = "Informe a data final do pagamento no formato YYYY-MM-DD", example = "2026-03-31")
    private LocalDate dataFim;

    @Schema(description = "Se o pagamento for em cartão, informe o ID", example = "1")
    private Integer cartaoCreditoId;
}
