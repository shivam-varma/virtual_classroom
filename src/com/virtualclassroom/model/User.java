package Com.virtualclassroom.model;

public class User {
    private String username;
    private String password;
    private String role; // "Teacher" or "Student"

    // ✅ Constructor that takes 3 parameters
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // ✅ Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // ✅ To display in JList or logs
    @Override
    public String toString() {
        return username + " (" + role + ")";
    }
}
