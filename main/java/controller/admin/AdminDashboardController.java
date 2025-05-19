package controller.admin;


import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.OrderModel;
import service.UserService; 
import service.BookService;  
import service.OrderService; 

@WebServlet("/admin/dashboard")
public class AdminDashboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;
    private BookService bookService;
    private OrderService orderService;

    public AdminDashboardController() {
        this.userService = new UserService(); // Initialize UserService
        this.bookService = new BookService();   // Initialize BookService
        this.orderService = new OrderService(); // Initialize OrderService
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && "admin".equals(session.getAttribute("userRole"))) {
            // Fetch data for the admin dashboard
            int totalUsers = userService.getTotalUsers();
            int totalBooks = bookService.getTotalBooks();
            List<OrderModel> recentOrders = orderService.getRecentOrders(totalBooks); 
            // Set the data as request attributes
            request.setAttribute("totalUsers", totalUsers);
            request.setAttribute("totalBooks", totalBooks);
             request.setAttribute("recentOrders", recentOrders);

            // Forward the request to the admin dashboard JSP
            request.getRequestDispatcher("/pages/admindashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=unauthorized");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle any POST requests to the admin dashboard if needed
    }
}