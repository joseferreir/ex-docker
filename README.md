# Criar imagem
## Dentro do diretório /banco execulte:

docker build -t jose/postgres .

## Dentro do diretório raiz execulte:

docker build -t teste-docker .

## Execultar à aplicação 

docker run -d -p 5433:5433 --name banco postgres

## Execultar o app

 docker run -d -p 8081:8081 --link banco:bd --name web teste-docker

