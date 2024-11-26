package com.llm.atlas.entity;

import com.llm.atlas.entity.enums.Rotulo;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comida extends Item{

    private Integer porcao;
    private List<Rotulo> rotulos;

}
