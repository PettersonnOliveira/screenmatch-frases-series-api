# Screenmatch Frases Series API 🎬✨

Este é o backend da aplicação Screenmatch Frases Series, construído com **Spring Boot 3.x** e **Java 21**, utilizando **Spring Data JPA** para persistência de dados em um banco de dados **PostgreSQL**. Esta API foi desenvolvida como parte do desafio Alura para complementar o projeto frontend Screenmatch.

## 🌟 Visão Geral

A API oferece um endpoint RESTful que entrega frases aleatórias de filmes e séries, juntamente com informações como título, personagem e pôster. É o coração do sistema que alimenta a interface do usuário com conteúdo dinâmico.

## 🚀 Tecnologias Utilizadas

* **Java 21:** Linguagem de programação principal.
* **Spring Boot 3.x:** Framework para desenvolvimento rápido de APIs REST.
* **Spring Data JPA:** Simplifica o acesso a dados e a interação com o banco de dados.
* **Hibernate:** Implementação padrão do JPA utilizada.
* **PostgreSQL:** Banco de dados relacional para armazenamento das frases.
* **Maven:** Gerenciador de dependências do projeto.
* **Spring DevTools:** Ferramentas para agilizar o desenvolvimento.

## 🛠️ Como Rodar o Projeto

Siga os passos abaixo para configurar e rodar o projeto em sua máquina local.

### Pré-requisitos

Certifique-se de ter o seguinte software instalado:

* **JDK 21** ou superior
* **Maven**
* **PostgreSQL** (com pgAdmin ou outra ferramenta para gerenciar o banco)
* **IntelliJ IDEA** (ou sua IDE Java preferida)

### Configuração do Banco de Dados

1.  **Crie um banco de dados PostgreSQL:**
    * Nome: `frases_aleatorias_db` (ou o nome que preferir)
    * Certifique-se de ter um usuário e senha configurados (ou use os padrões do PostgreSQL).

2.  **Configure o arquivo `application.properties`:**
    * No diretório `src/main/resources`, localize o arquivo `application.properties`.
    * Atualize as propriedades de conexão com o banco de dados conforme sua configuração:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/frases_aleatorias_db
    spring.datasource.username={{SEU_USUARIO_POSTGRES}}
    spring.datasource.password={{SUA_SENHA_POSTGRES}}
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

3.  **Popule o Banco de Dados:**
    * Após a primeira execução da aplicação (com `ddl-auto=update`), o Spring Data JPA criará a tabela `frase`.
    * Use o pgAdmin (ou qualquer cliente SQL) para executar os comandos `INSERT` com as frases que você deseja popular no banco de dados. Exemplo:

    ```sql
    INSERT INTO frase (titulo, frase, personagem, poster) VALUES
    ('Grey''s Anatomy', 'A vida é uma série de escolhas. Algumas são fáceis, outras são difíceis, mas todas são importantes.', 'N/A', '[https://m.media-amazon.com/images/M/MV5BYTJjYmQwMmItNDBlYi00ODU3LTg5YzQtYThlM2JjYmQ3MTIxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg](https://m.media-amazon.com/images/M/MV5BYTJjYmQwMmItNDBlYi00ODU3LTg5YzQtYThlM2JjYmQ3MTIxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg)'),
    -- Adicione todas as suas frases aqui
    ('Lupin', 'A vingança é um prato que se serve frio, mas a justiça é um prato que se serve com sabedoria.', 'N/A', '[https://m.media-amazon.com/images/M/MV5BMmM2NzcxOTUtMzg4NC00ZTg2LWE5YzYtMWY1MWJmZjU5YWE0XkEyXkFqcGdeQXVyMTE0MzQwMDgy._V1_FMjpg_UX1000_.jpg](https://m.media-amazon.com/images/M/MV5BMmM2NzcxOTUtMzg4NC00ZTg2LWE5YzYtMWY1MWJmZjU5YWE0XkEyXkFqcGdeQXVyMTE0MzQwMDgy._V1_FMjpg_UX1000_.jpg)');
    ```

### Executando a Aplicação Backend

1.  **Abra o projeto no IntelliJ IDEA.**
2.  **Compile o projeto** (Maven: `clean install` ou `Build -> Rebuild Project`).
3.  **Execute a classe principal** `ScreenmatchFrasesSeriesApplication.java` (geralmente clicando no botão 'play' verde ao lado do `main` método ou no navegador do projeto).

A aplicação será iniciada na porta `8080` por padrão.

### Configuração do CORS (para o Frontend)

Esta API está configurada para permitir requisições Cross-Origin (CORS) do seu frontend. A configuração é feita através da classe `CorsConfig`.

* **Classe:** `src/main/java/com/example/Screenmatch_frases_series/config/CorsConfig.java`
* **Origem Permitida:** Atualmente configurada para `http://127.0.0.1:5500`. Se o seu frontend estiver em outra URL (ex: `http://localhost:3000`), você precisará atualizar esta linha:

    ```java
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("[http://127.0.0.1:5500](http://127.0.0.1:5500)") // <-- Altere para a URL do seu frontend se necessário
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    ```

## 🌐 Endpoints da API

A API expõe o seguinte endpoint principal:

* **GET `/series/frases`**
    * **Descrição:** Retorna uma frase aleatória de filme/série do banco de dados.
    * **Exemplo de Resposta (JSON):**
        ```json
        {
          "id": 1,
          "titulo": "Grey's Anatomy",
          "frase": "A vida é uma série de escolhas. Algumas são fáceis, outras são difíceis, mas todas são importantes.",
          "poster": "[https://m.media-amazon.com/images/M/MV5BYTJjYmQwMmItNDBlYi00ODU3LTg5YzQtYThlM2JjYmQ3MTIxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg](https://m.media-amazon.com/images/M/MV5BYTJjYmQwMmItNDBlYi00ODU3LTg5YzQtYThlM2JjYmQ3MTIxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg)",
          "personagem": "N/A"
        }
        ```

Você pode testar este endpoint diretamente no seu navegador acessando `http://localhost:8080/series/frases`.

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias ou correções.

## 📄 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

## 👨‍💻 Autor

Feito por **Petterson Oliveira** Aluno do programa **Oracle Next Education - ONE** e **Tecnólogo da faculdade Celso Lisboa** 🚀
