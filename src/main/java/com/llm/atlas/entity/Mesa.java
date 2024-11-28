package com.llm.atlas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mesa_sequence")
    @SequenceGenerator(name = "mesa_sequence", sequenceName = "mesa_sequence", allocationSize = 1)
    private Integer Id;

    private Integer numeracaoMesa;
    private Instant permanencia;
    private Boolean ocupada;
    private Double valorTotal;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    public Mesa(Integer numeracaoMesa) {
        this.numeracaoMesa = numeracaoMesa;
        this.ocupada = true;
        this.valorTotal = 0.0;
    }
}
