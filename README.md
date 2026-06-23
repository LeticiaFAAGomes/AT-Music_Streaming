<div align="center">

# 🎵 Music Streaming API

### Assessment — Domain Driven Design

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![H2](https://img.shields.io/badge/H2-003545?style=for-the-badge&logo=databricks&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-CA4245?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

---

</div>

# 📚 Sumário

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Regras de Negócio](#-regras-de-negócio)
- [Arquitetura](#-arquitetura)
- [Tecnologias](#-tecnologias)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Como Executar](#-como-executar)
- [Banco de Dados](#-banco-de-dados)
- [Endpoints da API](#-endpoints-da-api)
- [Exemplos de Requisições](#-exemplos-de-requisições)
- [Autor](#-autor)
- [Licença](#-licença)

---

# 🎯 Sobre o Projeto

O **Music Streaming API** é uma API REST desenvolvida com **Spring Boot** para gerenciamento de usuários, assinaturas, playlists, músicas favoritas e autorização de transações.

O projeto foi modelado utilizando os conceitos de:

- Domain-Driven Design (DDD)
- Clean Architecture
- SOLID
- Repository Pattern
- Domain Services
- Context Mapping

---

# 🚀 Funcionalidades

### 👤 Gestão de Contas

- Criar conta de usuário
- Associar cartão de crédito
- Consultar informações da conta

### 💳 Assinaturas

- Assinar planos
- Cancelar assinatura
- Validar assinatura ativa

### 💰 Transações

- Autorizar transações
- Aplicar regras antifraude
- Registrar histórico de transações

### 🎵 Música

- Criar playlists
- Adicionar músicas às playlists
- Favoritar músicas
- Remover músicas dos favoritos

---

# 🛡️ Regras de Negócio

| #   | Regra                                                                             |
| --- | --------------------------------------------------------------------------------- |
| 1   | O cartão de crédito deve estar ativo                                              |
| 2   | O usuário deve possuir assinatura ativa                                           |
| 3   | Máximo de 3 transações em um intervalo de 2 minutos                               |
| 4   | Máximo de 2 transações com mesmo valor e comerciante em um intervalo de 2 minutos |

---

# 🏗️ Arquitetura

A aplicação foi construída utilizando **DDD (Domain-Driven Design)** com **Bounded Contexts**.

## Diagrama de Contextos

![Texto Alternativo](img\music-streaming-api.drawio.png)

## Contextos Delimitados

### 👤 Conta

Responsável por:

- Usuários
- Cartões de crédito
- Cadastro de contas

### 💳 Assinatura

Responsável por:

- Planos
- Assinaturas
- Controle de acesso

### 💰 Transação

Responsável por:

- Autorizações
- Pagamentos
- Regras antifraude

### 🎵 Música

Responsável por:

- Playlists
- Favoritos
- Catálogo de músicas

## Camadas

### Entity

![Texto Alternativo](img\CamadaEntity.png)

### Controller

![Texto Alternativo](img\CamadaController.png)

### Service

![Texto Alternativo](img\CamadaService.png)

### Repository

![Texto Alternativo](img\CamadaRepository.png)

---

# 🛠️ Tecnologias

| Tecnologia      | Versão |
| --------------- | ------ |
| Java            | 11     |
| Spring Boot     | 2.7    |
| Spring Data JPA | 2.7    |
| Maven           | 3.8+   |
| H2 Database     | --     |
| Lombok          | --     |
| Swagger/OpenAPI | --     |

---

# 📂 Estrutura do Projeto

```text
music-streaming-api
│
├── conta
│   ├── api
│   ├── application
│   ├── domain
│   └── infrastructure
│
├── assinatura
│   ├── api
│   ├── application
│   ├── domain
│   └── infrastructure
│
├── transacao
│   ├── api
│   ├── application
│   ├── domain
│   └── infrastructure
│
├── musica
│   ├── api
│   ├── application
│   ├── domain
│   └── infrastructure
│
└── compartilhado
    ├── dto
    ├── exceptions
    └── handler
```

## 🏛 Organização Arquitetural

### 🌐 API Layer

Responsável pela exposição dos endpoints REST.

### ⚙️ Application Layer

Responsável pela orquestração dos casos de uso.

### 🧠 Domain Layer

Contém as regras de negócio, entidades, agregados e serviços de domínio.

### 🔧 Infrastructure Layer

Implementações técnicas, persistência e integrações externas.

---

## 🌍 Contextos Delimitados (Bounded Contexts)

### 👤 Conta (Account Context)

Gerenciamento de usuários e cartões de crédito.

### 💳 Assinatura (Subscription Context)

Gerenciamento de planos e assinaturas.

### 💰 Transação (Transaction Context)

Autorização de pagamentos e regras antifraude.

### 🎵 Música (Music Context)

Gerenciamento de playlists, músicas e favoritos.

### 🔄 Shared Kernel

Componentes compartilhados entre os contextos.

---

# ▶️ Como Executar

## Pré-requisitos

- Java 11+
- Maven 3.8+
- Git

### Clonar Repositório

```bash
git clone https://github.com/seu-usuario/music-streaming-api.git
```

### Entrar na Pasta

```bash
cd music-streaming-api
```

### Compilar Projeto

```bash
mvn clean install
```

### Executar Aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

---

# 🗄️ Banco de Dados

A aplicação utiliza banco em memória **H2 Database**.

## Console H2

```text
http://localhost:8080/h2-console
```

### Configurações

```text
JDBC URL: jdbc:h2:mem:streamerdb
User Name: sa
Password:
```

---

# 🌐 Endpoints da API

| Método | Endpoint                                       | Descrição           |
| ------ | ---------------------------------------------- | ------------------- |
| POST   | /api/contas                                    | Criar conta         |
| POST   | /api/assinaturas                               | Assinar plano       |
| POST   | /api/transacoes                                | Autorizar transação |
| POST   | /api/playlists                                 | Criar playlist      |
| POST   | /api/playlists/{idPlaylist}/musicas/{idMusica} | Adicionar música    |
| POST   | /api/favoritos                                 | Favoritar música    |
| DELETE | /api/favoritos                                 | Remover favorito    |

---

# 📨 Exemplos de Requisições

## Criar Conta

### POST /api/contas

```json
{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "numeroCartao": "1234567890123456",
  "cartaoAtivo": true
}
```

---

## Assinar Plano

### POST /api/assinaturas

```json
{
  "idConta": 1,
  "plano": "PREMIUM"
}
```

---

## Autorizar Transação

### POST /api/transacoes

```json
{
  "idConta": 1,
  "valor": 29.90,
  "comerciante": "Spotify"
}
```

---

## Criar Playlist

### POST /api/playlists

```json
{
  "idConta": 1,
  "nome": "Rock Nacional"
}
```

---

## Adicionar Música

### POST /api/playlists/1/musicas/10

```json
{}
```

---

## Favoritar Música

### POST /api/favoritos

```json
{
  "idConta": 1,
  "idMusica": 10
}
```

---

## Remover Favorito

### DELETE /api/favoritos

```json
{
  "idConta": 1,
  "idMusica": 10
}
```

---

# 👨‍💻 Autora

Letícia Gomes Projeto desenvolvido para a disciplina de Projeto de Bloco de Desenvolvimento de Softwares Escaláveis.

---

# 📄 Licença

Este projeto está licenciado sob a licença MIT.

---
