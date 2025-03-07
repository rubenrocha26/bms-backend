# Birds Management System (BMS)

## Descrição

O Birds Management System (BMS) é uma aplicação Spring Boot para gerenciar informações sobre aves. A aplicação permite criar, ler, atualizar e deletar registros de aves, incluindo detalhes como nome científico, mutação, anel de identificação e data de nascimento.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.3
- Maven
- JPA (Hibernate)
- MySQL
- JUnit 5

## Estrutura do Projeto

- `src/main/java/dev/well/bms/entity`: Contém as entidades JPA.
- `src/main/java/dev/well/bms/dto`: Contém os Data Transfer Objects (DTOs).
- `src/main/java/dev/well/bms/factory`: Contém as fábricas para criar entidades e DTOs.
- `src/main/java/dev/well/bms/mapper`: Contém os mapeadores para converter entre entidades e DTOs.
- `src/main/java/dev/well/bms/repository`: Contém os repositórios JPA.
- `src/main/java/dev/well/bms/service`: Contém as interfaces de serviço.
- `src/main/java/dev/well/bms/service/impl`: Contém as implementações dos serviços.
- `src/test/java/dev/well/bms`: Contém os testes unitários.

## Configuração do Banco de Dados

A aplicação utiliza MySQL como banco de dados. Certifique-se de configurar as propriedades de conexão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bms
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
