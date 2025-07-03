# 🔧 Spring Boot Task: Remove First and Last Character

## 📌 Task Overview

Create a Spring Boot REST API with one GET endpoint `/remove` that transforms a string based on the following logic.

---

## ✅ Requirements

- Java 17
- Maven
- Spring Boot (Web, Data JPA, H2)
- Apache Commons Lang3

---

## 🎯 Endpoint

### ➤ `GET /remove?input=your_string`

---

## 🧠 Logic Description

| Input Condition                                        | Output                                |
|--------------------------------------------------------|----------------------------------------|
| Length < 2                                             | ❌ 400 Bad Request                      |
| Length == 2                                            | ✅ Empty string `""`                    |
| Length >= 3 AND starts with a **digit**                | ✅ Remove only the **last character**   |
| Length >= 3 AND starts with a **non-digit** (e.g. `a`) | ✅ Remove both **first and last** chars |

---

## 🔍 Examples

| Input             | Output         | Reason                                |
|------------------|----------------|---------------------------------------|
| `eloquent`        | `loquen`       | Remove `e` and `t`                    |
| `country`         | `ountr`        | Remove `c` and `y`                    |
| `ab`              | ``             | 2 chars → return empty string         |
| `a`               | 400 Bad Request| Only 1 char → invalid                 |
| `xyz`             | `y`            | Remove `x` and `z`                    |
| `123%qwerty+`     | `123_%qwerty`   | Starts with digit → add underscore after digit and remove last only |
| `a123%qwerty+`    | `123%qwerty`   | Remove `a` and `+`                    |

---

## 🧪 Test Coverage

Test cases are written using **JUnit 5** and **MockMvc** to cover:

- ✅ Valid strings (length ≥ 3)
- ✅ Exactly 2 characters
- ✅ Less than 2 characters (invalid case)
- ✅ Strings with digits and special characters
- ✅ Business logic when string starts with a digit

Run tests using:

```bash
mvn verify
