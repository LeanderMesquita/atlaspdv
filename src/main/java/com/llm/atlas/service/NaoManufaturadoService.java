package com.llm.atlas.service;

import com.llm.atlas.dto.NaoManufaturadoDto;
import com.llm.atlas.entity.Item;
import com.llm.atlas.entity.NaoManufaturado;
import com.llm.atlas.repository.NaoManufaturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaoManufaturadoService {

    @Autowired
    NaoManufaturadoRepository repository;

    @Autowired
    ItemService itemService;

    public void create(NaoManufaturadoDto dto){
        NaoManufaturado naoManufaturado = new NaoManufaturado(
                dto.preco(),
                dto.nome(),
                dto.emEstoque(),
                dto.quantidadeEmEstoque(),
                dto.medida(),
                null,
                dto.marca(),
                dto.tipo()
        );

        repository.save(naoManufaturado);
    }

    public void update(Integer id, NaoManufaturadoDto dto){
        Item item = itemService.getById(id);

        if (!(item instanceof NaoManufaturado naoManufaturado)) {
            throw new IllegalArgumentException("O item com o ID fornecido não é do tipo Nao Manufaturado.");
        }

        naoManufaturado.setId(naoManufaturado.getId());
        naoManufaturado.setPreco(dto.preco());
        naoManufaturado.setNome(dto.nome());
        naoManufaturado.setEmEstoque(dto.emEstoque());
        naoManufaturado.setQuantidadeEmEstoque(dto.quantidadeEmEstoque());
        naoManufaturado.setMedida(dto.medida());
        naoManufaturado.setMarca(dto.marca());
        naoManufaturado.setTipo(dto.tipo());

        repository.save(naoManufaturado);

    }

}
