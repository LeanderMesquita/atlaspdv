package com.llm.atlas.controller;

import com.llm.atlas.dto.MesaDto;
import com.llm.atlas.service.MesaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
public class MesaController {


    @Autowired
    MesaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<MesaDto>> getAll(){

        List<MesaDto> pedidos = service.getAll().stream().map(MesaDto::new).toList();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<MesaDto> getById(@PathVariable Integer id){
        MesaDto pedido = new MesaDto(service.getById(id));
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> create(@Valid @RequestBody MesaDto dto){
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody MesaDto dto){
        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
