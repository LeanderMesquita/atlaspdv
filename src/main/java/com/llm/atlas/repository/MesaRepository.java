package com.llm.atlas.repository;

import com.llm.atlas.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    Mesa findByNumeracaoMesa(Integer numeracaoMesa);
}
