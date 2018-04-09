# Objetivo
Criar uma API RESTful simples para implementar e compreender o uso de containers.

### *Pré-requisito: Docker e Postman instalados
		https://docs.docker.com/install/
		https://www.getpostman.com/

### Passo 1: Fazer um clone do repositório projetoOpenshift
	 $ git clone https://github.com/lcaparel/projetoOpenshift

### Passo 2: Acessar o diretorio Arquivos do projetoOPenshift e gerar uma nova imagem com a aplicação dentro do EAP 
	 $ sudo docker build -t imagem-eap-restful .

### Passo 3: Gerar um container chamado eap a partir da imagem imagem-eap-restfull criada anteriormente
	 $ sudo docker run -d --name eap imagem-eap-restful

### Passo 4: Pegar o IP do container eap gerado
	 $ sudo docker inspect -f '{{ .NetworkSettings.IPAddress }}' eap

### Passo 5: 
