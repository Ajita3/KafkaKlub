package filter;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private static final String LOGIN = "/pages/login.jsp";
    private static final String REGISTER = "/register";
    private static final String HOME = "/home.jsp";
    private static final String ROOT = "/";
    private static final String ADMIN_DASHBOARD = "/admin/dashboard";
    private static final String MANAGE_BOOKS = "/manageBooks";
    private static final String BOOK_UPDATE = "/bookUpdate";
    // Add other admin URLs as needed
    private static final String ABOUT_US = "/pages/about.jsp";
    private static final String CONTACT_US = "/pages/contact.jsp";
    // Add other public/user URLs as needed

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic, if required
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        // Allow access to static resources (CSS, images, etc.)
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".gif")) {
            chain.doFilter(request, response);
            return;
        }

        boolean isLoggedIn = (session != null && session.getAttribute("loggedInUserEmail") != null);
        String userRole = (session != null) ? (String) session.getAttribute("userRole") : null;

        if (uri.startsWith(contextPath + "/admin") || uri.equals(contextPath + MANAGE_BOOKS) || uri.equals(contextPath + BOOK_UPDATE)) {
            // Protected admin area
            if (isLoggedIn && "admin".equals(userRole)) {
                chain.doFilter(request, response); // Allow admin access
            } else {
                res.sendRedirect(contextPath + LOGIN + "?error=adminRequired"); // Redirect if not admin
            }
        } else if (uri.equals(contextPath + LOGIN) || uri.equals(contextPath + REGISTER) || uri.equals(contextPath + HOME) || uri.equals(contextPath + ROOT) || uri.equals(contextPath + ABOUT_US) || uri.equals(contextPath + CONTACT_US) /* Add other public URLs */ ) {
            // Publicly accessible pages
            chain.doFilter(request, response);
        } else if (isLoggedIn) {
            // Logged-in user (non-admin) access
            chain.doFilter(request, response);
        } else {
            // Not logged in, redirect to login
            res.sendRedirect(contextPath + LOGIN);
        }
    }

    @Override
    public void destroy() {
        // Cleanup logic, if required
    }
}
