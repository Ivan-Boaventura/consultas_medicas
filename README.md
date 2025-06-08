# consultas_medicas 
# Consultas Médicas - Sistema de Gerenciamento de Consultas

Este projeto é um sistema backend para gerenciar consultas médicas entre pacientes e médicos, desenvolvido em Java usando Spring Boot. Possui funcionalidades para cadastro, busca, atualização e remoção de consultas, além de documentação da API via Swagger/OpenAPI.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- MySQL Connector/J
- Spring HATEOAS
- Springdoc OpenAPI (Swagger UI)
- Maven

---

## Estrutura do projeto

- `com.consultas.consultas_medicas.controllers` - Classes de controle REST (endpoints da API)
- `com.consultas.consultas_medicas.model` - Entidades JPA
- `com.consultas.consultas_medicas.model.service` - Serviços com lógica de negócio
- `com.consultas.consultas_medicas.config` - Configurações, como OpenAPI


```properties
spring.datasource.url=jdbc:mysql://localhost:3306/consultas_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
