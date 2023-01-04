package br.todo.model;

import java.time.LocalDateTime;

/**
 *
 * @author joice
 */
public class Project {
    
    private int id;
    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    //    Constructor to use to save projects
    public Project(String name, String description) {
        this.name = name;
        this.description = description;        
    }
    
    //    Constructor to use to update projects
    public Project(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;        
    }
    
    //    Constructor to use to list projects    
    public Project(int id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
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
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + 
                description + ", createdAt=" + createdAt + ", updatedAt=" + 
                updatedAt + '}';
    }
    
    
}
