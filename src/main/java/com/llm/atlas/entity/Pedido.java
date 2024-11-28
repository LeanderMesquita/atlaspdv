package com.llm.atlas.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pedido {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "item_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario responsavel;

    @CreationTimestamp
    private Instant horaPedido;

    @UpdateTimestamp
    private Instant horaCancelamento;
    private Double valorPedido;

    public Pedido(List<Item> itens, Mesa mesa, Funcionario responsavel) {
        this.itens = itens;
        this.mesa = mesa;
        this.responsavel = responsavel;
    }
}
