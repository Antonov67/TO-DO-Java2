package org.example;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    public UI() {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Список дел");
        setBounds(100, 100, 600, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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


}
