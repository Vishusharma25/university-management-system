# 🎓 University Management System

A comprehensive, full-stack Academic Management Solution built with **Java Swing** and **MySQL**. This system streamlines university operations, including student and faculty management, fee processing, examination results, and leave tracking.

![Dashboard Preview](src/icons/first.jpg)

## 🌟 Key Features

### 👨‍🎓 Student Management
- **Admissions:** Enroll new students with detailed personal and academic profiles.
- **Student Records:** View and filter student details using dynamic search functionality.
- **Update Profile:** Seamlessly update existing student information.

### 👩‍🏫 Faculty Management
- **Teacher Recruitment:** Add new faculty members with specialization and department details.
- **Faculty Records:** Comprehensive view of all working staff.
- **Update Records:** Easy modification of teacher profiles.

### 📅 Leave & Attendance
- **Leave Application:** Dedicated modules for both students and teachers to apply for leave.
- **Leave History:** Track and maintain leave records.

### 📝 Academic Module
- **Examination Details:** View upcoming schedules and result status.
- **Marksheet Management:** Enter and record student marks for various semesters.
- **Result Viewing:** Students/Admins can view detailed result breakdowns.

### 💰 Fee System
- **Fee Structure:** View the standard fee breakdown for different courses (B.Tech, BBA, BCA, etc.).
- **Payment Portal:** Pay semester fees and check payment history.

### 🎨 Modern UI
- **Splash Screen:** Elegant loading animation on startup.
- **Administrative Login:** Secure access for authorized personnel.
- **Main Dashboard:** A robust menu-driven interface using Java Swing.

## 🛠️ Technology Stack

| Components | Technology |
|---|---|
| **Language** | Java (JDK 11+) |
| **GUI Framework** | Java Swing & AWT |
| **Database** | MySQL |
| **Connection** | JDBC (MySQL Connector) |
| **Web Tech** | HTML5, CSS3, JavaScript (Frontend Preview) |

## 📸 Screenshots

| Splash Screen | Login Page |
|:---:|:---:|
| ![Splash](src/icons/first.jpg) | ![Login](src/icons/second.jpg) |

| Fee Structure | About Us |
|:---:|:---:|
| ![Fee](src/icons/fee.jpg) | ![About](src/icons/about.jpg) |

## ⚙️ Installation & Setup

### 1. Prerequisites
- **Java Development Kit (JDK)** installed.
- **MySQL Server** installed and running.
- **MySQL Connector/J** (JAR file) for database connectivity.

### 2. Database Configuration
Run the following SQL script in your MySQL Workbench or Command Line to set up the environment:
```sql
CREATE DATABASE universitymanagementsystem;
USE universitymanagementsystem;

-- All necessary tables (login, student, teacher, marks, fee, etc.)
-- are provided in the database_setup.sql file.
```

### 3. Clone & Run
```bash
# Clone the repository
git clone https://github.com/yourusername/university-management-system.git

# Compile the core files
javac -d . src/university/management/system/*.java

# Run the Splash Screen (Entry Point)
java university.management.system.Splash
```

## 📁 Project Structure

```text
university-management-system/
├── src/
│   ├── university/management/system/
│   │   ├── Login.java
│   │   ├── AddStudent.java
│   │   ├── FeeStructure.java
│   │   └── ... (Other modules)
│   └── icons/              # Project Assets & Images
├── web/                    # Landing Page Mockup
├── database_setup.sql      # MySQL DB Schema
└── README.md
```

## 🤝 Contribution
Contributions are always welcome! Feel free to fork the repo and create a pull request.

---
*Created with ❤️ by the Developer Team*
