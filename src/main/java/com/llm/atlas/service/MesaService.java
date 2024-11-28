package com.llm.atlas.service;

import com.llm.atlas.dto.MesaDto;
import com.llm.atlas.entity.Mesa;
import com.llm.atlas.repository.MesaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    MesaRepository repository;

    public List<Mesa> getAll(){
        return repository.findAll();
    }

    public Mesa getById(Integer id){
        Optional<Mesa> mesa = repository.findById(id);
        return mesa.orElseThrow(() -> new EntityNotFoundException("Mesa não encontrado."));
    }

    public void create(MesaDto dto){
        Mesa mesa = new Mesa(
                dto.numeracaoMesa()
        );

        repository.save(mesa);
    }

    public void update(Integer id, MesaDto dto){
        Mesa mesa = getById(id);

        mesa.setId(mesa.getId());
        mesa.setNumeracaoMesa(dto.numeracaoMesa());
        mesa.setOcupada(dto.ocupada());
        mesa.setPedidos(dto.pedidos());

        repository.save(mesa);
    }

    public void delete(Integer id){
        Mesa mesa = getById(id);
        repository.delete(mesa);
    }

}
