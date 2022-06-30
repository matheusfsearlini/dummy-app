# Introdução

O projeto Dummy foi criado com o intuito de demonstrar a criação de um projeto java e spring, utilizando um estilo de
arquitetura REST com protocolo HTTP e também a utilização de um handler para tratativa de erros.

# Começando

1. Para rodar este projeto fictício será necessário ter em sua máquina o java 11 e o maven.

2. Após clonar o repositório, crie em um banco de dados PostgreSQL um data base chamado “db_dummy” com login e senha
   “postgres”

3. Execute o comando “mvn install” no terminal da pasta raiz para baixar as dependências.

4. Vale lembrar que o projeto utiliza a porta local 8080, certifique-se que ela esteja disponivel para ser usado ou
   altere a porta local no arquivo "application.properties".

5. Por fim construa seu projeto e execute o comando para rodar o "CrudApplication".

# Como funciono?

- Foram criados cinco endpoints, onde podemos listar todos os clientes, apenas um utilizando seu ID, cadastrar,
  atualizar e deletar.

- Caso utilize algum programa para fazer as requisições, esta API é fictícia e não possui autenticação.

- O projeto dummy possui um exemplo de tratativa de erros, onde é tratado erro do tipo "Entidate Existente e
  Inexistente" no banco de dados.

# Fazendo requisições

Para as requisições, um exemplo de JSON para utilizarmos.

{
  "id": 1,
  "name": "Cliente",
  "lastName": "Dummy",
  "email": "client.dummy@email.com",
  "mobilePhone": "(11)111-111-111"
}
- Para cadastro utilize o URL http://localhost:8080/customer/ com a requisição do tipo POST e encaminhe um JSON no body,
  lembrando de não passar nenhum valor em ID caso contrario o projeto não efetuara o cadastro e retornará um erro.

- Caso queira listar todos os clientes cadastrados, basta solicitar um GET no URL http://localhost:8080/customer/get-all

- Listar apenas um cliente, é necessario fazer um GET no URL http://localhost:8080/customer/{id}, onde o "{id}"
  recebe o ID do seu cliente, exemplo ".../customer/1". Lembrando que caso informe um ID inexistente no banco, ele
  retornará um erro.

- Para atualizar um cliente é necessario encaminhar no URL http://localhost:8080/customer/{id} um PUT com o ID do
  cliente e no body da requisição os campos que deseja alterar. Se na URL encaminhar um ID não cadastrado no banco,
  retornará um erro.

- Se deseja deletar um cliente, basta encaminhar o ID para o URL http://localhost:8080/customer/{id} com uma requisição
  do tipo DELETE, mas passando um ID que nao tenha no banco, retornará um erro.
