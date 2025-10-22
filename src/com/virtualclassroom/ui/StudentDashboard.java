package com.virtualclassroom.ui;

import javax.swing.*;
import java.awt.*;
import com.virtualclassroom.model.User;

public class StudentDashboard extends JFrame {

    private User currentUser;

    public StudentDashboard(User user) {
        this.currentUser = user;

        setTitle("Student Dashboard - " + user.getName());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 255, 240));

        JLabel welcome = new JLabel("Welcome, " + user.getName() + " (Student)", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel buttonPanel = new JPanel();
        JButton viewAssignmentsBtn = new JButton("View Assignments");
        JButton submitWorkBtn = new JButton("Submit Assignment");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(viewAssignmentsBtn);
        buttonPanel.add(submitWorkBtn);
        buttonPanel.add(logoutBtn);

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        panel.add(welcome, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}

