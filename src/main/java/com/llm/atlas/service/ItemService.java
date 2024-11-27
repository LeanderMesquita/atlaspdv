package com.llm.atlas.service;

import com.llm.atlas.entity.Item;
import com.llm.atlas.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    public List<Item> getAll(){
        return repository.findAll();
    }

    public Item getById(Integer id){
        Optional<Item> item = repository.findById(id);
        return item.orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));
    }

    public void delete(Integer id){
        Item item = getById(id);
        repository.delete(item);
    }
}
