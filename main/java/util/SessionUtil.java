package util;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
/**
 * Utility class for managing HTTP sessions in a web application.
 * Provides methods to set, get, remove session attributes and invalidate sessions.
 */
public class SessionUtil {

    /**
     * Sets an attribute in the session.
     *
     * @param request the HttpServletRequest from which the session is obtained
     * @param key     the key under which the attribute is stored
     * @param value   the value of the attribute to store in the session
     */
    public static void setAttribute(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    /**
     * Retrieves an attribute from the session.
     *
     * @param request the HttpServletRequest from which the session is obtained
     * @param key     the key of the attribute to retrieve
     * @return the attribute value, or null if the attribute does not exist or the session is invalid
     */
    public static Object getAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return session.getAttribute(key);
        }
        return null;
    }

    /**
     * Removes an attribute from the session.
     *
     * @param request the HttpServletRequest from which the session is obtained
     * @param key     the key of the attribute to remove
     */
    public static void removeAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }

    /**
     * Invalidates the current session.
     *
     * @param request the HttpServletRequest from which the session is obtained
     */
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}