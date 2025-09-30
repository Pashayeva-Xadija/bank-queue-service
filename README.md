🏦 Bank Queue Service (Microservices-based)

A full-featured microservices-based queue management system for banks.
Customers can open tickets, admins can configure services and desks, and operators can call/manage tickets in real-time.

✨ Key Features
🔐 Authentication & Authorization

JWT-based login/register

Role-based access control (ADMIN, OPERATOR, PUBLIC)

Centralized API Gateway with CORS support

🏦 Service Management

Admin can manage service types (e.g. Consultation, Payments, Loans)

Admin can configure desks and assign operators

🎫 Ticketing System

Customer can open a ticket for a selected service

Operator can call, start, finish, or cancel tickets

Live Monitor shows real-time queue status

📩 Notifications (optional extension)

Email/SMS confirmations for opened or completed tickets

Event-driven integration possible with RabbitMQ/Kafka

📊 Monitoring & Documentation

Centralized exception handling

Swagger / OpenAPI docs

🧰 Tech Stack

Backend: Java 17, Spring Boot 3 (REST API), Spring Security (JWT), Spring Data JPA

Microservices: Admin, Operator, Customer, Monitor, Auth

Database: PostgreSQL (hosted on Railway)

Cache: Redis (optional, for session/ticket optimization)

Messaging: RabbitMQ / Apache Kafka (optional, for async notifications)

Deployment: Docker, Docker Compose, Kubernetes, Railway CI/CD

UI: Simple HTML/CSS/JS Demo UI

🧭 Architecture – Flow (Text)

User → enters through API Gateway

Auth Service → handles login/register and issues JWT tokens

Admin Service → manages services and desks

Customer → opens ticket for a service

Operator Service → calls next ticket, manages status (start/finish/cancel)

Monitor Service → displays live queue status

(Optional) Notification Service → sends Email/SMS via RabbitMQ/Kafka events

🚀 Getting Started
Prerequisites

Java 17

Maven

Docker & Docker Compose

PostgreSQL (Railway managed DB)

Redis & RabbitMQ/Kafka (optional)

Clone Repository
git clone https://github.com/<your-username>/bank-queue-service.git
cd bank-queue-service

Run with Docker Compose
docker-compose up --build

Deploy on Railway

Add a PostgreSQL service in Railway

Add environment variables in Railway → Variables tab:

SPRING_DATASOURCE_URL=jdbc:postgresql://postgres.railway.internal:5432/railway
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=*****
JWT_SECRET=your-strong-secret
CORS_ALLOWED_ORIGINS=https://bank-queue-service-production.up.railway.app,http://localhost:3000


Push to main branch → Railway will auto-build and deploy with Dockerfile

🔐 Authentication – Endpoints
Endpoint	Method	Description
/api/auth/register	POST	Register new user (ADMIN/OPERATOR)
/api/auth/login	POST	Authenticate and get JWT token
/api/auth/me	GET	Get authenticated user info

Roles

ADMIN → Manage services, desks, users

OPERATOR → Call and process tickets

PUBLIC → Open tickets, view monitor

🌍 Live Demo

🔗 Bank Queue Service on Railway

📬 Contact

Made with ❤️ by Xədicə Paşayeva
📧 xadijapashayeva@gmail.com

🔗 LinkedIn: https://www.linkedin.com/in/xadija-pashayeva
