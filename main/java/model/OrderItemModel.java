package model;



public class OrderItemModel {
    private int orderItemId;
    private int orderId; // Foreign key to the orders table
    private int bookId;  // Foreign key to the books table
    private int quantity;
    private double pricePerItem;

    // Constructors
    public OrderItemModel() {
    }

    public OrderItemModel(int orderId, int bookId, int quantity, double pricePerItem) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public OrderItemModel(int orderItemId, int orderId, int bookId, int quantity, double pricePerItem) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    // Getters and Setters
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
}