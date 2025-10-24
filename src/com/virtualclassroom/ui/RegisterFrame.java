package Com.virtualclassroom.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Com.virtualclassroom.data.UserManager;
import Com.virtualclassroom.model.User;

public class RegisterFrame extends JFrame {
    private JTextField nameField, usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private JButton registerButton, backButton;

    public RegisterFrame() {
        setTitle("Register - Virtual Classroom");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel nameLabel = new JLabel("Full Name:");
        nameField = new JTextField();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel roleLabel = new JLabel("Role:");
        roleBox = new JComboBox<>(new String[]{"Teacher", "Student"});

        registerButton = new JButton("Register");
        backButton = new JButton("Back to Login");

        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(roleLabel);
        add(roleBox);
        add(registerButton);
        add(backButton);

        registerButton.addActionListener(e -> registerUser());
        backButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText().trim();
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String role = (String) roleBox.getSelectedItem();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        User newUser = new User(name, username, password, role);
        boolean success = UserManager.registerUser(newUser);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registration successful! You can now log in.");
            dispose();
            new LoginFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists!");
        }
    }
}
