package com.llm.atlas.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Funcionario {

    @Id
    @GeneratedValue
    private UUID id;
    private	String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    public Funcionario(String nome) {
        this.nome = nome;
    }
}
