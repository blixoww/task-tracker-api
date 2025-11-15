# Task Tracker API

[![Build](https://github.com/blixoww/task-tracker-api/actions/workflows/ci.yml/badge.svg)](https://github.com/blixoww/task-tracker-api/actions/workflows/ci.yml)
[![Docker](https://img.shields.io/badge/Docker-ready-blue?logo=docker)](https://hub.docker.com/)

Une API REST pour gérer des tâches, développée avec **Spring Boot**, **Spring Data JPA** et **H2** (base en mémoire).

---

## 🚀 Fonctionnalités

- Créer, lire, mettre à jour et supprimer des tâches (`CRUD`)
- Filtrage des tâches par statut : `TODO`, `IN_PROGRESS`, `DONE`
- Retour JSON lisible et indenté
- Base H2 en mémoire (non persistante)
- Dockerfile inclus pour exécution conteneurisée

---

## 🛠 Technologies

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- H2 Database (in-memory)
- Gradle 8
- Jackson pour JSON
- Docker (optionnel)

---

## 📦 CI/CD

- Build Gradle
- Tests unitaires et d’intégration
- Build et push Docker si DOCKER_USERNAME est fourni

---

## ⚡ Prérequis

- Java 21
- Docker (optionnel)
- Gradle ou `./gradlew`

---

## 🏃‍♂️ Lancer l’application

### Localement avec Gradle

```bash
./gradlew bootRun
```

### Avec Docker
```bash
docker build -t task-tracker-api .
docker run -p 8080:8080 task-tracker-api
```

## 🔗 Endpoints

| Méthode | URL              | Description                                       |
| ------- | ---------------- | ------------------------------------------------- |
| GET     | `/tasks`         | Liste toutes les tâches                           |
| GET     | `/tasks?status=` | Filtre par statut (`TODO`, `IN_PROGRESS`, `DONE`) |
| GET     | `/tasks/{id}`    | Récupère une tâche par ID                         |
| POST    | `/tasks`         | Crée une tâche (JSON body)                        |
| PUT     | `/tasks/{id}`    | Met à jour une tâche                              |
| DELETE  | `/tasks/{id}`    | Supprime une tâche                                |




