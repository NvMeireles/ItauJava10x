# 💰 Desafio Técnico Itaú 

API REST desenvolvida em **Java e Spring Boot** como parte do desafio **Itaú Java 10x**.

O projeto permite realizar o gerenciamento de transações e consultar estatísticas das transações realizadas dentro de um período configurado.

---

## 🚀 Tecnologias utilizadas

- ☕ Java 17
- 🍃 Spring Boot 4.1.0
- 🌐 Spring Web MVC
- ✅ Spring Validation
- 📝 Lombok
- 📦 Maven
- 📚 Swagger / OpenAPI
- 📄 YAML

---

## 📌 Funcionalidades

- Criar uma transação
- Validar os dados da transação
- Deletar todas as transações
- Consultar estatísticas das transações
- Calcular:
  - Quantidade de transações
  - Soma dos valores
  - Média
  - Menor valor
  - Maior valor
- Considerar apenas as transações realizadas dentro do período configurado
- Documentação da API com Swagger/OpenAPI
- Registro de eventos e erros através de logs

---

## 🔄 Endpoints

### ➕ Criar transação

**POST** `/transacao`

Exemplo de requisição:

```json
{
  "valor": 100.50,
  "dataHora": "2026-09-17T10:00:00-03:00"
}
````

Resposta:

```text
201 Created
```

---

### 🗑️ Deletar transações

**DELETE** `/transacao`

Remove todas as transações armazenadas.

Resposta:

```text
200 OK
```

---

### 📊 Consultar estatísticas

**GET** `/estatistica`

Retorna as estatísticas das transações realizadas dentro do período configurado.

Exemplo de resposta:

```json
{
  "count": 3,
  "sum": 350.50,
  "avg": 116.83333333333333,
  "min": 50.00,
  "max": 200.50
}
```

---

## ⏱️ Configuração das estatísticas

O período utilizado para calcular as estatísticas pode ser configurado através do arquivo `application.yml`.

Por padrão:

```yaml
estatistica:
  segundos: 60
```

Dessa forma, a API considera as transações realizadas nos últimos **60 segundos**.

Esse valor pode ser alterado sem precisar modificar o código da aplicação.

---

## 📚 Documentação da API

O projeto utiliza **Swagger/OpenAPI** para documentação e teste dos endpoints.

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

Através do Swagger é possível visualizar os endpoints, parâmetros, respostas e testar as requisições diretamente pelo navegador.

---

## 🏗️ Estrutura do projeto

```text
src
└── main
    ├── java
    │   └── dev.java10x.ItauJava10x
    │       ├── Config
    │       ├── Docs
    │       ├── Estatisticas
    │       ├── TransacaoRepository
    │       ├── TransacaoRequest
    │       ├── TransacaoService
    │       └── TransacoesController
    │
    └── resources
        └── application.yml
```

---

## ⚙️ Como executar o projeto

### Pré-requisitos

Antes de executar o projeto, você precisa ter instalado:

* Java 17
* Maven

### 📥 Clonando o projeto

```bash
git clone https://github.com/NvMeireles/ItauJava10x.git
```

Entre na pasta do projeto:

```bash
cd ItauJava10x
```

### ▶️ Executando

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## 🎯 Objetivo

Este projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento de **APIs REST utilizando Java e Spring Boot**, incluindo:

* Criação de endpoints REST
* Validação de dados
* Injeção de dependências
* Organização do código
* Configuração através do `application.yml`
* Uso de Streams
* Uso de `DoubleSummaryStatistics`
* Tratamento de erros
* Logs
* Documentação com Swagger/OpenAPI

---

## 👨‍💻 Autor

**Nicolas Vieira Meireles**

Estudante de Ciência da Computação e desenvolvedor em formação, com foco em **Java e desenvolvimento backend**.

---

```
```
