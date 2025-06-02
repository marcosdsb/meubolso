package com.meubolso.repositories;

import com.meubolso.model.MesReferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesReferenciaRepository extends JpaRepository<MesReferencia, Long> {
}
