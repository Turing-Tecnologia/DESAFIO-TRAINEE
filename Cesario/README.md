<h1>Instruções para testar a aplicação</h1>

1. O backend da aplicação foi desenvolvida utilizando a linguagem POO Java e o 
framework Springboot com hibernate e jpa alem do gerenciador de projetos Maven
para gerenciar todas essas dependencia Trata-se de uma API REST.
2. O frontend foi construido utilizando o framework VueJS(Javascript)
ps: Necessário instalar o NodeJS LTS.


<h2>Passos</h2>

1. Crie um banco de dados utilizando o postgressql10+ chamado: todolistbackend
obs: o banco foi configurado utilizando o usuario padrao(postgres) e password 
postgres.
ps: caso seja necessario modificar o usuario ou o password modifique o arquivo 
aplication.properties que esta na pasta: Cesario\ToDoList-backend\src\main\resources 
de acordo com a realidade do seu servidor.
--O JPA fica responsavel por criar as tabelas e atributos no banco na hora em que inicia 
a aplicação.

2. inicie o arquivo Cesario\ToDoList-backend\src\main\java\br\com\cesario\ToDoListbackend\ToDoListBackendApplication.java
como Java Aplication (utilizando o eclipse)
ps: certifique-se que o tomcat iniciou na porta padrao: 8080

<h3>Continue o passo 3 apenas se o backend estiver iniciado.</h3>

3. na pasta raiz do frontend \Cesario\todolist abra o terminal e digite os comandos:

npm install
//ele ira instalar todas as dependencias do projeto

npm run serve
//para iniciar o servidor do frontend. 
ps: quando iniciar, o servidor informará que esta rodando na porta 8081.
caso haja erro(as vezes acontece) cancele a inicialização do front, reinicie o backend e depois rode o npm run serve novamente.

