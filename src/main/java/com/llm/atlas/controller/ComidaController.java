package com.llm.atlas.controller;

import com.llm.atlas.dto.ComidaDto;
import com.llm.atlas.service.ComidaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    ComidaService service;

    @PostMapping("/criar")
    public ResponseEntity<?> create(@Valid @RequestBody ComidaDto dto){
        try {
            service.create(dto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ComidaDto dto){
        try {
            service.update(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
