package com.llm.atlas.entity;

import jakarta.persistence.Entity;
import lombok.*;


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

}
