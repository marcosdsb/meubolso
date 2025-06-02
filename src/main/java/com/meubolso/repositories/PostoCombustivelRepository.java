package com.meubolso.repositories;

import com.meubolso.model.PostoCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoCombustivelRepository extends JpaRepository<PostoCombustivel, Long> {
}
