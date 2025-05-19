package controller.admin;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.OrderItemModel;
import service.OrderService;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final OrderService orderService = new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("loggedInUserId") != null) {
            int userId = (int) session.getAttribute("loggedInUserId");
            // Retrieve cart items from session or request
            List<OrderItemModel> cartItems = getCartItemsFromSession(request); // Implement this method

            if (cartItems != null && !cartItems.isEmpty()) {
                int orderId = orderService.placeOrder(userId, cartItems);
                if (orderId != -1) {
                    // Order placed successfully
                    // Clear the cart from the session
                    clearCartFromSession(request); // Implement this method
                    response.sendRedirect(request.getContextPath() + "/orderConfirmation?orderId=" + orderId);
                } else {
                    // Order placement failed
                    request.setAttribute("error", "Failed to place order. Please try again.");
                    // Redirect back to the cart or checkout page
                    request.getRequestDispatcher("/cart").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Your cart is empty.");
                request.getRequestDispatcher("/cart").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=loginRequired");
        }
    }

    // Implement these methods to manage cart items in the session
    private List<OrderItemModel> getCartItemsFromSession(HttpServletRequest request) {
        // Example: Retrieve a list of OrderItemModel from the session
        return (List<OrderItemModel>) request.getSession().getAttribute("cartItems");
    }

    private void clearCartFromSession(HttpServletRequest request) {
        request.getSession().removeAttribute("cartItems");
    }
}