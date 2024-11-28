package com.llm.atlas.dto;

import com.llm.atlas.entity.Funcionario;
import com.llm.atlas.entity.Item;
import com.llm.atlas.entity.Mesa;
import com.llm.atlas.entity.Pedido;

import java.util.List;

public record PedidoDto(
        String id,
        List<Item> itens,
        Mesa mesa,
        Funcionario responsavel
)
{
    public PedidoDto(Pedido pedido){
        this(
                pedido.getId().toString(),
                pedido.getItens(),
                pedido.getMesa(),
                pedido.getResponsavel()
        );
    }
}
