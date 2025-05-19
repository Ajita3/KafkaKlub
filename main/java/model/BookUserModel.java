package model;

public class BookUserModel {
    private String name;
    private String email;
    private String password;
    private String role; // Add this line

    // Existing constructor(s)
    public BookUserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "user"; // Default role for new users
    }

    // Add a constructor that includes the role (when fetching from the database)
    public BookUserModel(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and setters for the new 'role' field
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Existing getters and setters for name, email, and password
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	

	
	
}