package Com.virtualclassroom.ui;

import javax.swing.*;

import Com.virtualclassroom.model.User;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    public LoginFrame() {
        setTitle("Virtual Classroom - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 0; panel.add(userLabel, gbc);
        usernameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 1; panel.add(passLabel, gbc);
        passwordField = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(passwordField, gbc);

        loginButton = new JButton("Login");
        gbc.gridx = 1; gbc.gridy = 2; panel.add(loginButton, gbc);

        registerButton = new JButton("New user? Register here");
        registerButton.setBorderPainted(false);
        registerButton.setBackground(panel.getBackground());
        registerButton.setForeground(Color.BLUE);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(registerButton, gbc);

        add(panel);
        setVisible(true);

        // Button actions
        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            File file = new File("users.dat");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "No users registered yet!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<User> users = (ArrayList<User>) ois.readObject();
            ois.close();

            boolean found = false;
            for (User u : users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    found = true;
                    JOptionPane.showMessageDialog(this, "Welcome " + u.getName() + "! Logged in as " + u.getRole());
                    dispose();

                    // Role-based navigation (we'll make these next)
                    if (u.getRole().equalsIgnoreCase("teacher")) {
                        new TeacherDashboard(u);
                    } else {
                        new StudentDashboard(u);
                    }
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
