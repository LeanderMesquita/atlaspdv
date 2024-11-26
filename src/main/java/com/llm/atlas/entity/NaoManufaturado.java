package com.llm.atlas.entity;

import com.llm.atlas.entity.enums.Tag;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "nao_manufaturados")
public class NaoManufaturado extends Item{

    private String marca;
    @Enumerated(EnumType.STRING)
    private Tag tipo;

}
