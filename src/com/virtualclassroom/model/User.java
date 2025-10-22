package com.virtualclassroom.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String username;
    private String password;
    private String role; // "student" or "teacher"

    public User(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
