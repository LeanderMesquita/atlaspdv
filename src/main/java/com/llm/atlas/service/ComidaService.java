package com.llm.atlas.service;

import com.llm.atlas.dto.ComidaDto;
import com.llm.atlas.entity.Comida;
import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.Item;
import com.llm.atlas.repository.ComidaRepository;
import com.llm.atlas.repository.InsumoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ComidaService {

    @Autowired
    ComidaRepository repository;

    @Autowired
    InsumoRepository insumoRepository;

    @Autowired
    ItemService itemService;

    public void create(ComidaDto dto){
        Set<Insumo> insumos = new HashSet<>();
        for(Insumo insumo : dto.insumos()){
            Insumo persistInsumo = insumoRepository.findByNome(insumo.getNome())
                    .orElseThrow(() -> new EntityNotFoundException("Insumo não encontrado"));
            insumos.add(persistInsumo);
        }

        Comida comida = new Comida(
                dto.preco(),
                dto.nome(),
                dto.emEstoque(),
                dto.quantidadeEmEstoque(),
                dto.medida(),
                insumos,
                dto.porcao(),
                dto.rotulos()
        );
        repository.save(comida);
    }

    public void update(Integer id, ComidaDto dto){

        Set<Insumo> insumos = new HashSet<>();
        for(Insumo insumo : dto.insumos()){
            Insumo persistInsumo = insumoRepository.findByNome(insumo.getNome())
                    .orElseThrow(() -> new EntityNotFoundException("Insumo não encontrado"));
            insumos.add(persistInsumo);
        }

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
        comida.setInsumos(insumos);
        comida.setPorcao(dto.porcao());
        comida.setRotulos(dto.rotulos());

        repository.save(comida);

    }
}
