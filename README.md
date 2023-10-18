# Petx API
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Esse projeto é uma API feita com Java, Spring Boot, Maven, MySQL como banco de dados, Flyway Migrations, Spring Security para autenticação com JWT e Spring Doc para documentação.
É uma API desenvolvida para o Projeto Petx, um SaaS de uma clínica veterinária.

## Tabela de Conteúdos

- [Instalação](#instalação)
- [Configurações](#configurações)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)
- [Autenticação](#authentication)
- [Banco de dados](#banco-de-dados)
- [Contribuições](#contribuições)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/gguilhermelopes/petx-api.git
```
2. Instalar as dependências com o Maven.

3. Instalar o [MySQL](https://dev.mysql.com/doc/refman/8.1/en/installing.html).

## Configurações

1. Em application.properites, utilizar: `spring.profiles.active=dev`, isso ativará o modo de desenvolvimento e utilizará o seu banco de dados local, já com as migrations do Flyway.

## Uso

1. Iniciar aplicação.
2. A API estará disponível em `http://localhost:8080`.

## Endpoints da API
Para a documentação completa da API, e com a aplicação iniciada, acesse `http://localhost:8080/swagger-ui/index.html#/`

## Autenticação
A API utiliza o Spring Security para o controle de autenticação com os seguintes roles:

```
USER -> Usuários padrão do sistema.
ADMIN -> Usuários com permissões especiais, como especificado nos endpoints da API.
```

## Banco de dados
O projeto utiliza o [MySQL](https://dev.mysql.com/doc/refman/8.1/en/installing.html) como banco de dados. As migrations necessárias são feitas com o gerenciamento do Flyway.

## Contribuições

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões para melhorias, por favor, abra uma issue ou envie um pull request para o repositório.

Ao contribuir para este projeto, por favor, siga o estilo de código existente. Utilize, também, as [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas mudanças numa branch separada.
