package com.llm.atlas.service;

import com.llm.atlas.dto.PedidoDto;
import com.llm.atlas.entity.Pedido;
import com.llm.atlas.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public List<Pedido> getAll(){
        return repository.findAll();
    }

    public Pedido getById(UUID id){
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));
    }

    public void create(PedidoDto dto){
        Pedido pedido = new Pedido(
                dto.itens(),
                dto.mesa(),
                dto.responsavel()
        );

        repository.save(pedido);
    }

    public void update(UUID id, PedidoDto dto){
        Pedido pedido = getById(id);

        pedido.setItens(dto.itens());
        pedido.setMesa(dto.mesa());

        repository.save(pedido);
    }

    public void delete(UUID id){
        Pedido pedido = getById(id);
        repository.delete(pedido);
    }

}
