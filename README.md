# Criar imagem
## Dentro do diretório /banco execute:

docker build -t jose/postgres .

## Dentro do diretório raiz execute:

docker build -t teste-docker .

## Executar à aplicação 

docker run -d -p 5433:5433 --name banco postgres

## Executar o app

 docker run -d -p 8081:8081 --link banco:bd --name web teste-docker

