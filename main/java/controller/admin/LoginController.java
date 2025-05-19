package controller.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.BookUserModel;
import service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Login attempt - Email: " + email + ", Password: " + password);

        BookUserModel user = loginService.authenticateUser(email, password);

        if (user != null) {
            System.out.println("Authentication successful for: " + email + ", Role: " + user.getRole());
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUserEmail", user.getEmail());
            session.setAttribute("loggedInUserName", user.getName());
            session.setAttribute("userRole", user.getRole()); // Store the role from the user object
            response.sendRedirect(request.getContextPath() + "/pages/home.jsp"); // Redirect to home page
            return; // Add return here to prevent further execution
        } else {
            System.out.println("Authentication failed for: " + email);
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        }
        System.out.println("doPost finished."); // Add this to see if the method completes
    }
}