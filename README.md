# This application contains a basic structure required to setup any new spring boot project.


### Prerequisites

1. Java 17
2. Mysql
3. Liquibase
4. Sonarqube
5. Swagger
6. Integration tests
7. Unit tests

### How to run integration tests
Integration tests uses testcontainer in which mysql will run inside a docker container
use command 
```shell
docker-compose up -d
```
to run docker-compose.xml

### How to use swagger
Run your server then swagger can be use [here](http://localhost:8080/skeleton/swagger-ui/index.html#/person-controller/createPerson)
