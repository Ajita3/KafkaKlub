package controller.admin;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import util.CookieUtil; // Assuming you have a CookieUtil class
import util.SessionUtil; // Assuming you have a SessionUtil class

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session
        SessionUtil.invalidateSession(request);

        // Delete any relevant cookies (e.g., for remember me functionality, if implemented)
        // Example:
        // CookieUtil.deleteCookie(response, "loggedInUserEmail");

        // Redirect to the login page with a message (optional)
        response.sendRedirect(request.getContextPath() + "/pages/login.jsp?logout=true");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // It's common to handle logout via GET request, but doPost can also be used.
        doGet(request, response); // Just call the doGet method for simplicity
    }
}