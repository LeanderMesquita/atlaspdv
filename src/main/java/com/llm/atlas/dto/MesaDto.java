package com.llm.atlas.dto;

import com.llm.atlas.entity.Mesa;
import com.llm.atlas.entity.Pedido;

import java.util.List;

public record MesaDto (
        Integer numeracaoMesa,
        Boolean ocupada,
        Double valorTotal,
        List<Pedido> pedidos
) {
    public MesaDto (Mesa mesa){
        this(
                mesa.getNumeracaoMesa(),
                mesa.getOcupada(),
                mesa.getValorTotal(),
                mesa.getPedidos()
        );
    }
}
