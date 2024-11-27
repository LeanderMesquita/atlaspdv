package com.llm.atlas.service;

import com.llm.atlas.dto.ComidaDto;
import com.llm.atlas.entity.Comida;
import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.Item;
import com.llm.atlas.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComidaService {

    @Autowired
    ComidaRepository repository;

    @Autowired
    ItemService itemService;

    public void create(ComidaDto dto){
        Comida comida = new Comida(
                dto.preco(),
                dto.nome(),
                dto.emEstoque(),
                dto.quantidadeEmEstoque(),
                dto.medida(),
                dto.insumos(),
                dto.porcao(),
                dto.rotulos()
        );
        repository.save(comida);
    }

    public void update(Integer id, ComidaDto dto){

        Item item = itemService.getById(id);

        if (!(item instanceof Comida comida)) {
            throw new IllegalArgumentException("O item com o ID fornecido não é do tipo Comida.");
        }

        comida.setId(comida.getId());
        comida.setPreco(dto.preco());
        comida.setNome(dto.nome());
        comida.setEmEstoque(dto.emEstoque());
        comida.setQuantidadeEmEstoque(dto.quantidadeEmEstoque());
        comida.setMedida(dto.medida());
        comida.setInsumos(dto.insumos());
        comida.setPorcao(dto.porcao());
        comida.setRotulos(dto.rotulos());

        repository.save(comida);

    }
}
