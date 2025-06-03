package com.meubolso.repositories;

import com.meubolso.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}
