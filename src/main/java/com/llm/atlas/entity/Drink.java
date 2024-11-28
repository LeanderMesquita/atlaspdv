package com.llm.atlas.entity;

import com.llm.atlas.entity.enums.Medida;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drink extends Item{

    private Integer volume;
    private Boolean alcoolico;
    private Float teorAlcoolico;
    private Boolean gaseificada;

    public Drink(Double preco, String nome, Boolean emEstoque, Integer quantidadeEmEstoque, Medida medida, Set<Insumo> insumos, Integer volume, Boolean alcoolico, Float teorAlcoolico, Boolean gaseificada) {
        super(preco, nome, emEstoque, quantidadeEmEstoque, medida, insumos);
        this.volume = volume;
        this.alcoolico = alcoolico;
        this.teorAlcoolico = teorAlcoolico;
        this.gaseificada = gaseificada;
    }
}
