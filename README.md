🏦 Bank Queue Service

A full-featured queue management system for banks. Customers can open tickets, admins can configure services and desks, and operators can call/manage tickets in real-time.

✨ Key Features
🔐 Authentication & Authorization

JWT-based login/register

Role-based access control (ADMIN, OPERATOR, PUBLIC)

CORS support for UI integration

🏦 Service Management

Admin can manage service types (e.g. Consultation, Payments, Loans)

Admin can configure desks and assign operators

🎫 Ticketing System

Customer can open a ticket for a selected service

Operator can call, start, finish, or cancel tickets

Live Monitor shows real-time queue status

📊 Monitoring & Documentation

Centralized exception handling

Swagger / OpenAPI documentation

🧰 Tech Stack

Backend: Java 17, Spring Boot 3 (REST API), Spring Security (JWT), Spring Data JPA

Database: PostgreSQL (hosted on Railway)

Cache (optional): Redis (for session/ticket optimization)

Deployment: Docker, Docker Compose, Railway CI/CD

UI: Simple HTML/CSS/JS Demo UI

🧭 Architecture – Flow (Text)
User → enters system via UI
↓
Auth (Spring Security, JWT) → login/register
↓
Admin → manages services & desks
↓
Customer → opens ticket for a service
↓
Operator → calls next ticket, manages status (start/finish/cancel)
↓
Monitor → displays live queue status

🚀 Getting Started
Prerequisites

Java 17

Maven

Docker & Docker Compose

PostgreSQL (Railway managed DB)

Clone Repository
git clone https://github.com/<your-username>/bank-queue-service.git
cd bank-queue-service

Run with Docker Compose
docker-compose up --build

Deploy on Railway

Add a PostgreSQL service in Railway

Configure environment variables:

SPRING_DATASOURCE_URL=jdbc:postgresql://postgres.railway.internal:5432/railway
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=*****
JWT_SECRET=your-strong-secret
CORS_ALLOWED_ORIGINS=https://bank-queue-service-production.up.railway.app,http://localhost:3000


Push to main branch → Railway auto-builds & deploys with Dockerfile

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

🔗 Canlı UI: https://bank-queue-service-production.up.railway.app

🔗 Swagger: https://bank-queue-service-production.up.railway.app/swagger-ui.html

🔗 GitHub Repo: https://github.com/
<your-username>/bank-queue-service

📬 Contact

Made with by Xədicə Paşayeva: 📧 xadijapashayeva@gmail.com

LinkedIn: https://www.linkedin.com/in/xadija-pashayeva
