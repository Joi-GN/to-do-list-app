CREATE DATABASE todo_app;

USE todo_app;

CREATE TABLE projects (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL, description VARCHAR(255), createdAt DATETIME NOT NULL, updatedAt DATETIME NOT NULL);

CREATE TABLE tasks (id INT PRIMARY KEY AUTO_INCREMENT, idProject INT NOT NULL, name VARCHAR(50) NOT NULL, description VARCHAR(255), completed BOOLEAN NOT NULL, notes VARCHAR(255), deadline DATE NOT NULL, createdAt DATETIME NOT NULL, updatedAt DATETIME NOT NULL, CONSTRAINT FK_project FOREIGN KEY (idProject) REFERENCES projects(id));
