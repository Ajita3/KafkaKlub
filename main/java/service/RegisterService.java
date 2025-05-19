package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DbConfig;
import model.BookUserModel;
import util.PasswordUtil;

public class RegisterService {
    private Connection dbConn;

    public RegisterService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
            if (this.dbConn != null && !this.dbConn.isClosed()) {
                System.out.println("Database connection established in RegisterService.");
            } else {
                System.err.println("Failed to establish database connection in RegisterService.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error during RegisterService initialization: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Boolean registerUser(BookUserModel userModel) {
        if (dbConn == null) {
            System.err.println("Database connection is not available for registration.");
            return null;
        }

        // Check if the email already exists
        if (isEmailAlreadyRegistered(userModel.getEmail())) {
            System.out.println("Email already registered: " + userModel.getEmail());
            return false; // Indicate registration failure due to existing email
        }

        String insertQuery = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)"; // Added 'role' to the query
        try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {
            insertStmt.setString(1, userModel.getName());
            insertStmt.setString(2, userModel.getEmail());
            insertStmt.setString(3, userModel.getPassword()); // Encrypted password should already be in userModel
            insertStmt.setString(4, userModel.getRole());     // Set the role
            int rowsAffected = insertStmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error during user registration: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private boolean isEmailAlreadyRegistered(String email) {
        if (dbConn == null) {
            System.err.println("Database connection is not available for email check.");
            return false;
        }
        String query = "SELECT email FROM users WHERE email = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next(); // Returns true if the email exists
        } catch (SQLException e) {
            System.err.println("Error checking for existing email: " + e.getMessage());
            e.printStackTrace();
            return false; // Assume not registered to avoid potential registration bypass on error
        }
    }
}