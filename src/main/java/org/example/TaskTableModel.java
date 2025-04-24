package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {
    private final List<Todo> tasks;
    private final String[] columnNames = {"ID", "Title", "Completed", "Created"};

    public TaskTableModel() {
        this.tasks = new ArrayList<>();
    }
    public void setTasks(List<Todo> tasks) {
        this.tasks.clear();
        this.tasks.addAll(tasks);
        fireTableDataChanged();
    }
    public Todo getTaskAt(int row) {
        return tasks.get(row);
    }
    @Override
    public int getRowCount() {
        return tasks.size();
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Todo task = tasks.get(row);
        return switch (column) {
            case 0 -> task.getId();
            case 1 -> task.getTitle();
            case 2 -> task.isCompleted() ? "Yes" : "No";
            case 3 -> task.getCreated();
            default -> null;
        };
    }
}