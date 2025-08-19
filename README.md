# API de Autenticação com JWT

Uma API RESTful desenvolvida em **Spring Boot** que implementa autenticação de usuários utilizando **JWT (JSON Web Token)**.

---

## 🔹 Tecnologias

- Java 21
- Spring Boot 3.5.4
- Spring Security
- JWT
- PostgreSQL
- Maven

---

## 🔹 Funcionalidades

- Registro de usuários
- Login com email e senha
- Geração de token JWT
- Proteção de rotas com JWT
- Retorno de token no formato JSON

---

## 🔹 Documentação da API

A API possui documentação interativa via **Swagger UI**, permitindo testar os endpoints diretamente no navegador.

Após rodar a aplicação, acesse:

http://localhost:8080/swagger-ui/index.html

Lá você pode:

- Visualizar todos os endpoints disponíveis
- Consultar parâmetros e respostas esperadas
- Testar requisições diretamente no browser

---

## 🔹 Como rodar o projeto

1. Clone o repositório:

````
git clone https://github.com/seu-usuario/seu-repo.git
cd seu-repo
````

2. Configure o banco de dados (application.properties ou application.yml):

```
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Compile e rode:

```
mvn clean spring-boot:run
```

4. Teste os endpoints com Postman ou Insomnia.
