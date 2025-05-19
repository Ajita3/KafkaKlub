package controller.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.BookUserModel;
import service.RegisterService;
import util.PasswordUtil;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final RegisterService registerService = new RegisterService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Encrypt the password using PasswordUtil
        String encryptedPassword = PasswordUtil.encrypt(password, email); // Using email as part of the key derivation

        if (encryptedPassword != null) {
            BookUserModel userModel = new BookUserModel(name, email, encryptedPassword);
            Boolean registrationSuccess = registerService.registerUser(userModel);

            if (registrationSuccess != null && registrationSuccess) {
                System.out.println("Registration successful for: " + email);
                response.sendRedirect(request.getContextPath() + "/pages/login.jsp?registrationSuccess=true");
            } else {
                System.err.println("Registration failed for: " + email);
                request.setAttribute("error", "Registration failed. Email might already exist.");
                request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
            }
        } else {
            System.err.println("Password encryption failed for: " + email);
            request.setAttribute("error", "Registration failed due to password encryption error.");
            request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
        }
    }
}