package com.llm.atlas.controller;

import com.llm.atlas.entity.Item;
import com.llm.atlas.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Item>> getAll(){
        List<Item> itens = service.getAll();
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @GetMapping("/visualizar/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Item item = service.getById(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
