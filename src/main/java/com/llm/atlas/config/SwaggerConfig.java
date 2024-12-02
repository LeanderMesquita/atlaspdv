package com.llm.atlas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Atlas PDV")
                        .description("API do módulo de vendas do ecossistema atlas.")
                        .version("v1")
                )
                .tags(
                        Arrays.asList(
                                new Tag().name("Mesa").description("Rotas referentes à gestão das mesas"),
                                new Tag().name("Pedido").description("Rotas de controle sob pedidos."),
                                new Tag().name("Funcionário").description("Rotas para gestão de funcionários."),
                                new Tag().name("Item").description("Rotas referentes a visualização e exclusão de todos os tipos de itens."),
                                new Tag().name("Drink").description("Rotas para inserção e atualização de drinks."),
                                new Tag().name("Comida").description("Rotas para inserção e atualização de comidas."),
                                new Tag().name("Não Manufaturados").description("Rotas para inserção e atualização de não manufaturados."),
                                new Tag().name("Insumo").description("Rotas para gestão de insumos.")
                        )
                );
    }


}
