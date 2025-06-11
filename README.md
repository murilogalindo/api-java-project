# api_project



## Getting started

Este projeto contém uma suíte de testes automatizados para a API do desafio Sicredi, desenvolvida utilizando Java, Rest-Assured, JUnit 5 e ExtentReports.

Antes de executar os testes, certifique-se de ter os seguintes itens instalados:

- Java 21 ou superior
- Maven 3.8+ ou compatível
- Git
- Junit 5
- IntelliJ IDEA (recomendado)
- RestAssured 5.5

## Clonando o projeto

- bash
- git clone https://gitlab.com/murilogalindo/api_project.git
- cd: sapi_project

## Configuração

- Verifique se o servidor da API do desafio está rodando em http://'dummyjson.com
- Se necessário, atualize a URL base no arquivo BaseTest.java:

## Executando os testes

- Pelo terminal (usando Maven)
mvn clean test

- Pelo IntelliJ
- Abra o projeto no IntelliJ.
- Vá até o diretório src/test/java.
- Clique com o botão direito na pasta tests ou em uma classe específica e selecione Run Tests.

## Endpoints testados

- GET /test – Teste de saúde da API
- GET /users – Listagem de usuários
- POST /auth/login – Login e autenticação
- GET /auth/products – Produtos protegidos
- POST /products/add – Adição de produto
- GET /products – Listagem pública de produtos
- GET /products/{id} – Consulta individual de produto

# Estrutura do projeto

src/
└── test/
    └── java
                    ├── BaseTest.java
                    ├── AuthTests.java
                    ├── ProductsTests.java
                    ├── UsersTests.java
                    └── HealthTests.java

## Geração de relatórios

- Foi utilizada a ferramenta ExtentReports
- Relatório é salvo na pasta target com o nome "extent-report.html"

## CI/CD 

- O projeto foi configurado para rodar na Pipeline
- https://gitlab.com/murilogalindo/api_project/-/pipelines

## Atualizações

- Acrescentar mais cenários negativos nos testes
- Organizar melhor a Suite de testes

## Contato

- Autor: Murilo Galindo
- Email: murilomag.galindo@gmail.com
- Linkedin: https://www.linkedin.com/in/murilogalindo/