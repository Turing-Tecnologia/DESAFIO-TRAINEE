
Olá, caro leito.
Aqui conta um pouco sobre a ideia que tive sobre a aplicação ToDolist.

Como estamos vivendo em uma quaretena, pensei em desenvolver algo relacionado.
desenvolvi um site onde os usuarios poderão ver ideias para se fazer durante a quaretena,
a ideia é que os mesmo vejam os tipos de ideias existentes no site e escolham a atividade para fazer em casa,
dando a possibilidade tbm de adicionar novas ideias e exxclui-la, ou seja um CRUD basic.

Não se atente muito para as logicas de negocio, como vcs disseram, abstraiam kkkk.

o projeto constitui em um modelo MVC para dá organização, separando cada tipo de arquivo e responsabilidade.
Foi desenvolvido usando java com paginas em jsp utilizando a IDE eclipse e o MySQL como banco. O arquivo do banco se encontrar na pasta do projeto com o nome: casacriativa.
durante o desenvolvimento foi utilizado o servidor Tomcat para rodas as aplicações e xamp que vem com os pacotes de bancos de dados do MySQL para salvar os dados.

Converso que ainda ficou algumas pedencias da ideia inicial que eu tinha. 
iria dá a possibilidade de usuarios adicionarem imagens ou inoces as ideias postadas no site, bem como um link que levaria a algum site relacionado a tag, por exemplo: site para fazer um curso.
Essas pendencias ficam outrora.

Infelizmente não fiz a modelagem do projeto, fui logo no desenvolviemento, talvez seja por isso que demorei tanto para ter a ideia do que fazer.

Sei que, talvez, deenvolver o front não fosse o foco, mas me dei o trabalho de criar um css bem basico nas paginas para ficar com um visual legal. 
Sobre o css, estou fazendo um curso de node.js e aprendendo um pouco mais de css e java script, dessa forma conseguir desenvolver bem o css das paginas.

Gambiarras:
fiz algumas.
Nas duas classes de Servlet add um js para dá um refresh para a pagina inicial, dessa forma não era preciso sempre voltar a mesma.
Na pagina removeIdeia.jps tambem criei js para a mesma função mas de outra forma, dessa forma, as exclusões ficam mais dinamicas.
tentei subir o repositorio para o Heroku, tentei de todoas as formas, ate criar um arquivo .php junto com um compose, já que o heroku tem suporte php. Esse .php chama as paginas .jsp que criei, dessa forma é possivel enganar os Dynos do heroku, fazer o deploy e roda algumas aplicaçoes (da certo quando se tem apenas o front rsrsr).


Essa é a imagem inicial da pagina. (casos voces forem rodar o projeto e não aparecer nenhuma ideia, add uma)
![Pagina inicial](https://user-images.githubusercontent.com/62274788/77650139-c6fd3480-6f49-11ea-86d6-294d1ca78eb6.PNG)
