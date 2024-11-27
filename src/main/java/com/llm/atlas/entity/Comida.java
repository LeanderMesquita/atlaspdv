package com.llm.atlas.entity;

import com.llm.atlas.entity.enums.Medida;
import com.llm.atlas.entity.enums.Rotulo;
import jakarta.persistence.Entity;
import lombok.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comida extends Item{

    private Integer porcao;

    private List<Rotulo> rotulos;


    public Comida(
            Double preco,
            String nome,
            Boolean emEstoque,
            Integer quantidadeEmEstoque,
            Medida medida,
            Set<Insumo> insumos,
            Integer porcao,
            List<Rotulo> rotulos)
    {
        super(preco, nome, emEstoque, quantidadeEmEstoque, medida, insumos);
        this.porcao = porcao;
        this.rotulos = rotulos;
    }
}
