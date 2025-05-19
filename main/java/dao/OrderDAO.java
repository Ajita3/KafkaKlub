package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import config.DbConfig;
import model.OrderModel;

public class OrderDAO {

    private Connection dbConn;

    public OrderDAO() {
    	 try {
			dbConn = DbConfig.getDbConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public int createOrder(int userId, double totalAmount) {
        String query = "INSERT INTO orders (user_id, total_amount, order_status) VALUES (?, ?, 'PENDING')";
        try (PreparedStatement stmt = dbConn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, userId);
            stmt.setDouble(2, totalAmount);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Return the generated order ID
            }
        } catch (SQLException e) {
            System.err.println("Error creating order: " + e.getMessage());
        }
        return -1; // Indicate failure
    }

    public OrderModel getOrderById(int orderId) {
        String query = "SELECT order_id, user_id, order_date, total_amount, order_status FROM orders WHERE order_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                Timestamp timestamp = rs.getTimestamp("order_date");
                order.setOrderDate(timestamp != null ? timestamp.toLocalDateTime() : null);
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderStatus(rs.getString("order_status"));
                return order;
            }
        } catch (SQLException e) {
            System.err.println("Error getting order by ID: " + e.getMessage());
        }
        return null;
    }

    public List<OrderModel> getRecentOrders(int limit) {
        List<OrderModel> recentOrders = new ArrayList<>();
        String query = "SELECT order_id, user_id, order_date, total_amount, order_status " +
                       "FROM orders ORDER BY order_date DESC LIMIT ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                Timestamp timestamp = rs.getTimestamp("order_date");
                order.setOrderDate(timestamp != null ? timestamp.toLocalDateTime() : null);
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setOrderStatus(rs.getString("order_status"));
                recentOrders.add(order);
            }
        } catch (SQLException e) {
            System.err.println("Error getting recent orders: " + e.getMessage());
        }
        return recentOrders;
    }
}