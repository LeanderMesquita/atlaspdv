package com.llm.atlas.controller;


import com.llm.atlas.dto.FuncionarioDto;
import com.llm.atlas.service.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDto>> getAll(){
        List<FuncionarioDto> funcs = service.getAll().stream().map(FuncionarioDto::new).toList();

        return new ResponseEntity<>(funcs, HttpStatus.OK);
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try {
            FuncionarioDto func = new FuncionarioDto(service.getById(UUID.fromString(id)));
            return new ResponseEntity<>(func, HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<?> create(@Valid @RequestBody FuncionarioDto dto){
        try {
            service.create(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody FuncionarioDto dto){
        try {
            service.update(UUID.fromString(id), dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            service.delete(UUID.fromString(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }

}
