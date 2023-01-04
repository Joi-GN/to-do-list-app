package br.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joice
 */
public class ConnectionFactory {
    
    public static final String URL = "jdbc:mysql://localhost:3306/todo_app";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao tentar se conectar com o banco de dados ", ex);
        }   
    }
    
    public static void closeConnection(Connection c) {
        try {
            if (c != null) c.close();            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
   
    public static void closeConnection(Connection c, PreparedStatement s) {
        try {
            if (c != null) c.close();
            if (s != null) s.close();            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection c, PreparedStatement s, ResultSet r) {
        try {
            if (c != null) c.close();
            if (s != null) s.close();            
            if (r != null) r.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
}
