# Task Tracker API

[![Build](https://github.com/blixoww/task-tracker-api/actions/workflows/ci.yml/badge.svg)](https://github.com/blixoww/task-tracker-api/actions/workflows/ci.yml)
[![Docker](https://img.shields.io/badge/Docker-ready-blue?logo=docker)](https://hub.docker.com/)
[![GitOps with ArgoCD](https://img.shields.io/badge/GitOps-ArgoCD-success?style=flat&logo=argoproj)](http://192.168.1.40:8080/applications)
[![k3s Cluster](https://img.shields.io/badge/k3s-v1.30+-00c7b7?style=flat&logo=kubernetes)](https://k3s.io)
[![GHCR Registry](https://img.shields.io/badge/Image-GHCR-blue?logo=github)](https://ghcr.io/blixoww/task-tracker-api)

Une API REST pour gérer des tâches, développée avec **Spring Boot**, **Spring Data JPA** et **H2** (base en mémoire).
Déploiement **automatisé** via **ArgoCD** sur **Kubernetes**.

## 🚀 Fonctionnalités

- Créer, lire, mettre à jour et supprimer des tâches (`CRUD`)
- Filtrage des tâches par statut : `TODO`, `IN_PROGRESS`, `DONE`
- Retour JSON lisible et indenté
- Base H2 en mémoire (non persistante)
- Dockerfile inclus pour exécution conteneurisée

## 🛠 Technologies

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- H2 Database (in-memory)
- Gradle 8
- Jackson pour JSON
- Docker (optionnel)
- ArgoCD
- Kubernetes (k3s)

## 📦 CI/CD

- Build Gradle
- Tests unitaires et d’intégration
- Push de l'image push image sur **GHCR**  

## ⚡ Prérequis

- Java 21
- Docker (optionnel)
- Gradle ou `./gradlew`

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
