package com.llm.atlas.entity;

import com.llm.atlas.entity.enums.Medida;
import com.llm.atlas.entity.enums.Tag;
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
@Table(name = "nao_manufaturados")
public class NaoManufaturado extends Item{

    private String marca;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Tag tipo;

    public NaoManufaturado(Double preco, String nome, Boolean emEstoque, Integer quantidadeEmEstoque, Medida medida, Set<Insumo> insumos, String marca, Tag tipo) {
        super(preco, nome, emEstoque, quantidadeEmEstoque, medida, insumos);
        this.marca = marca;
        this.tipo = tipo;
    }
}
