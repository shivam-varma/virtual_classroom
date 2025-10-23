package Com.virtualclassroom.ui;

import javax.swing.*;

import Com.virtualclassroom.model.User;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class RegisterFrame extends JFrame {
    private JTextField nameField, usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private JButton registerButton, loginLinkButton;

    public RegisterFrame() {
        setTitle("Virtual Classroom - Register");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 250, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fields
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0; gbc.gridy = 0; panel.add(nameLabel, gbc);
        nameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(nameField, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 1; panel.add(usernameLabel, gbc);
        usernameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 2; panel.add(passLabel, gbc);
        passwordField = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(passwordField, gbc);

        JLabel roleLabel = new JLabel("Role:");
        gbc.gridx = 0; gbc.gridy = 3; panel.add(roleLabel, gbc);
        roleBox = new JComboBox<>(new String[] {"student", "teacher"});
        gbc.gridx = 1; gbc.gridy = 3; panel.add(roleBox, gbc);

        registerButton = new JButton("Register");
        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(registerButton, gbc);

        loginLinkButton = new JButton("Already have an account? Login");
        loginLinkButton.setBorderPainted(false);
        loginLinkButton.setBackground(panel.getBackground());
        loginLinkButton.setForeground(Color.BLUE);
        gbc.gridx = 1; gbc.gridy = 5;
        panel.add(loginLinkButton, gbc);

        add(panel);
        setVisible(true);

        // Actions
        registerButton.addActionListener(e -> registerUser());
        loginLinkButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });
    }

    private void registerUser() {
        String name = nameField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String role = (String) roleBox.getSelectedItem();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            File file = new File("users.dat");
            ArrayList<User> users = new ArrayList<>();

            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                users = (ArrayList<User>) ois.readObject();
                ois.close();
            }

            users.add(new User(name, username, password, role));

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(users);
            oos.close();

            JOptionPane.showMessageDialog(this, "Registration successful!");
            dispose();
            new LoginFrame();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

