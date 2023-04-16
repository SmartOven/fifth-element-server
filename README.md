# fifth-element-server
Серверная часть для мониторинга трафика (хакатон VK образования)

## Запуск
1) `docker-compose -f docker-compose.yml up` для запуска PostgreSQL и Grafana в Docker-контейнерах
2) Запустить `FifthElementServerApplication.main()`

## Тестирование
Для заполнения бд тестовыми данными можно запустить `DbFillerTest`
