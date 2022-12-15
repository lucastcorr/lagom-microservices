# Exercício (Lagom 1.5)
Este exercício tem como objetivo testar os conhecimentos adquiridos durante os estudos da Framework
Lagom, este só deve ser iniciado depois de perceber
os conceitos base (CQRS, Event Driven, Event Sourcing),
e para isso devem ser lidos os tutoriais enviados no e-mail.

O Exercício a ser implementado deve seguir a imagem dentro da pasta `docs`
na raiz do projeto, alguns módulos já estão criados (user e post), mas incompletos

O Exercício tem como base 4 micro-serviços:
User Service
Post Service
Emoji Service
Notification Service

User Service -> deve guardar a informação do Utilizador
Post Service -> deve guardar a informação do Post
Emoji Service -> deve guardar a informação do Emoji
Notification Service -> deverá enviar uma notificação de um post criado para um websocket (pode-se usar o Postman que nas últimas versões já tem um cliente webSocket)

Os campos a serem gravados em cada entidade nos serviços acima estão especificados na imagem dentro da pasta `docs`, assim como as suas operações

Importante :warning: Ao serviço do Post, User e Emoji deve ainda ser adicionada uma operação de GET por Id

As comunicações entre os vários serviços estão especificatas no ficheiro de exercicio (HTTP, Kafka)

Os serviços não estão a arrancar porque faltam classes, como por exemplo o `PostModule`, `UserModule`, etc

O application.conf apenas contém algumas definições,
terão de ser adicionadas mais configurações(essas configurações
são explicadas durante o estudo da framework), como por exemplo a adição do caminho para o `Module`

Para a implementação das entidades devem ser seguidas as indicações no seguinte link
https://www.lagomframework.com/documentation/1.5.x/java/PersistentEntity.html


## Nota

- O Exercício deve contemplar o ReadSide (Não sendo prioritário) com recurso a uma base de dados PostgreSQL
- Quem implementa o exercício, pode arrancar com um projeto
  completamente novo (por exemplo, o projeto de exemplo do site do lagom (escolher versão java + sbt))
- Pode-se usar um IDE à escolha (Intellij, Visual Studio Code)
- Devem ser instalados os plugins Lombok, scala, sbt executer

## Dicas

Para criar uma ligação à base de dados (que arranca automaticamente com o projeto)
podem usar TablePlus (gratuito)

host: 127.0.0.1<br/>
port: 4011

Podem arrancar individualmente um serviço usando o comando abaixo 
(atenção que só um serviço deve arrancar com o comando abaixo, porque este é que fica responsável 
por iniciar com o Service Locator, Cassandra e Kafka)

```lagomServiceLocatorStart lagomCassandraStart lagomKafkaStart post-impl/run```
