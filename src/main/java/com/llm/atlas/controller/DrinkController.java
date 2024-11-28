package com.llm.atlas.controller;

import com.llm.atlas.dto.DrinkDto;
import com.llm.atlas.service.DrinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drink")
public class DrinkController {

    @Autowired
    DrinkService service;

    @PostMapping("/criar")
    public ResponseEntity<?> create(@Valid @RequestBody DrinkDto dto) {
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody DrinkDto dto){
        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
