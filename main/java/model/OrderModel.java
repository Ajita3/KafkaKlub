package model;

import java.time.LocalDateTime;
import java.util.List;

public class OrderModel {
    private int orderId;
    private int userId; // Foreign key to the users table
    private LocalDateTime orderDate;
    private double totalAmount;
    private String orderStatus; // e.g., "Pending", "Processing", "Shipped", "Delivered"
    // private List<OrderItemModel> orderItems; // If you want to include order items directly

    // Constructors
    public OrderModel() {
    }

    public OrderModel(int orderId, int userId, LocalDateTime orderDate, double totalAmount, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // public List<OrderItemModel> getOrderItems() {
    //     return orderItems;
    // }
    //
    // public void setOrderItems(List<OrderItemModel> orderItems) {
    //     this.orderItems = orderItems;
    // }
}