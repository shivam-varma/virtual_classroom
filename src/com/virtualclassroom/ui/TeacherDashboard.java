package Com.virtualclassroom.ui;

import javax.swing.*;

import Com.virtualclassroom.model.User;

import java.awt.*;

public class TeacherDashboard extends JFrame {

    private User currentUser;

    public TeacherDashboard(User user) {
        this.currentUser = user;

        setTitle("Teacher Dashboard - " + user.getName());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 255));

        JLabel welcome = new JLabel("Welcome, " + user.getName() + " (Teacher)", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel buttonPanel = new JPanel();
        JButton createAssignmentBtn = new JButton("Create Assignment");
        JButton editAssignmentBtn = new JButton("Edit Assignments");
        JButton logoutBtn = new JButton("Logout");

        buttonPanel.add(createAssignmentBtn);
        buttonPanel.add(editAssignmentBtn);
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
