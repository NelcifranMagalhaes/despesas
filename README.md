# Despesas - Financial Control System

REST API for managing personal income and expenses, built with Ktor and Kotlin.

## 📋 About the Project

Financial control system that allows you to register, query, and update income (MoneyIn) and expenses (MoneyOut), with categorization and persistence in H2 database.

## 🚀 Technologies

- **Kotlin** - Programming language
- **Ktor 3.2.1** - Web framework
- **Exposed** - ORM for Kotlin
- **H2 Database** - Embedded database
- **kotlinx.serialization** - JSON serialization

## 📁 Project Structure

```
src/main/kotlin/
├── database/
│   ├── dao/
│   │   ├── MoneyInDao.kt      # DAO for income
│   │   └── MoneyOutDao.kt     # DAO for expenses
│   └── DatabaseFactory.kt     # Database configuration
├── dto/
│   ├── MoneyInRequest.kt      # Income DTOs
│   ├── MoneyInResponse.kt
│   ├── MoneyOutRequest.kt     # Expense DTOs
│   └── MoneyOutResponse.kt
├── enums/
│   ├── CategoryIn.kt          # Income categories
│   └── CategoryOut.kt         # Expense categories
├── models/
│   ├── MoneyIn.kt             # Income model
│   └── MoneyOut.kt            # Expense model
├── repositories/
│   ├── MoneyInRepository.kt   # Income repository
│   └── MoneyOutRepository.kt  # Expense repository
├── routes/
│   ├── MoneyInRoutes.kt       # Income routes
│   └── MoneyOutRoutes.kt      # Expense routes
├── Application.kt
├── Routing.kt
└── Serialization.kt
```

## 🔌 API Endpoints

### Income (MoneyIn)

| Method | Endpoint         | Description                  |
|--------|------------------|------------------------------|
| GET    | `/moneyIn`       | List all income entries      |
| POST   | `/moneyIn`       | Create a new income entry    |
| PUT    | `/moneyIn/{id}`  | Update an income entry       |

**Income Categories:** `Salary`, `SideJob`, `Lucky`

### Expenses (MoneyOut)

| Method | Endpoint         | Description                  |
|--------|------------------|------------------------------|
| GET    | `/moneyOut`      | List all expenses            |
| POST   | `/moneyOut`      | Create a new expense         |
| PUT    | `/moneyOut/{id}` | Update an expense            |

**Expense Categories:** `Food`, `House`, `Fun`, `Education`

## 📝 Request Examples

### Create an income entry (POST /moneyIn)
```json
{
  "description": "Monthly salary",
  "moneyValue": 5000.0,
  "createdAt": "2024-11-29",
  "category": "Salary"
}
```

### Create an expense (POST /moneyOut)
```json
{
  "description": "Grocery shopping",
  "moneyValue": 350.50,
  "createdAt": "2024-11-29",
  "category": "Food"
}
```

### Update (PUT /moneyIn/{id} or /moneyOut/{id})
```json
{
  "id": "uuid-here",
  "description": "Updated description",
  "moneyValue": 1000.0,
  "createdAt": "2024-11-29",
  "category": "Food"
}
```

## 🛠️ Features

| Name                                                                   | Description                                                                        |
|------------------------------------------------------------------------|------------------------------------------------------------------------------------|
| [Routing](https://start.ktor.io/p/routing)                             | Structured routing system                                                          |
| [Content Negotiation](https://start.ktor.io/p/content-negotiation)     | Automatic content conversion based on Content-Type and Accept headers              |
| [kotlinx.serialization](https://start.ktor.io/p/kotlinx-serialization) | JSON serialization using kotlinx.serialization                                     |
| Exposed ORM                                                            | Object-relational mapping for Kotlin                                               |
| H2 Database                                                            | Embedded database for persistence                                                  |

## 🏃 Getting Started

### Prerequisites
- JDK 11 or higher
- Gradle (or use the included wrapper)

### Running the project

```bash
# Run in development mode
./gradlew run

# Run tests
./gradlew test

# Build the project
./gradlew build
```

### Available tasks

| Task                          | Description                                                          |
|-------------------------------|----------------------------------------------------------------------|
| `./gradlew test`              | Run the tests                                                        |
| `./gradlew build`             | Build the project                                                    |
| `./gradlew run`               | Run the server                                                       |
| `buildFatJar`                 | Build an executable JAR with all dependencies                        |
| `buildImage`                  | Build the Docker image                                               |
| `publishImageToLocalRegistry` | Publish the Docker image locally                                     |
| `runDocker`                   | Run using the local Docker image                                     |

### Server started successfully

When the server starts successfully, you'll see:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

The server will be available at: **http://localhost:8080**

## 💾 Database

The project uses H2 Database in file mode. The database is automatically created at:
```
./build/db
```

The `MoneyIns` and `MoneyOuts` tables are created automatically on startup.

## 📚 Useful Resources

- [Ktor Documentation](https://ktor.io/docs/home.html)
- [Ktor GitHub](https://github.com/ktorio/ktor)
- [Exposed Documentation](https://github.com/JetBrains/Exposed)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Ktor Slack](https://app.slack.com/client/T09229ZC6/C0A974TJ9) - [Request invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up)

## 📄 License

This project was created using the [Ktor Project Generator](https://start.ktor.io).

