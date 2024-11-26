package com.llm.atlas.service;

import com.llm.atlas.dto.FuncionarioDto;
import com.llm.atlas.entity.Funcionario;
import com.llm.atlas.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAll(){
        return funcionarioRepository.findAll();
    }

    public Funcionario getById(UUID id){
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        return funcionario.orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }

    public void create(FuncionarioDto dto){
        Funcionario func = new Funcionario(dto.nome());
        funcionarioRepository.save(func);
    }

    public void update(UUID id, FuncionarioDto dto){

        Funcionario funcToUpdate = getById(id);
        funcToUpdate.setNome(dto.nome());

        funcionarioRepository.save(funcToUpdate);
    }
    public void delete(UUID id){
        Funcionario func = getById(id);
        funcionarioRepository.delete(func);
    }


}
