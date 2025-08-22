
# 🚀 Projeto: API de Usuários

Uma API simples para **gerenciamento de usuários**, utilizando **Spring Boot**, **Spring Security** e **PostgreSQL**.

---

## 🛠 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Security** 🔒
* **Spring Data JPA**
* **PostgreSQL** 🐘 (produção)
* **H2 Database** (desenvolvimento/testes)
* **Gradle**
* **Docker** 🐳 + **Docker Compose**
* **GitHub**

---

## ⚡ Funcionalidades

* 🔹 Cadastro e autenticação de usuários
* 🔹 Segurança com **JWT** e **Spring Security**
* 🔹 CRUD de usuários
* 🔹 Validações básicas de campos
* 🔹 Estrutura pronta para produção com PostgreSQL

---

## 📦 Estrutura do Projeto

```
src/main/java/com/exemplo/usuario
├── controller
├── service
├── repository
├── model
├── dto
├── security
└── exception
```

---

## 💾 Banco de Dados

* **Desenvolvimento:** H2 Database (em memória)
* **Produção:** PostgreSQL 🐘

---

## ⚙️ Executando o Projeto (Sem Docker)

1. Clone o repositório:

```bash
git clone https://github.com/Gusta-0/usuario.git
cd usuario
```

2. Configure seu banco PostgreSQL (se for produção).
3. Execute o projeto com Gradle Wrapper:

```bash
./gradlew bootRun
```

4. Acesse a API em:

```
http://localhost:8080/api
```

---

## 🐳 Executando com Docker

Este projeto já possui suporte a **Docker** com build multi-stage.
Para subir a aplicação isolada em container:

### 1. Construir a imagem:

```bash
docker build -t usuario-app .
```

### 2. Rodar o container:

```bash
docker run -p 8080:8080 usuario-app
```

A aplicação estará disponível em:
👉 [http://localhost:8080/api](http://localhost:8080/api)

---

## 🐳 Executando com Docker Compose (App + PostgreSQL + pgAdmin)

O projeto também inclui um `docker-compose.yml` para rodar toda a stack:

### 1. Subir os containers:

```bash
docker-compose up --build -d
```

### 2. Serviços disponíveis:

* **API** → [http://localhost:8080/api](http://localhost:8080/api)
* **pgAdmin** → [http://localhost:5050](http://localhost:5050)

    * Email: `admin@admin.com`
    * Senha: `admin`
    * Host de conexão ao banco: `db`

### 3. Parar os containers:

```bash
docker-compose down
```

---

## 📚 Aprendizado

* Spring Boot e Spring Security 🔒
* JWT Authentication
* JPA/Hibernate com PostgreSQL
* Gestão de perfis de configuração (`dev` / `prod`)
* Boas práticas de API REST
* Docker e Docker Compose 🐳

---

## 📝 Observações

* Este projeto é **simples e escalável**, podendo ser integrado a outras funcionalidades como agendamento de tarefas, microserviços, etc.
* O código já está preparado para **produção**, usando PostgreSQL como banco principal.

---