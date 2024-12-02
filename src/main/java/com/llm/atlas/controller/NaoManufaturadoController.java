package com.llm.atlas.controller;

import com.llm.atlas.docs.NaoManufaturadoDocs;
import com.llm.atlas.dto.NaoManufaturadoDto;
import com.llm.atlas.service.NaoManufaturadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nao-manufaturado")
public class NaoManufaturadoController implements NaoManufaturadoDocs {


    @Autowired
    NaoManufaturadoService service;

    @PostMapping("/criar")
    public ResponseEntity<?> create(@Valid @RequestBody NaoManufaturadoDto dto){
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody NaoManufaturadoDto dto){
        service.update(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
