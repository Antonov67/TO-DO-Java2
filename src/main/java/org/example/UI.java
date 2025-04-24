package org.example;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    private final TodoService service;
    private final TaskTableModel tableModel;
    private JTable taskTable;

    public UI() {
        service = new TodoService();
        tableModel = new TaskTableModel();

        initializeUI();
        loadTodos();
    }

    private void initializeUI() {
        setTitle("Список дел");
        setBounds(100, 100, 600, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Таблица задач
        taskTable = new JTable(tableModel);
        add(new JScrollPane(taskTable), BorderLayout.CENTER);
        // Панель кнопок
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Task");
        // addButton.addActionListener(this::addTask);

        JButton completeButton = new JButton("Toggle Complete");
        // completeButton.addActionListener(this::toggleComplete);

        JButton deleteButton = new JButton("Delete Task");
        // deleteButton.addActionListener(this::deleteTask);

        JButton refreshButton = new JButton("Refresh");

        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadTodos(){
        service.getTodos(new SimpleDataCallback<ResponseTodo>() {
            @Override
            public void load(ResponseTodo data) {
                tableModel.setTasks(data.getTodoList());
            }
        });
    }

}
