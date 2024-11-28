package com.llm.atlas.service;

import com.llm.atlas.dto.DrinkDto;
import com.llm.atlas.entity.Drink;
import com.llm.atlas.entity.Insumo;
import com.llm.atlas.entity.Item;
import com.llm.atlas.repository.DrinkRepository;
import com.llm.atlas.repository.InsumoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DrinkService {

    @Autowired
    DrinkRepository repository;

    @Autowired
    InsumoRepository insumoRepository;

    @Autowired
    ItemService itemService;

    public void create(DrinkDto dto){
        Set<Insumo> insumos = new HashSet<>();
        for(Insumo insumo : dto.insumos()){
            Insumo persistInsumo = insumoRepository.findByNome(insumo.getNome())
                    .orElseThrow(() -> new EntityNotFoundException("Insumo não encontrado"));
            insumos.add(persistInsumo);
        }

        Drink drink = new Drink(
                dto.preco(),
                dto.nome(),
                dto.emEstoque(),
                dto.quantidadeEmEstoque(),
                dto.medida(),
                insumos,
                dto.volume(),
                dto.alcoolico(),
                dto.teorAlcoolico(),
                dto.gaseificada()
        );
        repository.save(drink);
    }

    public void update(Integer id, DrinkDto dto){
        Set<Insumo> insumos = new HashSet<>();
        for(Insumo insumo : dto.insumos()){
            Insumo persistInsumo = insumoRepository.findByNome(insumo.getNome())
                    .orElseThrow(() -> new EntityNotFoundException("Insumo não encontrado"));
            insumos.add(persistInsumo);
        }

        Item item = itemService.getById(id);

        if (!(item instanceof Drink drink)) {
            throw new IllegalArgumentException("O item com o ID fornecido não é do tipo Drink.");
        }

        drink.setId(drink.getId());
        drink.setPreco(dto.preco());
        drink.setNome(dto.nome());
        drink.setEmEstoque(dto.emEstoque());
        drink.setQuantidadeEmEstoque(dto.quantidadeEmEstoque());
        drink.setMedida(dto.medida());
        drink.setInsumos(insumos);
        drink.setVolume(dto.volume());
        drink.setAlcoolico(dto.alcoolico());
        drink.setTeorAlcoolico(dto.teorAlcoolico());
        drink.setGaseificada(dto.gaseificada());

        repository.save(drink);

    }
}
