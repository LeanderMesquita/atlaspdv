package com.llm.atlas.entity;

import com.llm.atlas.entity.enums.Medida;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "insumo_sequence")
    @SequenceGenerator(name = "insumo_sequence", sequenceName = "insumo_sequence", allocationSize = 1)
    private Integer id;
    private String nome;

    @ManyToMany(mappedBy = "insumos")
    private Set<Item> itens;

    @Enumerated(EnumType.STRING)
    private Medida medida;
    private Integer quantidade;
    private Double preco;

}
