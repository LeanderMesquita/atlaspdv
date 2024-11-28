package com.llm.atlas.dto;

import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.enums.Medida;
import com.llm.atlas.entity.enums.Rotulo;
import com.llm.atlas.entity.enums.Tag;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record NaoManufaturadoDto(
        Integer id,
        Double preco,
        String nome,
        Boolean emEstoque,
        Integer quantidadeEmEstoque,
        LocalDate criadoEm,
        LocalDate atualizadoEm,
        Medida medida,
        String marca,
        Tag tipo
) {
    public NaoManufaturadoDto(Integer id, Double preco, String nome, Boolean emEstoque, Integer quantidadeEmEstoque, LocalDate criadoEm, LocalDate atualizadoEm, Medida medida, String marca, Tag tipo) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.emEstoque = emEstoque;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.medida = medida;
        this.marca = marca;
        this.tipo = tipo;
    }
}
