# Тестирование REST приложения при помощи JUnit и Mockito

Этот проект представляет собой тестирование REST-приложения, реализованного с использованием Spring Boot, JUnit и Mockito.

## Что делает проект

Проект реализует простое REST API для управления книгами. Включает основные операции CRUD (создание, чтение, обновление, удаление) книг через REST-методы, такие как:

- `GET /books` - получение списка всех книг.
- `GET /books/{id}` - получение конкретной книги по идентификатору.
- `POST /add` - добавление новой книги.
- `PUT /update/{id}` - обновление книги по идентификатору.
- `DELETE /delete/{id}` - удаление книги по идентификатору.

## Цель тестов

Тесты, реализованные при помощи JUnit и Mockito, проверяют корректность работы основных методов контроллера и сервисов, включая:

- Поиск книги по идентификатору.
- Создание книги.
- Обновление книги.
- Удаление книги.
- Поиск книги по имени автора.

## Описание структуры проекта

Проект содержит следующие ключевые компоненты:

- `BookController` - контроллер для обработки HTTP-запросов по работе с книгами.
- `BookService` и `BookServiceImpl` - сервисы для выполнения операций с книгами.
- `BookRepository` - репозиторий для взаимодействия с базой данных.

## Структура кода и тестирование

Код содержит реализацию контроллера, сервисов, сущностей книг и их репозитория. Кроме того, представлены модульные тесты:

- `CRUDTest` - тесты для проверки HTTP-запросов и ответов.
- `BookRepositoryTest` - тесты для проверки функций мокирования методов репозитория.
- `BookServiceImplTest` - тесты для проверки методов сервиса.
