package com.meubolso.services.specification;

import com.meubolso.filtro.MovimentacaoFinanceiraFiltro;
import com.meubolso.model.MovimentacaoFinanceira;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class MovimentacaoFinanceiraSpecification {
    public static Specification<MovimentacaoFinanceira> filtrarPor(MovimentacaoFinanceiraFiltro filtro) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (filtro.getDataInicio() != null) {
                predicate = cb.and(predicate,
                        cb.greaterThanOrEqualTo(
                                root.get("dataLancamento").as(LocalDate.class),
                                filtro.getDataInicio()
                        ));
            }

            if (filtro.getDataFim() != null) {
                predicate = cb.and(predicate,
                        cb.lessThanOrEqualTo(
                                root.get("dataLancamento").as(LocalDate.class),
                                filtro.getDataFim()
                        ));
            }

            if (filtro.getStatusPagamentoId() != null) {
                predicate = cb.and(predicate,
                        cb.equal(
                                root.get("statusPagamento").get("id"),
                                filtro.getStatusPagamentoId()
                        ));
            }

            return predicate;
        };
    }
}
