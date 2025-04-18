# HallMatrix - Smart Hall Reservation System

## 📋 Project Description
**HallMatrix** is a Java console-based Smart Hall Reservation System designed to help universities efficiently manage the booking of classrooms and labs.  
The system leverages core Java concepts like Object-Oriented Programming (OOP), Multi-threading, Exception Handling, and File I/O operations.

It offers different menu-driven interactions based on user roles — Admin, Faculty, and Student.

---

## 🚀 Getting Started

### Prerequisites:
- Java SE 8 or higher
- A text file named `faculty_credentials.txt` (for Faculty login and registration)

### Steps to Run:
1. Clone or download the project files.
2. Open the project in an IDE (like VS Code, IntelliJ) or terminal.
3. Compile the code:
   ```bash
   javac *.java
  
4. Run the program:
   ```bash
   java HallMatrix
   ```

---

## 🎯 Features

- **Admin**:
  - View all reservations
  - Approve or reject pending reservations
- **Faculty**:
  - Register/Login
  - Book halls
  - View all reservations
- **Student**:
  - View existing reservations (read-only)
- **Common Features**:
  - Loading bar animation using multi-threading
  - File handling for Faculty credentials
  - User-friendly console menus

---

## 👥 User Roles

| User Type    | Permissions                                    |
|:-------------|:----------------------------------------------|
| Admin        | Full access (view, approve, reject)           |
| Faculty      | Book halls and view reservations              |
| Student      | View reservations (read-only)                 |

---

## 🛠 Technologies Used

- **Programming Language**: Java
- **Concepts**:
  - Object-Oriented Programming (OOP)
  - Multi-threading
  - Exception Handling
  - File I/O (Faculty credentials management)
