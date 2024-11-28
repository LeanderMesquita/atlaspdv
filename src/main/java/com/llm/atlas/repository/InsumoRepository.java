package com.llm.atlas.repository;

import com.llm.atlas.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsumoRepository extends JpaRepository<Insumo, Integer> {

    Optional<Insumo> findByNome(String nome);
}
