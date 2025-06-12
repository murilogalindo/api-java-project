# api_project

## Plano de Testes – API Sicredi

Este projeto automatiza a validação da API pública da Sicredi, garantindo que seus endpoints estejam funcionais e de acordo com o esperado.

## Objetivo

Validar os principais endpoints da API da Sicredi, verificando:
- Códigos de status HTTP esperados
- Estrutura e conteúdo das respostas
- Comportamento em cenários válidos e inválidos

## Tipos de Testes Implementados
- Teste funcional: Verifica se o endpoint responde corretamente (status 200, 201 etc.)
- Teste de contrato: Confirma a estrutura e tipos dos campos no JSON de resposta
- Teste negativo: Simula dados inválidos para verificar tratamento de erros

## Ferramentas utilizadas

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

```text
src/
└── test/
    └── java
        ├── BaseTest.java
        ├── AuthTests.java
        ├── ProductsTests.java
        ├── UsersTests.java
        └── HealthTests.java
```


## Geração de relatórios

- Foi utilizada a ferramenta ExtentReports
- Relatório é salvo na pasta target com o nome "extent-report.html"

## CI/CD 

- O projeto foi configurado para rodar na Pipeline
- A pipeline no GitLab executa automaticamente os testes em cada push na branch main e salva o relatório como artefato.
- https://gitlab.com/murilogalindo/api_project/-/pipelines

## Bugs e Melhoras

**Melhorias**

Melhoria 1:
Endpoint GET/test - inserir na documentação mais cenários de erros, como 404 Not Fould. (com uma tratativa)

Melhoria 2:
Endpoint GET/user - poderia ter mais documentado mais cenários de erros, como 404 Not Fould. (com uma tratativa)
- Também alguma trativa

Melhoria 3:
Endpoint POST/auth/login - poderia ter mais documentado mais cenários de erros, como 404 Invalid credentials, 401 Unauthorized, 500 Internal Server Error.

Melhoria 4:
Endpoint POST /products/add - inserir mais status de cenários de erro, como 404 Not Found

**Bugs**

Bug 1:
Produtos estão sendo criados sempre com o mesmo ID

Bug 2:
Endpoint GET /auth/products - está exibindo uma mesagem diferente da documentação para o Response - 401 Unauthorized

Documentação:
{
    "name": "JsonWebTokenError",
    "message": "Invalid/Expired Token!"
}

Resultado da API:
{
    "message": "Token Expired!"
}

Bug 3:
Endpoint GET /auth/products - ao inserirmos um accessToken inválido, o retorno deveria ser 403 Unauthorized
- Ma está mostrando 500 Internal Server Error

Documentação:
accessToken - Inválido, expirado ou inexistente
{		
	message: "Authentication Problem"
}

Resultado da API:
{
    "message": "invalid token"
}

Bug 4:

Endpoint POST /products/add - também mostra sucesso 201 Created se retirar o "s" do "products". ex: /auth/product/add

## Atualizações

- Acrescentar mais cenários negativos nos testes
- Organizar melhor a Suite de testes

## Contato

- Autor: Murilo Galindo
- Email: murilomag.galindo@gmail.com
- Linkedin: https://www.linkedin.com/in/murilogalindo/