FROM postgres
MAINTAINER Jose Ferreira <joseifpb2015@gmail.com>
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 12346
ENV POSTGRES_DB teste-docker
COPY table.sql /docker-entrypoint-initdb.d/
COPY dados.sql /docker-entrypoint-initdb.d/
