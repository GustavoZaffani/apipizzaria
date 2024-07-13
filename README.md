#### Requisitos para ambiente de desenvolvimento
- `JDK 17`
- `make`
- `docker`
- `docker-compose`

#### Como rodar localmente

- Utilizando linha de comando
```sh
git clone git@github.com:GustavoZaffani/apipizzaria.git
make apipizzaria/development-environment/Makefile.mk start
```
- Utilizando IDE
    1. Devemos inicializar as dependências do serviço pela IDE usando o Makefile.mk do projeto
       ou por shell na **raiz** do projeto com o comando: `make development-environment/Makefile.mk start-environment`
    2. Inicializar o serviço pela classe `AppPizzariaApiApplication.java`.

#### Para conectar no banco de dados do container:
- user: `pizzeria_user`
- password: `pizzeria_user123`
- host: `localhost:5437`
