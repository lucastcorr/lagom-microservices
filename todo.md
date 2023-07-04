# Desafio Lagom (em desenvolvimento)
Implementação de microsserviços à fim de validar conhecimentos

## RFs (Requisitos funcionais)

- [ ] User Service deve ser capaz de guardar informações do usuário;
- [ ] Post Service deve ser capaz de guardar informações do post;
- [ ] Emoji Service deve ser capaz de guardar informações do emoji;
- [ ] Notification Service deve ser capaz de enviar as informações sobre o post 
      criado para um Websocket (Postman);
- [x] Os services Post, User e Emoji devem conter também um método GET por id;


## RNs (Regras de negócio)

- [ ] ..
- [ ] ..
- [ ] ..



## RNFs (Requisitos não-funcionais)

- [ ] O Notification Service não precisa de persistência, ao invés disso utilizar um 
      topico para sobrescrever e enviar informações ao Postman;
- [ ] O Read Side deve dar suporte a PostgreSQL/Cassandra;
- [ ] Pode ser utilizado o Table Plus para fazer a ligação com o banco de dados ao 
      executar a aplicação;
