# Gerenciamento-Alunos-Spring

## Sobre
Este projeto é um sistema de gerenciamento de alunos, que permite cadastrar, atualizar, pesquisar e excluir alunos de uma base de dados. Além disso, permite filtrar os alunos por status (ativo, inativo, trancado e cancelado).

## Características
* Cadastro de alunos com validação de campos
* Atualização de dados dos alunos
* Pesquisa de alunos por nome
* Filtro de alunos por status (ativo, inativo, trancado e cancelado)
* Exclusão de alunos

## Tecnologias utilizadas
* Java
* Spring Boot
* JPA (Java Persistence API)
* Hibernate
* Thymeleaf

## Dependências do projeto
* Model
* javax.persistence
* javax.validation
* lombok

## Enum
* CursoEnum
* StatusEnum

## DAO
* JpaRepository
* Query (Spring Data JPA)

## Controller
* HomeController
* AlunoController

## Como executar o projeto
1. Clone o repositório em sua máquina local
2. Importe o projeto em sua IDE favorita (Eclipse, IntelliJ, etc.)
3. Configure o banco de dados de sua preferência no arquivo application.properties
4. Execute a aplicação usando a IDE ou através do terminal com o comando ./mvnw spring-boot:run
5. Acesse a aplicação no navegador em http://localhost:8080

## Funcionalidades da aplicação
* Cadastro de Alunos
* Inserir nome, curso, matrícula, status e turno
* Validação dos campos (tamanho mínimo, campos obrigatórios)
* Atualização de Alunos
* Alterar os dados dos alunos cadastrados
* Pesquisa de Alunos
* Pesquisar alunos por nome
* Filtro de Alunos por Status
* Listar alunos ativos
* Listar alunos inativos
* Listar alunos trancados
* Listar alunos cancelados
* Exclusão de Alunos
* Excluir alunos cadastrados
