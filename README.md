
# Objetivo
Implantar uma API RESTful utilizando Docker 1.13 a partir de uma implementação convencional de um JBoss EAP 7.1.

### *Pré-requisito: Docker e Postman instalados
		https://docs.docker.com/install/
		https://www.getpostman.com/

# Criação de imagem e container
### Passo 1: Fazer um clone do repositório projetoOpenshift
	 $ git clone https://github.com/lcaparel/projetoOpenshift

### Passo 2: Acessar o diretorio Arquivos do projetoOPenshift e gerar uma nova imagem com a aplicação dentro do EAP 
	 $ cd Arquivos/
	 $ sudo docker build -t imagem-eap-restful ./

##### Verifique se a imagem foi criada em seu repositório local com o comando abaixo:
	$ sudo docker images
##### O retorno deve ser semelhante ao abaixo:
	REPOSITORY         TAG    IMAGE ID       CREATED         SIZE
	imagem-eap-restful latest 9df4267c2be3   3 minutes ago   732 MB


### Passo 3: Gerar um container chamado "eap" a partir da imagem "imagem-eap-restful" criada anteriormente
	 $ sudo docker run -d --name eap imagem-eap-restful

##### Verifique se o container está em execução
	$ sudo docker ps
##### O retorno deve ser semelhante ao abaixo:

    CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS              PORTS                          NAMES
    144c42039a30        imagem-eap-restful   "/opt/eap/bin/open..."   10 seconds ago      Up 8 seconds        8080/tcp, 8443/tcp, 8778/tcp   eap

	
### Passo 4: Pegar o IP do container eap gerado
	 $ sudo docker inspect -f '{{ .NetworkSettings.IPAddress }}' eap
##### O retorno deve ser semelhante ao abaixo:

     $ 172.17.0.2
#### Chamaremos este resultado de $IP
# Utilizando a API
Os seguintes passos são feitos utilizando uma ferramenta que possibilita requisições HTTP GET e POST:

## POST
### Inclusão de RedHatters:
    http://$IP:8080/redhat-0.1/api/pessoa/incluiRedHatter?nome={nome}&idade={idade}&email={email}&cpf={cpf}&centroDeCusto={centroDeCusto}&salario={salario}&especialidade={especialidade}&cargo={cargo}
##### Exemplo
	http://172.17.0.2:8080/redhat-0.1/api/pessoa/incluiRedHatter?nome=Fulano&idade=33&email=email@exemplo.com&cpf=12312312312&centroDeCusto=1&salario=150000&especialidade=plataforma&cargo=CEO
---
### Inclusão de Clientes :
    http://$IP:8080/redhat-0.1/api/pessoa/incluiCliente?nome={nome}&email={email}&cpfVendedor={cpfVendedor}&cnpj={cnpj}&subscricaoAtiva={subscricaoAtiva}
##### Exemplo
    http://172.17.0.2:8080/redhat-0.1/api/pessoa/incluiCliente?nome=JoãoCliente&email=joao@cliente.com&cpfVendedor=12312312312&cnpj=123123123123123&subscricaoAtiva=true
## GETs
Os métodos abaixo retornam um JSON com os dados inseridos previamente.

### Visualização de Clientes e RedHatters :
	http://$IP:8080/redhat-0.1/api/pessoa/pessoas/
--- 
### Visualização de Clientes :
	http://$IP:8080/redhat-0.1/api/pessoa/clientes/
--- 
### Visualização de RedHatters

    http://$IP:8080/redhat-0.1/api/pessoa/redHatters/

---
v1.0 





    

