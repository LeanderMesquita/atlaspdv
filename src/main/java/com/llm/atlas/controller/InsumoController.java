package com.llm.atlas.controller;

import com.llm.atlas.dto.InsumoDto;
import com.llm.atlas.service.InsumoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insumos")
public class InsumoController {

    @Autowired
    InsumoService service;


    @GetMapping("/listar")
    public ResponseEntity<List<InsumoDto>> getAll(){
        List<InsumoDto> insumos = service.getAll().stream().map(InsumoDto::new).toList();

        return new ResponseEntity<>(insumos, HttpStatus.OK);
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            InsumoDto insumo = new InsumoDto(service.getById(id));
            return new ResponseEntity<>(insumo, HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> create(@RequestBody InsumoDto dto){
        try {
            service.create(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody InsumoDto dto){
        try {
            service.update(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
