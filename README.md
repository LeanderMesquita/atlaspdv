# Atlas PDV

**Atlas PDV** é um sistema de ponto de venda desenvolvido para atender especificamente restaurantes, com uma lógica orientada a microsserviços que permite rápida implementação e treinamento. O objetivo principal do sistema é oferecer uma solução eficiente e acessível para pequenas empresas que não possuam infraestruturas de hardware robustas.

## Visão Geral

O sistema de ponto de venda (PDV) do **Atlas PDV** conta também com funcionalidades para o controle de estoque, permitindo que os usuários mantenham um controle eficiente dos produtos e insumos em seu negócio. Todo o projeto está sendo desenvolvido com a ideia de ser ágil na implantação e simples de usar para pequenos restaurantes e comércios.

Este projeto foi desenvolvido como parte de um projeto de extensão de ensino superior, com foco em aplicações práticas e no desenvolvimento de soluções tecnológicas que possam beneficiar pequenos empreendedores.

## Funcionalidades
- Sistema de ponto de venda voltado para restaurantes.
- Controle de estoque integrado ao PDV.
- Implementação orientada a microsserviços, visando maior escalabilidade e facilidade de manutenção.

## Documentação da API

Caso esteja testando localmente, você pode acessar a documentação usando o link:

```
http://localhost:8085/api/v1/swagger-ui/index.html
```

A documentação fornece uma visão completa dos endpoints disponíveis no sistema, facilitando o desenvolvimento e a integração de novos módulos.

## Migrations do Banco de Dados

Todo o gerenciamento do banco de dados foi realizado com o **Flyway**, permitindo um controle de versão robusto das migrações. Os scripts de criação e modificação do banco de dados podem ser encontrados em:

```
src/main/resources/db/migration
```


## Objetivo do Projeto
O **Atlas PDV** visa se estabelecer no mercado de pequenas empresas e restaurantes, sendo uma solução rápida, eficiente e de fácil uso para quem precisa de um sistema de ponto de venda funcional, sem a necessidade de hardware de ponta.

## Contribuição
Este projeto foi desenvolvido como parte de um projeto de extensão de ensino superior, e contribuições são bem-vindas. Caso queira contribuir, sinta-se à vontade para abrir issues ou enviar pull requests.


