package br.todo.view;

import br.todo.DAO.ProjectDAO;
import br.todo.DAO.TaskDAO;
import br.todo.model.Project;
import br.todo.model.Task;
import br.todo.util.TaskTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author joice
 */
public class MainScreen extends javax.swing.JFrame {
    
    ProjectDAO projectDAO;
    TaskDAO taskDAO;
    DefaultListModel projectsModel;
    TaskTableModel tasksModel;
   
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        initDAO();
        initComponentsModel();
        styleTableTasks();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabelHeaderTitle = new javax.swing.JLabel();
        jLabelHeaderSubtitle = new javax.swing.JLabel();
        jSplitPaneProjectsTasks = new javax.swing.JSplitPane();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jButtonAddTasks = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jButtonAddProject = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To Do List");
        setMaximumSize(new java.awt.Dimension(1600, 1200));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanelHeader.setBackground(new java.awt.Color(0, 153, 102));

        jLabelHeaderTitle.setFont(new java.awt.Font("Fira Sans Ultra", 0, 36)); // NOI18N
        jLabelHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeaderTitle.setText("To Do List");

        jLabelHeaderSubtitle.setFont(new java.awt.Font("Fira Sans Medium", 0, 12)); // NOI18N
        jLabelHeaderSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeaderSubtitle.setText("Organize suas tarefas. Termine seus projetos.");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHeaderLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelHeaderSubtitle))
                    .addComponent(jLabelHeaderTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabelHeaderTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHeaderSubtitle)
                .addGap(44, 44, 44))
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasks.setMinimumSize(new java.awt.Dimension(400, 0));

        jLabelTasksTitle.setFont(new java.awt.Font("Fira Sans Heavy", 0, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTasksTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTasksTitle.setText("Tarefas");

        jButtonAddTasks.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddTasks.setFont(new java.awt.Font("Fira Sans Medium", 1, 30)); // NOI18N
        jButtonAddTasks.setForeground(new java.awt.Color(0, 153, 102));
        jButtonAddTasks.setText(" + ");
        jButtonAddTasks.setToolTipText("Adicionar nova tarefa");
        jButtonAddTasks.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAddTasks.setFocusPainted(false);
        jButtonAddTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddTasksMouseClicked(evt);
            }
        });

        jTableTasks.setAutoCreateRowSorter(true);
        jTableTasks.setBackground(new java.awt.Color(255, 255, 255));
        jTableTasks.setFont(new java.awt.Font("Fira Sans Light", 1, 14)); // NOI18N
        jTableTasks.setForeground(new java.awt.Color(0, 153, 102));
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Prazo", "Concluída"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setRowHeight(50);
        jTableTasks.setRowMargin(5);
        jTableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTableTasks.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowGrid(false);
        jTableTasks.setShowHorizontalLines(true);
        jScrollPaneTasks.setViewportView(jTableTasks);

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTasks, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(jPanelTasksLayout.createSequentialGroup()
                        .addComponent(jLabelTasksTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddTasks)))
                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneTasks, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPaneProjectsTasks.setRightComponent(jPanelTasks);

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjects.setMinimumSize(new java.awt.Dimension(150, 100));

        jLabelProjectsTitle.setFont(new java.awt.Font("Fira Sans Heavy", 0, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelProjectsTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectsTitle.setText("Projetos");

        jButtonAddProject.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddProject.setFont(new java.awt.Font("Fira Sans Medium", 1, 30)); // NOI18N
        jButtonAddProject.setForeground(new java.awt.Color(0, 153, 102));
        jButtonAddProject.setText(" + ");
        jButtonAddProject.setToolTipText("Adicionar novo projeto");
        jButtonAddProject.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAddProject.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonAddProject.setFocusPainted(false);
        jButtonAddProject.setNextFocusableComponent(jButtonAddTasks);
        jButtonAddProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddProjectMouseClicked(evt);
            }
        });

        jScrollPaneProjects.setBorder(null);

        jListProjects.setBackground(new java.awt.Color(255, 255, 255));
        jListProjects.setFont(new java.awt.Font("Fira Sans Light", 1, 14)); // NOI18N
        jListProjects.setForeground(new java.awt.Color(0, 0, 0));
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(50);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jListProjects.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelProjectsLayout.createSequentialGroup()
                        .addComponent(jLabelProjectsTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jButtonAddProject)))
                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddProject, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPaneProjectsTasks.setLeftComponent(jPanelProjects);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPaneProjectsTasks)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPaneProjectsTasks, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddProjectMouseClicked
        ProjectDialogScreen projectDialog = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
        projectDialog.setVisible(true);
        
        projectDialog.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e) {
                loadProjects();
            }
        });
    }//GEN-LAST:event_jButtonAddProjectMouseClicked

    private void jButtonAddTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddTasksMouseClicked
        TaskDialogScreen taskDialog = new TaskDialogScreen(this, rootPaneCheckingEnabled);
        taskDialog.setProject(getSelectedProject());
        taskDialog.setVisible(true);
    }//GEN-LAST:event_jButtonAddTasksMouseClicked

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        loadTasks(getSelectedProject().getId());
    }//GEN-LAST:event_jListProjectsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProject;
    private javax.swing.JButton jButtonAddTasks;
    private javax.swing.JLabel jLabelHeaderSubtitle;
    private javax.swing.JLabel jLabelHeaderTitle;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSplitPane jSplitPaneProjectsTasks;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables

    private void initDAO() {
        projectDAO = new ProjectDAO();
        taskDAO = new TaskDAO();
    }
    
    private void initComponentsModel() {
        projectsModel = new DefaultListModel<>();
        loadProjects();
        if (!projectsModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            tasksModel = new TaskTableModel();
            jTableTasks.setModel(tasksModel);
            loadTasks(getSelectedProject().getId());
        }
    }

    private void loadProjects() {
        List<Project> projects = projectDAO.getAllProjects();
        projectsModel.clear();
        for (Project project : projects) {
            projectsModel.addElement(project);
        }
        jListProjects.setModel(projectsModel);
    }
    
    private void loadTasks(int idProject) {
        List<Task> tasks = taskDAO.getAllTasksFromProject(idProject);
        tasksModel.setTasks(tasks);
        tasksModel.fireTableDataChanged(); /*Notifies data changes to JTable*/
    }
    
    private Project getSelectedProject() {
        int projectIndex = jListProjects.getSelectedIndex();
	Project selectedProject = (Project) projectsModel.get(projectIndex);
        return selectedProject;
    }
    
    private void styleTableTasks() {
        jTableTasks.getTableHeader().setFont(new Font("Fire Sans Thin", Font.BOLD, 14));
        jTableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));
    }
    
}