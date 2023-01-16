# Teste

Desenvolva um serviço, utilizando Spring Boot com mensageria, seguindo as etapas:

- 1 - Desenvolver um Endpoint para receber uma imagem, nome do arquivo da imagem, tipo da imagem (content type).
- 2 - Salvar a imagem em um storage compatível com AWS S3.
- 3 - Enviar as informações de nome do arquivo da imagem, tipo da imagem e URL da imagem gravada no S3 para um serviço de mensageria.
- 4- Para a mensageria poderá ser utilizado Kafka, RabbitMQ ou ActiveMQ.
- 5 - Desenvolver um Consumer para receber as informações enviadas ao serviço de mensageria.
- 6 - Gravar as informações numa tabela com o nome TBL_Dados_Image, usando o banco de dados Postgresql.
- 7 - Disponibilizar o código fonte num repositório público do GitHub e nos encaminhar.

### Requisitos
- Java 11
- MySql
- RabbitMQ
- Bucket Amazon S3

### Instalação
- Adicionar as credenciais do S3 Bucket no arquivo application.properties
- Criar a fila rabbitmq.queue
- Rodar o script (mysql) que se encontra resources/dbcreate.sql
- Rodar o TesteApplication

### Swagger
http://localhost:8080/swagger-ui.html
