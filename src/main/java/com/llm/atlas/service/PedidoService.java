package com.llm.atlas.service;

import com.llm.atlas.dto.PedidoDto;
import com.llm.atlas.dto.PedidoRequestDto;
import com.llm.atlas.entity.Funcionario;
import com.llm.atlas.entity.Item;
import com.llm.atlas.entity.Mesa;
import com.llm.atlas.entity.Pedido;
import com.llm.atlas.repository.FuncionarioRepository;
import com.llm.atlas.repository.ItemRepository;
import com.llm.atlas.repository.MesaRepository;
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

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MesaService mesaService;

    @Autowired
    FuncionarioService funcionarioService;

    public List<Pedido> getAll(){
        return repository.findAll();
    }

    public Pedido getById(UUID id){
        Optional<Pedido> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));
    }

    public void create(PedidoRequestDto dto){

        List<Item> itens = itemRepository.findAllById(dto.itensId());
        Mesa mesa = mesaService.getById(dto.mesaId());
        Funcionario responsavel = funcionarioService.getById(UUID.fromString(dto.responsavelId()));

        Pedido pedido = new Pedido(
                itens,
                mesa,
                responsavel
        );

        repository.save(pedido);
    }

    public void update(UUID id, PedidoRequestDto dto){
        Pedido pedido = getById(id);

        List<Item> itens = itemRepository.findAllById(dto.itensId());
        Mesa mesa = mesaService.getById(dto.mesaId());
        Funcionario responsavel = funcionarioService.getById(UUID.fromString(dto.responsavelId()));

        pedido.setItens(itens);
        pedido.setMesa(mesa);
        pedido.setResponsavel(responsavel);

        repository.save(pedido);
    }

    public void delete(UUID id){
        Pedido pedido = getById(id);
        repository.delete(pedido);
    }

}
