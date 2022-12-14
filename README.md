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
- GitHub - [Ros??lia Padoin](https://github.com/rosalia-oliveira)


</br>
<p align="left">
  <img src="https://img.shields.io/badge/Vers??o: Portugu??s-black?style=for-the-badge">
</p>

## API desafio_testing
Desenvolvimento de uma API REST para uma Corretora de im??veis, que permita manipular os dados de Im??veis, bairros e c??modos. A API foi criada com valida????es dos campos e Testes unit??rios da camada de Service.

### Habilidades
Aplicar os conte??dos dados at?? o momento durante o
Programa de acelera????o MeLi (Git, Java e Spring), com ??nfase principal nas **valida????es** e
tipos de **teste** que podem ser usados a partir de uma proposta, especifica????o de
requisitos e documenta????o anexa.

MSC
- Estruturar a API conforme as boas pr??ticas seguindo a arquitetura MSC e alguns princ??pios do SOLID:
    - Model: Repons??vel por modelar as entidades.
    - Repository: ?? a camada de persist??nca de dados. Neste projeto, ?? respons??vel por manipular as vari??veis que armazenam os dados, simulando um banco de dados.
    - Service: Camada onde gerenciamos as regras de n??gocio.
    - Controller: Respons??vel por receber as requisi????es e enviar as respostas.
    - Advisor: Respons??vel por gerenciar as exce????es da aplica????o.

Tecnologias
- O desafio foi realizado utilizando Java 11 com Spring Boot, suas anota????es de valida????o somando as depend??ncias:
    - Spring Boot DevTools.
    - Spring Boot Web.
    - Spring Boot Validation.
    - Lombok.
    - JUnit.
    - Mockito.


### O que foi desenvolvido
Foi desenvolvida a rota `/property` para criar e listar todas as propriedades da plataforma de Im??veis conforme a prefer??ncia do cliente. 
Ainda no escopo das propriedades, foi implementada a rota `/room/{id}`, respons??vel por buscar uma determinada propriedade e retornar o maior c??modo existente na mesma.


As rotas utilizadas foram idealizadas para deixar a aplica????o mais din??mica e funcional para o p??blico alvo.

### Valida????es

Entre as anota????es de __valida????o__ do Spring Boot, que foram utilizadas na camada de Model de cada entidade, est??o:

- __NotBlank__, para validar que um campo de String n??o pode estar vazio;


- __NotNull__, para validar um campo num??rico que n??o pode estar nulo;


- __Size__, para determinar o tamanho m??nimo ou m??ximo de um Objeto ou String;


- __Min__ / __Max__, para validar o valor m??nimo ou m??ximo de um campo num??rico;


- __Pattern__, com a utiliza????o de Regex para validar uma determinada formata????o em uma String;


### Testes

Os testes de unidades foram feitos utilizando o JUnit para as assertions e Mockito para fazer os Mocks. 

A camada de Service foi testada, com cobertura de 100% de linhas, verificando os m??todos de cria????o de propriedade, de retorno da lista de propriedades e de pesquisa do maior c??modo de uma propriedade. 



### Documenta????o da API
A ferramenta escolhida para documentar a API foi o Postman e JavaDoc para o projeto. 

:warning: Acesse a documenta????o do Postman [aqui](https://documenter.getpostman.com/view/23653402/2s847ESZzK).


## Como acessar o projeto
:warning: Acessar o reposit??rio do desafio [aqui](https://github.com/wave7-grupo3/desafio_testing)

Abrir o terminal e digitar as informa????es na sequ??ncia:
- Realizar o clone do projeto:
    - SSH: `git clone git@github.com:wave7-grupo3/desafio_testing.git`
    - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_testing.git`

- Ter o ambiente configurado para vizualiza????o de projetos java.
- Gerar a documenta????o do JavaDocs:
  - Na barra superior da IDE IntelliJ, selecionar a aba `Tools`;
  - Em seguida, selecionar `generate JavaDoc`;


## Autores
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Ros??lia Padoin](https://github.com/rosalia-oliveira)


