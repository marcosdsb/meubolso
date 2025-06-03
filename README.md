# MeuBolso

Projeto de controle financeiro pessoal desenvolvido com Java 21, Spring Boot 3, PostgreSQL, MapStruct e Swagger para aprendizado e uso pessoal.

---

## Funcionalidades

- Controle de despesas (fixas, variáveis, parceladas e recorrentes)
- Controle de créditos e investimentos
- Registro de abastecimentos de veículo
- Gerenciamento de categorias, empresas, formas e status de pagamento
- Documentação da API com Swagger
- Versionamento do banco de dados com Flyway

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.5
- PostgreSQL
- MapStruct
- Flyway
- Swagger (springdoc-openapi)
- Maven

---

## Como rodar localmente

**1. Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/meubolso.git
cd meubolso
```

**2. Configure o banco PostgreSQL (crie o banco, configure usuário e senha).**

**3. Atualize as propriedades do banco no `application.properties`:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seubanco
spring.datasource.username=seuusuario
spring.datasource.password=suasenha
```

**4. Rode a aplicação:**
```bash
./mvnw spring-boot:run
```

**5. Acesse a documentação da API pelo navegador em:**
```
http://localhost:8080/swagger-ui/index.html
```
