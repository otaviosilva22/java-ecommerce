# Backend Java Spring Boot para um sistema de vendas
Simples exemplo de APIs para o funcionamento básico de um sistema de vendas.

## Tecnologias utilizadas
- [Java Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Docker](https://www.docker.com/)
- [MySQL](https://www.mysql.com/)
- [Lombook](https://projectlombok.org/)
- [Org JSON](https://mvnrepository.com/artifact/org.json/json)
- [Dev Tools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)

## 🚀 Como iniciar?

Certifique-se que o ambiente Java esteja previamente instalado. Após isso, siga o seguintes passos:

<ul>
    <li><a href='#docker' style='color: inherit'>1. Configuração do MySQL</a></li>
    <li><a href='#properties' style='color: inherit'>2. Propriedades da Aplicação</a></li>
    <li><a href='#start' style='color: inherit'>3. Inicialização do Sring Boot</a></li>
    <li><a href='#apis' style='color: inherit'>4. Utilização das APIs</a>
</ul>

## <span id='docker'>1. Configuração do MySQL</span>
É necessário que o MySQL esteja ativo e em funcionamento. Caso não tenha o banco instalado, utilize do container Docker preparado para o sistema.

Defina um usuário e senha para o seu banco:

```yml
#docker-compose.yml

version: "3"

services:
  mysql:
    image: mysql:8.0.27
    container_name: saledatabase
    environment:
      MYSQL_ROOT_PASSWORD: <root_password>
      MYSQL_USER: <user>
      MYSQL_PASSWORD: <user_password>
      MYSQL_DATABASE: saledatabase
    ports:
      - "3306:3306"
```

Inicie o container:

```bash
docker compose up
```

### <span id="properties">2. Propriedades da Aplicação</span>

Substitua o arquivo application.properties pelas credenciais definidas no container:

```properties
#application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/saledatabase
spring.datasource.username=<user>
spring.datasource.password=<user_password>

```

### <span id="start">3. Inicialização do Sistema</span>

```bash
mvn spring-boot:run
```

```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v3.0.12)
```

### <span id='apis'>4. Utilização das APIs</span>

A documentação das APIs pode ser acessada clicando <a href='https://otaviosilva22.github.io/java-springboot-saleproject/'>aqui.</a>

## Autor
Otávio Augusto Souza Silva.


[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/otaviosilva22/)](https://www.linkedin.com/in/otaviosilva22/)
[![Gmail Badge](https://img.shields.io/badge/-Gmail-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:otavio.ssilva22@gmail.com)](mailto:otavio.ssilva22@gmail.com)