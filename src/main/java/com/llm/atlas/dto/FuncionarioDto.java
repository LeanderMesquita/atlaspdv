package com.llm.atlas.dto;

import com.llm.atlas.entity.Funcionario;
import jakarta.validation.constraints.NotBlank;

public record FuncionarioDto(

        String id,
        @NotBlank
        String nome
) {
    public FuncionarioDto (Funcionario func){
        this(
                func.getId().toString(),
                func.getNome()
        );
    }

}
