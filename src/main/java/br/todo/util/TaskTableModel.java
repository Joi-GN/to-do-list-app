package br.todo.util;

import br.todo.model.Task;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joice
 */
public class TaskTableModel extends AbstractTableModel {

    private String[] columns = {"Nome", "Descrição", "Prazo", "Concluída", 
        "Editar", "Deletar"};
    private List<Task> tasks = new ArrayList<>();
    
    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: 
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2: 
                return tasks.get(rowIndex).getDeadline().format(DateTimeFormatter.ofPattern("dd/LL/yy"));
            case 3:
                return tasks.get(rowIndex).isCompleted();
            case 4: 
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";
        }
    }
    
      
    @Override
    public Class<?> getColumnClass(int columIndex) {
        if (tasks.isEmpty()) return Object.class;
        else return this.getValueAt(0, columIndex).getClass();
    }
    

       @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columns[columnIndex].equals("Concluída");
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setCompleted((boolean) aValue);
    }
    
}
