package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DbConfig;
import model.BookUserModel;
import util.PasswordUtil;

public class LoginService {
    private Connection dbConn;
    private boolean isConnectionError = false;

    public LoginService() {
        try {
            dbConn = DbConfig.getDbConnection();
            if (dbConn != null && !dbConn.isClosed()) {
                System.out.println("Database connection established in LoginService.");
            } else {
                System.err.println("Failed to establish database connection in LoginService.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    public BookUserModel authenticateUser(String email, String password) {
        if (isConnectionError) {
            System.err.println("Database connection error during authentication.");
            return null;
        }

        // Modified query to select the role as well
        String query = "SELECT name, password, role FROM users WHERE email = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                String storedEncryptedPassword = result.getString("password");
                String name = result.getString("name");
                String role = result.getString("role"); // Retrieve the role

                String decryptedPassword = PasswordUtil.decrypt(storedEncryptedPassword, email);
                if (decryptedPassword != null && decryptedPassword.equals(password)) {
                    System.out.println("Authentication successful for email: " + email + ", Role: " + role);
                    return new BookUserModel(name, email, null, role); // Include the role in the returned object
                } else {
                    System.out.println("Authentication failed for email: " + email + " (password mismatch).");
                    return null;
                }
            } else {
                System.out.println("Authentication failed for email: " + email + " (user not found).");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error during user authentication: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Boolean loginUser(BookUserModel userModel) {
        if (isConnectionError) {
            System.out.println("Connection Error!");
            return null;
        }

        String query = "SELECT email, password FROM users WHERE email = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, userModel.getEmail());
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                return validatePassword(result, userModel.getPassword(), userModel.getEmail());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return false;
    }

    private boolean validatePassword(ResultSet result, String enteredPassword, String email) throws SQLException {
        String dbPassword = result.getString("password");
        String decryptedPassword = PasswordUtil.decrypt(dbPassword, email);
        return decryptedPassword != null && decryptedPassword.equals(enteredPassword);
    }
}