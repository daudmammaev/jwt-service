Запуск:

jwt-service.jar


Endpoint:

URL: /api/auth/login
curl -X POST https://localhost/api/auth/login
Описание: Вход в приложение

URL: /api/auth/token
curl -X POST https://localhost/api/auth/token
Описание: Получение токена

URL: /api/auth/refresh
curl -X POST https://localhost/api/auth/refresh
Описание: Обновление токена

URL: /api/user/registration
curl -X PUT https://localhost/api/user/registration
Метод: Put
Описание: Регистрация пользователя

URL: /api/user/{id}
curl -X GET https://localhost/api/user/{id}
Метод: Get
Описание: Получение пользователя

URL: /api/user/update
curl -X UPDATE https://localhost/api/user/update
Метод: Update
Описание: Обновление пользователя

URL: /api/user/delete/{id}
curl -X DELETE https://localhost/api/user/delete/{id}
Метод: Delete
Описание: Удаление пользователя

Используемые технологии:
Java 17
Spring 3
PostgreSQL

