# Address Book

A RESTful address book built with Spring Boot 4 and Java 21. Contacts are stored in
an embedded H2 database by default, so the application can be run without any
external services.

## Requirements

- Java 21 or newer
- Maven 3.6.3 or newer

## Run the application

```bash
mvn spring-boot:run
```

The API is available at `http://localhost:8080/api/contacts`.

## API

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/api/contacts` | List contacts; optionally filter with `?search=` |
| `GET` | `/api/contacts/{id}` | Get one contact |
| `POST` | `/api/contacts` | Create a contact |
| `PUT` | `/api/contacts/{id}` | Replace a contact |
| `DELETE` | `/api/contacts/{id}` | Delete a contact |

Example:

```bash
curl -i http://localhost:8080/api/contacts \
  -H 'Content-Type: application/json' \
  -d '{"firstName":"Ada","lastName":"Lovelace","email":"ada@example.com","phone":"+44 20 1234 5678"}'
```

## Build and test

```bash
mvn verify
```
