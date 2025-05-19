package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import config.DbConfig;
import model.OrderItemModel;

public class OrderItemDAO {

    private Connection dbConn;

    public OrderItemDAO() {
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

    public boolean addOrderItem(OrderItemModel orderItem) {
        String query = "INSERT INTO order_items (order_id, book_id, quantity, price_per_item) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getBookId());
            stmt.setInt(3, orderItem.getQuantity());
            stmt.setDouble(4, orderItem.getPricePerItem());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error adding order item: " + e.getMessage());
        }
        return false;
    }

    public List<OrderItemModel> getOrderItemsByOrderId(int orderId) {
        List<OrderItemModel> orderItems = new ArrayList<>();
        String query = "SELECT order_item_id, book_id, quantity, price_per_item FROM order_items WHERE order_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrderItemModel item = new OrderItemModel();
                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(orderId);
                item.setBookId(rs.getInt("book_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setPricePerItem(rs.getDouble("price_per_item"));
                orderItems.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error getting order items by order ID: " + e.getMessage());
        }
        return orderItems;
    }
}