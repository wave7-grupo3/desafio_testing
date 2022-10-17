# :ballot_box_with_check: Challenge Testing

<p align="right">
  <img src="https://img.shields.io/badge/Project completed-black?style=for-the-badge">
</p>

<p align="left">
  <img src="https://img.shields.io/badge/Version: English-black?style=for-the-badge">
</p>

## API challenge_testing
Development of a REST API for a Real Estate Brokerage, that allows manipulation of Properties, neighborhoods and rooms data. The API was created with field validations and Service layer unit tests.

### Skills
Apply the content given so far during the
MeLi acceleration program (Git, Java and Spring), with main emphasis on the **validations** and
types of **tests** that can be used from a proposal, specification of
requirements and attached documentation.

MSC
- Structure the API according to good practices following the MSC architecture and some SOLID principles:
  - Model: Responsible for modeling the entities.
  - Repository: This is the data persistence layer. In this project, it is responsible for manipulating the variables that store the data, simulating a database.
  - Service: Layer where we manage the business rules.
  - Controller: Responsible for receiving the requests and sending the answers.
  - Advisor: Responsible for managing the application's exceptions.

Technologies
- The challenge was carried out using Java 11 with Spring Boot, its validation annotations adding dependencies:
  - Spring Boot DevTools.
  - Spring Boot Web.
  - Spring Boot Validation.
  - Lombok.
  - JUnit.
  - Mockito.


### What was developed
The `/property` route was developed to create and list all properties of the Real Estate platform according to the client's preference.
Still in the scope of properties, the `/room/{id}` route was implemented, responsible for searching a certain property and returning the biggest room in it.


The routes used were designed to make the application more dynamic and functional for the target audience.

### Validations

Among Spring Boot's __validation__ annotations, which were used in the Model layer of each entity, are:

- __NotBlank__, to validate that a String field cannot be empty;


- __NotNull__, to validate that a numeric field cannot be null;


- __Size__, to determine the minimum or maximum size of an Object or String;


- __Min__ / __Max__, to validate the minimum or maximum value of a numeric field;


- __Pattern__, using Regex to validate a certain formatting in a String;


### Testing

The unit tests were done using JUnit for the assertions and Mockito to do the Mocks.

The Service layer was tested, with 100% line coverage, checking the methods for creating a property, for returning the property list and for searching the largest room for a property.


### API Documentation
The tool chosen to document the API was Postman and JavaDoc for the project.

:warning: Access the documentation from Postman [here](https://documenter.getpostman.com/view/23653402/2s847ESZzK).


## How to access the project
:warning: Access the challenge repository [here](https://github.com/wave7-grupo3/desafio_spring)

Open the terminal and type the information in the sequence:
- Perform the clone of the project:
    - SSH: `git clone git@github.com:wave7-grupo3/desafio_testing.git`
    - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_testing.git`

- Have the environment configured to view java projects.
- Generate JavaDocs documentation:
- On the top bar of the IntelliJ IDE, select the `Tools` tab;
- Then select `generate JavaDoc`;


## Authors
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Rosália Padoin](https://github.com/rosalia-oliveira)


</br>
<p align="left">
  <img src="https://img.shields.io/badge/Versão: Português-black?style=for-the-badge">
</p>

## API desafio_testing
Desenvolvimento de uma API REST para uma Corretora de imóveis, que permita manipular os dados de Imóveis, bairros e cômodos. A API foi criada com validações dos campos e Testes unitários da camada de Service.

### Habilidades
Aplicar os conteúdos dados até o momento durante o
Programa de aceleração MeLi (Git, Java e Spring), com ênfase principal nas **validações** e
tipos de **teste** que podem ser usados a partir de uma proposta, especificação de
requisitos e documentação anexa.

MSC
- Estruturar a API conforme as boas práticas seguindo a arquitetura MSC e alguns princípios do SOLID:
    - Model: Reponsável por modelar as entidades.
    - Repository: É a camada de persistênca de dados. Neste projeto, é responsável por manipular as variáveis que armazenam os dados, simulando um banco de dados.
    - Service: Camada onde gerenciamos as regras de négocio.
    - Controller: Responsável por receber as requisições e enviar as respostas.
    - Advisor: Responsável por gerenciar as exceções da aplicação.

Tecnologias
- O desafio foi realizado utilizando Java 11 com Spring Boot, suas anotações de validação somando as dependências:
    - Spring Boot DevTools.
    - Spring Boot Web.
    - Spring Boot Validation.
    - Lombok.
    - JUnit.
    - Mockito.


### O que foi desenvolvido
Foi desenvolvida a rota `/property` para criar e listar todas as propriedades da plataforma de Imóveis conforme a preferência do cliente. 
Ainda no escopo das propriedades, foi implementada a rota `/room/{id}`, responsável por buscar uma determinada propriedade e retornar o maior cômodo existente na mesma.


As rotas utilizadas foram idealizadas para deixar a aplicação mais dinâmica e funcional para o público alvo.

### Validações

Entre as anotações de __validação__ do Spring Boot, que foram utilizadas na camada de Model de cada entidade, estão:

- __NotBlank__, para validar que um campo de String não pode estar vazio;


- __NotNull__, para validar um campo numérico que não pode estar nulo;


- __Size__, para determinar o tamanho mínimo ou máximo de um Objeto ou String;


- __Min__ / __Max__, para validar o valor mínimo ou máximo de um campo numérico;


- __Pattern__, com a utilização de Regex para validar uma determinada formatação em uma String;


### Testes

Os testes de unidades foram feitos utilizando o JUnit para as assertions e Mockito para fazer os Mocks. 

A camada de Service foi testada, com cobertura de 100% de linhas, verificando os métodos de criação de propriedade, de retorno da lista de propriedades e de pesquisa do maior cômodo de uma propriedade. 



### Documentação da API
A ferramenta escolhida para documentar a API foi o Postman e JavaDoc para o projeto. 

:warning: Acesse a documentação do Postman [aqui](https://documenter.getpostman.com/view/23653402/2s847ESZzK).


## Como acessar o projeto
:warning: Acessar o repositório do desafio [aqui](https://github.com/wave7-grupo3/desafio_testing)

Abrir o terminal e digitar as informações na sequência:
- Realizar o clone do projeto:
    - SSH: `git clone git@github.com:wave7-grupo3/desafio_testing.git`
    - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_testing.git`

- Ter o ambiente configurado para vizualização de projetos java.
- Gerar a documentação do JavaDocs:
  - Na barra superior da IDE IntelliJ, selecionar a aba `Tools`;
  - Em seguida, selecionar `generate JavaDoc`;


## Autores
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Rosália Padoin](https://github.com/rosalia-oliveira)


