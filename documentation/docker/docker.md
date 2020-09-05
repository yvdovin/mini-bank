## Работа с Postgres в Docker

Для того, чтобы использовать **postgres** в **docker**, а ваши таблицы и данные сохранялись при перезапуске контейнера,
необходимо прописать **volumes** либо в команде `docker run`:

    docker run -d \
        --name pgmb \
        -e POSTGRES_PASSWORD=pswd \
        -e PGDATA=/var/lib/postgresql/data/pgdata \
        -v ./pg_data:/var/lib/postgresql/data/pgdata \
        postgres:11
    
либо в файле `docker-compose.yml`: (на мой взгляд, предпочтительный вариант. Файл можно расширить различными параметрами)

    version: '3.8'
     
    services:
      db:
        image: postgres:11
        container_name: pgmb
        ports:
          - 5432:5432
        volumes:
          - ./pg_data:/var/lib/postgresql/data/pgdata
        environment:
          POSTGRES_PASSWORD: pswd
          PGDATA: /var/lib/postgresql/data/pgdata
        restart: always
    
    
где `volumes`:

- `./pg_data` до двоеточия - директория, в которой у вас локально будут сохраняться данные
- `/var/lib/postgresql/data/pgdata` после двоеточия - директория в контейнере, где postgres хранит данные

Создать новый контейнер и запустить его с помощью `docker-compose.yml` можно выполнив команду в директории с файлом:
`docker-compose up -d`

Затем можно либо в терминале подключиться к контейнеру `docker exec -it pgdb bash`, и к самому `postgres psql -U postgres`,
либо через **pgAdmin**, либо через **IDEA**.

Если вы хотите просто остановить контейнер, то не надо выполнять `docker-compose down`, т.к. `down` останавливает и
удаляет контейнер. Выполняйте `docker stop container-name`, чтобы запустить его потом `docker start container-name`

[Документация по конфигурации postgres в docker.](https://hub.docker.com/_/postgres)

[Документация по **docker-compose**.](https://docs.docker.com/compose/)

[Playlist для знакомства с Docker](https://www.youtube.com/watch?v=Sa7uOGczoHc&list=PLU2ftbIeotGoGFC_2lj-OplT_cItXfu48)
