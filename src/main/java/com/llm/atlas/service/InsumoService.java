package com.llm.atlas.service;

import com.llm.atlas.dto.InsumoDto;
import com.llm.atlas.entity.Insumo;
import com.llm.atlas.repository.InsumoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {


    @Autowired
    InsumoRepository repository;

    public List<Insumo> getAll(){
        return repository.findAll();
    }

    public Insumo getById(Integer id){
        Optional<Insumo> insumo = repository.findById(id);
        return insumo.orElseThrow(() -> new EntityNotFoundException("Insumo não cadastrado"));
    }

    public void create(InsumoDto dto){
        Insumo insumo = new Insumo(
                dto.nome(),
                dto.medida(),
                dto.quantidade(),
                dto.preco());

        repository.save(insumo);
    }

    public void update(Integer id, InsumoDto dto){
        Insumo insumoToUpdate = getById(id);

        insumoToUpdate.setId(insumoToUpdate.getId());
        insumoToUpdate.setNome(dto.nome());
        insumoToUpdate.setMedida(dto.medida());
        insumoToUpdate.setQuantidade(dto.quantidade());
        insumoToUpdate.setPreco(dto.preco());

        repository.save(insumoToUpdate);
    }

    public void delete(Integer id){
        Insumo insumo = getById(id);
        repository.delete(insumo);
    }
}
