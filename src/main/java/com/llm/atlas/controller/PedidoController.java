package com.llm.atlas.controller;

import com.llm.atlas.docs.PedidoDocs;
import com.llm.atlas.dto.PedidoDto;
import com.llm.atlas.dto.PedidoRequestDto;
import com.llm.atlas.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController implements PedidoDocs{

    @Autowired
    PedidoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<PedidoDto>> getAll(){

        List<PedidoDto> pedidos = service.getAll().stream().map(PedidoDto::new).toList();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<PedidoDto> getById(@PathVariable String id){
        PedidoDto pedido = new PedidoDto(service.getById(UUID.fromString(id)));
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> create(@Valid @RequestBody PedidoRequestDto dto){
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody PedidoRequestDto dto){
        service.update(UUID.fromString(id), dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
