package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DbConfig; // Assuming you have this

public class UserService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    public UserService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    public int getTotalUsers() {
        if (isConnectionError) {
            System.err.println("Database connection error.");
            return -1;
        }

        String countQuery = "SELECT COUNT(*) FROM users";
        try (PreparedStatement stmt = dbConn.prepareStatement(countQuery);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}