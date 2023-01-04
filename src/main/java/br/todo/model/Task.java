package br.todo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author joice
 */
public class Task {
    
    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean completed = false;
    private String notes;
    private LocalDate deadline;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    //    Constructor to use to save tasks
    public Task(int idProject, String name, String description, String notes, LocalDate deadline) {
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.deadline = deadline;
    }
    
    //    Contructor to use to update tasks
    public Task(int id, String name, String description, String notes, boolean completed, LocalDate deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.completed = completed;
        this.deadline = deadline;
    }
    
    //    Constructor to use to list tasks
    public Task(int id, int idProject, String name, String description, boolean completed, String notes, LocalDate deadline,
             LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.notes = notes;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public int getIdProject() {
        return idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + 
                name + ", description=" + description + ", completed=" + 
                completed + ", notes=" + notes + ", deadline=" + deadline + 
                ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
}