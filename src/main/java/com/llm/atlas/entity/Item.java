package com.llm.atlas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.llm.atlas.entity.enums.Medida;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1)
    private Integer id;

    private Double preco;
    private String nome;
    private Boolean emEstoque;
    private Integer quantidadeEmEstoque;

    @CreatedDate
    private LocalDate criadoEm;

    @LastModifiedDate
    private LocalDate atualizadoEm;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Medida medida;

    @ManyToMany
    @JoinTable(
            name = "item_insumo",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "insumo_id")
    )
    private Set<Insumo> insumos;

    @JsonIgnore
    @ManyToMany(mappedBy = "itens")
    private Set<Pedido> pedidos = new HashSet<>();


    public Item(Double preco, String nome, Boolean emEstoque, Integer quantidadeEmEstoque, Medida medida, Set<Insumo> insumos) {
        this.preco = preco;
        this.nome = nome;
        this.emEstoque = emEstoque;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.medida = medida;
        this.insumos = insumos;
    }


}
