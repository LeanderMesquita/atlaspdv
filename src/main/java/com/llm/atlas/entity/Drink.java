package com.llm.atlas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Bebida extends Item{

    @Id
    @GeneratedValue
    private Long id;
    private Integer volume;
    private List<Insumo> insumos;
    private Boolean alcoolico;
    private Double teorAlcoolico;
    private Boolean gaseificada;

}
