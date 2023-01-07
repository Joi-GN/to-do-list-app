package br.todo.DAO;

import br.todo.model.Task;
import br.todo.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joice
 */
public class TaskDAO {
    
    public void save(Task task) {
        String sql = "INSERT INTO tasks (idProject, name, description, notes, "
                + "completed, deadline, createdAt, updatedAt) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, task.getIdProject());
            s.setString(2, task.getName());
            s.setString(3, task.getDescription());
            s.setString(4, task.getNotes());
            s.setBoolean(5, task.isCompleted());
            s.setObject(6, task.getDeadline());
            s.setObject(7, task.getCreatedAt());
            s.setObject(8, task.getUpdatedAt());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar a tarefa", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
    }
    
    public void update(Task task) {
        String sql = "UPDATE tasks SET name = ?, description = ?, notes = ?, "
                + "completed = ?, deadline = ?, updatedAt = ? WHERE id = ?;";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, task.getName());
            s.setString(2, task.getDescription());
            s.setString(3, task.getNotes());
            s.setBoolean(4, task.isCompleted());
            s.setObject(5, task.getDeadline());
            s.setObject(6, task.getUpdatedAt());
            s.setInt(7, task.getId());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a tarefa", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
    }

    public void removeById(Integer taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?;";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, taskId);
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a tarefa", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
    }
    
    public List<Task> getAllTasksFromProject(Integer idProject) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE idProject = ?;";
        
        Connection c = null;
        PreparedStatement s = null;
        
        try {
            c = ConnectionFactory.getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, idProject);
            s.execute();
            turnResultSetIntoList(tasks, s);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao acessar tarefas", e);
        } finally {
            ConnectionFactory.closeConnection(c, s);
        }
        return tasks;
    }
    
    public void turnResultSetIntoList(List<Task> list, PreparedStatement s) {
        try (ResultSet r = s.getResultSet()) {
            while (r.next()) {
                Task task = new Task();
                task.setId(r.getInt("id"));
                task.setIdProject(r.getInt("idProject"));
                task.setName(r.getString("name"));
                task.setDescription(r.getString("description"));
                task.setCompleted(r.getBoolean("completed"));
                task.setNotes(r.getString("notes"));
                task.setDeadline(r.getObject("deadline", LocalDate.class));
                task.setCreatedAt(r.getObject("createdAt", LocalDateTime.class));
                task.setUpdatedAt(r.getObject("updatedAt", LocalDateTime.class));
                list.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar resultado do banco de dados", e);
        }
    }
    
}