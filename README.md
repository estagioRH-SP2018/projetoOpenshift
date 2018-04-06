*Pré-requisito: docker instalado
		https://docs.docker.com/install/

Passo 1: fazer um clone do repositório projetoOpenshift
	 $ git clone https://github.com/lcaparel/projetoOpenshift

Passo 2: acessar o diretorio Arquivos do projetoOPenshift e gerar uma nova imagem com a aplicação dentro do EAP 
	 $ sudo docker build -t imagem-eap-restfull .

passo 3: gerar um container chamado eap a partir da imagem imagem-eap-restfull criada anteriormente
	 $ sudo docker run -d --name eap imagem-eap-restfull

passo 4: pegar o IP do container eap gerado
	 $ sudo docker inspect -f '{{ .NetworkSettings.IPAddress }}' eap


