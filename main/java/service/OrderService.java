package service;

import java.util.List;

import dao.OrderDAO;
import dao.OrderItemDAO;
import model.OrderItemModel;
import model.OrderModel;

public class OrderService {

    private final OrderDAO orderDAO = new OrderDAO();
    private final OrderItemDAO orderItemDAO = new OrderItemDAO();
    private final BookService bookService = new BookService(); // To get book price

    public int placeOrder(int userId, List<OrderItemModel> cartItems) {
        double totalAmount = 0;
        for (OrderItemModel item : cartItems) {
            // Ideally, you'd fetch the current price from the database
            // to prevent manipulation on the client-side.
            totalAmount += item.getPricePerItem() * item.getQuantity();
        }

        int orderId = orderDAO.createOrder(userId, totalAmount);
        if (orderId != -1) {
            for (OrderItemModel item : cartItems) {
                item.setOrderId(orderId);
                if (!orderItemDAO.addOrderItem(item)) {
                    // Handle failure to add order item (e.g., rollback order?)
                    System.err.println("Error adding order item for order ID: " + orderId + ", book ID: " + item.getBookId());
                    return -1; // Indicate failure
                }
                // Optionally update book stock here
            }
            return orderId;
        }
        return -1;
    }

    public OrderModel getOrderDetails(int orderId) {
        OrderModel order = orderDAO.getOrderById(orderId);
        if (order != null) {
            List<OrderItemModel> orderItems = orderItemDAO.getOrderItemsByOrderId(orderId);
            // You might want to enrich OrderItemModel with Book details here
            // (e.g., fetch book title using bookService.getBookById())
            // order.setOrderItems(orderItems); // If you add this to OrderModel
        }
        return order;
    }

    public List<OrderModel> getRecentOrders(int limit) {
        return orderDAO.getRecentOrders(limit);
    }
}