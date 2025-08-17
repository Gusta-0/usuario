
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
* **Maven**
* **Docker** 🐳
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


## ⚙️ Executando o Projeto

1. Clone o repositório

```bash
git clone https://github.com/Gusta-0/usuario.git
```

2. Configure seu banco PostgreSQL (se for produção)
3. Execute o projeto:

```bash
mvn spring-boot:run
```

4. Acesse a API em:

```
http://localhost:8080/api
```

---

## 📚 Aprendizado

* Spring Boot e Spring Security 🔒
* JWT Authentication
* JPA/Hibernate com PostgreSQL
* Gestão de perfis de configuração (dev/prod)
* Boas práticas de API REST

---

## 📝 Observações

* Este projeto é **simples e escalável**, podendo ser integrado a outras funcionalidades como agendamento de tarefas, microserviços, etc.
* O código já está preparado para **produção**, usando PostgreSQL como banco principal.


