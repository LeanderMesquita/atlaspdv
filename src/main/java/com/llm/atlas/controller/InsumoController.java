package com.llm.atlas.controller;

import com.llm.atlas.docs.InsumoDocs;
import com.llm.atlas.dto.InsumoDto;
import com.llm.atlas.service.InsumoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insumos")
public class InsumoController implements InsumoDocs {

    @Autowired
    InsumoService service;


    @GetMapping("/listar")
    public ResponseEntity<List<InsumoDto>> getAll(){

        List<InsumoDto> insumos = service.getAll().stream().map(InsumoDto::new).toList();
        return new ResponseEntity<>(insumos, HttpStatus.OK);

    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<InsumoDto> getById(@PathVariable Integer id){

        InsumoDto insumo = new InsumoDto(service.getById(id));
        return new ResponseEntity<>(insumo, HttpStatus.OK);

    }

    @PostMapping("/criar")
    public ResponseEntity<Void> create(@RequestBody InsumoDto dto){

        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody InsumoDto dto){

        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
