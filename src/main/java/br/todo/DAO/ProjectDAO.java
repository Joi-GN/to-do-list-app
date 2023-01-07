package br.todo.DAO;

import br.todo.model.Project;
import br.todo.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joice
 */
public class ProjectDAO {
    
    public void save(Project project) {
        String sql = "INSERT INTO projects (name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?);";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, project.getName());
            s.setString(2, project.getDescription());
            s.setObject(3, project.getCreatedAt());
            s.setObject(4, project.getUpdatedAt());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o projeto", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
        
    }
    
    public void update(Project project) {
        String sql = "UPDATE projects SET name = ?, description = ?, updatedAt = ? WHERE id = ?;";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, project.getName());
            s.setString(2, project.getDescription());
            s.setObject(3, project.getUpdatedAt());
            s.setInt(4, project.getId());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o projeto", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
    }
    
    public void removeById(int projectId) {
        String sql = "DELETE FROM projects WHERE id = ?;";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, projectId);
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o projeto", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
    }
    
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects;";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.execute();
            turnResultSetIntoList(projects, s);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar projetos", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
        return projects;
    }
    
    public void turnResultSetIntoList(List<Project> list, PreparedStatement s) {
        try(ResultSet r = s.getResultSet()) {
            while (r.next()) {
                Project project = new Project();
                project.setId(r.getInt("id"));
                project.setName(r.getString("name"));
                project.setDescription(r.getString("description"));
                project.setCreatedAt(r.getObject("createdAt", LocalDateTime.class));
                project.setUpdatedAt(r.getObject("updatedAt", LocalDateTime.class));
                list.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar resultado do banco de dados", e);
        }
    }
    
}