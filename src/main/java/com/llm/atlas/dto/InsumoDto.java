package com.llm.atlas.dto;

import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.enums.Medida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsumoDto(
        Integer id,
        @NotBlank
        String nome,
        @NotNull
        Medida medida,
        Integer quantidade,
        Double preco
) {


    public InsumoDto(Insumo insumo){
        this(
                insumo.getId(),
                insumo.getNome(),
                insumo.getMedida(),
                insumo.getQuantidade(),
                insumo.getPreco()
        );
    }
}
