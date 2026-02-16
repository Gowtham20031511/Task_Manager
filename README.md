# Task Manager

A full-stack **Task Manager application** built with **Spring Boot**, **PostgreSQL**, and **Vanilla JavaScript** for frontend.  
Easily manage tasks, mark them as completed, delete, restore, and search tasks with a sleek UI.

---

## 🌟 Features

- Add, edit, and delete tasks (soft delete to trash)  
- Toggle task status: Pending / Completed  
- Restore deleted tasks from trash  
- Search tasks by title  
- Responsive and modern UI with gradient backgrounds and animations  
- User login authentication (demo login: `admin/admin123`)  

---

## 💻 Tech Stack

**Backend:**  
- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  

**Frontend:**  
- HTML, CSS, JavaScript (Vanilla)  

---

## 📂 Project Structure

taskmanager/
├─ src/
│ ├─ main/java/com/gowtham/taskmanager/
│ │ ├─ controller/ # REST controllers
│ │ ├─ entity/ # Task entity
│ │ ├─ repository/ # JPA repository
│ │ └─ service/ # Business logic
│ └─ resources/
│ └─ application.properties # DB config
├─ .gitignore
├─ pom.xml
└─ README.md


Configure PostgreSQL in application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Run the application:
mvn spring-boot:run



