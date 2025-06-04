package com.meubolso.repositories;

import com.meubolso.enumerate.TipoMovimentacaoEnum;
import com.meubolso.model.MovimentacaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceira, Long>, JpaSpecificationExecutor<MovimentacaoFinanceira> {

    List<MovimentacaoFinanceira> findByDataLancamentoBetween(LocalDate inicio, LocalDate fim);

    List<MovimentacaoFinanceira> findByStatusPagamentoId(Long statusPagamentoId);

    List<MovimentacaoFinanceira> findByMesReferenciaId(Long mesId);

    List<MovimentacaoFinanceira> findByTipoMovimentacaoEnum(TipoMovimentacaoEnum tipo);

}
