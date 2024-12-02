package com.llm.atlas.controller;


import com.llm.atlas.docs.FuncionarioDocs;
import com.llm.atlas.dto.FuncionarioDto;
import com.llm.atlas.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController implements FuncionarioDocs {

    @Autowired
    FuncionarioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDto>> getAll(){
        List<FuncionarioDto> funcs = service.getAll().stream().map(FuncionarioDto::new).toList();

        return new ResponseEntity<>(funcs, HttpStatus.OK);
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<FuncionarioDto> getById(@PathVariable String id){
        FuncionarioDto func = new FuncionarioDto(service.getById(UUID.fromString(id)));
        return new ResponseEntity<>(func, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> create(@Valid @RequestBody FuncionarioDto dto){

        service.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody FuncionarioDto dto){

        service.update(UUID.fromString(id), dto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        service.delete(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
