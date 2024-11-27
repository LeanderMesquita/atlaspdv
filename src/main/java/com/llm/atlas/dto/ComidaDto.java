package com.llm.atlas.dto;

import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.enums.Medida;
import com.llm.atlas.entity.enums.Rotulo;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record ComidaDto(
        Integer id,
        Double preco,
        String nome,
        Boolean emEstoque,
        Integer quantidadeEmEstoque,
        LocalDate criadoEm,
        LocalDate atualizadoEm,
        Medida medida,
        Set<Insumo> insumos,
        Integer porcao,
        List<Rotulo> rotulos
) {
    public ComidaDto(Integer id, Double preco, String nome, Boolean emEstoque, Integer quantidadeEmEstoque, LocalDate criadoEm, LocalDate atualizadoEm, Medida medida, Set<Insumo> insumos, Integer porcao, List<Rotulo> rotulos) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.emEstoque = emEstoque;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.medida = medida;
        this.insumos = insumos;
        this.porcao = porcao;
        this.rotulos = rotulos;
    }
}
