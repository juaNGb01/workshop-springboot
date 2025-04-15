# 📦 API REST com Spring Boot

# 🚀 Sobre o Projeto 

Este projeto é uma aplicação web service desenvolvidade utilizando Spring Boot, e tem como objetivo forcenecer uma API REST que seja capaz de permitir o gerenciamente de produtos e pedidos. 
O projeto visa mostrar como realizar operações de escrita, letiura, edição e remoção de uma forma mais prática utilizando o framework SpringBoot em conjunto com a linguagem Java

## 🛠️ Tecnologias Utilizadas
- **Java**: Linguagem principal do projeto  
- **Spring Boot**: Framework que simplifica o desenvolvimento da aplicação  
- **Spring Data JPA**: Abstração para persistência de dados e integração com banco de dados  
- **Hibernate**: Implementação JPA usada para o mapeamento objeto-relacional (ORM)  
- **H2 Database**: Banco de dados em memória para facilitar testes  
- **Postman**: Ferramenta para testar requisições HTTP na API  

# Como executar o projeto: 

Clone o repositório: git clone https://github.com/juaNGb01/workshop-springboot.git

Navegue até o diretório do projeto: cd seu-projeto

Execute o comando mvn spring-boot:run para iniciar a aplicação.

A aplicação estará disponível em: http://localhost:8080

## 📌Endpoints para teste

**Remoção:**  
DELETE: localhost:8080/users/{id}  

**Atualiazação:**  
PUT: localhost:8080/users/{id}  
Body (JSON):

`{
 "name": "Bob Brown",
 "email": "bob@gmail.com",
 "phone": "977557755"
}`

**Busca de usuário por ID**  
GET: localhost:8080/users/{id}

**Listar todos os usuários**  
GET: localhost:8080/users

**Inserir Usuário**  
POST: localhost:8080/users  
Body (JSON):

`{
 "name": "Bob Brown",
 "email": "bob@gmail.com",
 "phone": "977557755",
 "password": "123456"
}`


