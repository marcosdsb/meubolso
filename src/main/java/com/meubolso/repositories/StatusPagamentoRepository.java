package com.meubolso.repositories;

import com.meubolso.model.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPagamentoRepository extends JpaRepository<StatusPagamento, Long> {
}
