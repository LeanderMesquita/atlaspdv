package com.llm.atlas.repository;

import com.llm.atlas.entity.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComidaRepository extends JpaRepository<Comida, Integer> {
}
