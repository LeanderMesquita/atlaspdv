package com.llm.atlas.dto;

import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.enums.Medida;
import java.time.LocalDate;

import java.util.Set;

public record DrinkDto(
        Integer id,
        Double preco,
        String nome,
        Boolean emEstoque,
        Integer quantidadeEmEstoque,
        LocalDate criadoEm,
        LocalDate atualizadoEm,
        Medida medida,
        Set<Insumo> insumos,
        Integer volume,
        Boolean alcoolico,
        Float teorAlcoolico,
        Boolean gaseificada
) {

    public DrinkDto(Integer id, Double preco, String nome, Boolean emEstoque, Integer quantidadeEmEstoque, LocalDate criadoEm, LocalDate atualizadoEm, Medida medida, Set<Insumo> insumos, Integer volume, Boolean alcoolico, Float teorAlcoolico, Boolean gaseificada) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.emEstoque = emEstoque;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.medida = medida;
        this.insumos = insumos;
        this.volume = volume;
        this.alcoolico = alcoolico;
        this.teorAlcoolico = teorAlcoolico;
        this.gaseificada = gaseificada;
    }
}
