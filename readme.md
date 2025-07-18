# 🧾 Prueba Técnica - Sistema de Gestión de Clientes para OrionTek

Este proyecto es una **prueba técnica** desarrollada para la empresa **OrionTek**. Consiste en una API REST construida con **Spring Boot** que permite gestionar clientes y sus múltiples direcciones. Cada cliente puede tener **una o más direcciones asociadas**, lo cual permite organizar y consultar la información de manera estructurada.

---

## 🚀 Tecnologías utilizadas

- Java **21**
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Hibernate
- Jackson (para serialización JSON)

---

## 🗃️ Modelo de Datos

### Cliente (`Client`)
- `id`: Long
- `firstName`: String
- `lastName`: String
- `dateOfBirth`: Date
- `email`: String
- `phoneNumber`: String
- `addresses`: Lista de direcciones asociadas

### Dirección (`Address`)
- `id`: Long
- `street`: String
- `city`: String
- `country`: String
- `client`: Cliente relacionado

---

## 🔁 Endpoints REST

### 📁 Clientes

| Método | Endpoint        | Descripción                           |
|--------|-----------------|---------------------------------------|
| GET    | `/client`       | Obtener todos los clientes            |
| GET    | `/client/{id}`  | Obtener cliente por ID                |
| POST   | `/client`       | Crear un nuevo cliente                |
| PUT    | `/client/{id}`  | Actualizar un cliente                 |
| DELETE | `/client/{id}`  | Eliminar un cliente y sus direcciones |

### 🏠 Direcciones

| Método | Endpoint                                  | Descripción                          |
|--------|-------------------------------------------|--------------------------------------|
| GET    | `/client/{clientId}/address`              | Listar direcciones de un cliente     |
| GET    | `/client/{clientId}/address/{addressId}`  | Obtener una dirección específica     |
| POST   | `/client/{clientId}/address`              | Agregar dirección a un cliente       |
| PUT    | `/client/{clientId}/address/{addressId}`  | Editar dirección                     |
| DELETE | `/client/{clientId}/address/{addressId}`  | Eliminar dirección específica        |
| GET    | `/address`                                | Listar todas las direcciones         |
| GET    | `/address/{addressId}`                    | Obtener una dirección específica     |
| PUT    | `/address/{addressId}`                    | Editar dirección                     |
| DELETE | `/address/{addressId}`                    | Eliminar dirección específica        |

---

## ⚙️ Configuración del entorno

### 1. Crear base de datos PostgreSQL

```sql
CREATE DATABASE oriontek_db;