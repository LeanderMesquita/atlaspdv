package com.llm.atlas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.llm.atlas.entity.enums.Medida;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "insumos")
    private Set<Item> itens;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Medida medida;
    private Integer quantidade;
    private Double preco;

    public Insumo(String nome, Medida medida, Integer quantidade, Double preco) {
        this.nome = nome;
        this.medida = medida;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
