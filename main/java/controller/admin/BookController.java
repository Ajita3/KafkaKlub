package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import model.BookModel;
import service.BookService;
import util.ImageUtil;
import util.SessionUtil;

@WebServlet("/admin/books")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final BookService bookService = new BookService();
    private final ImageUtil imageUtil = new ImageUtil();
    private final String BOOK_COVER_FOLDER = "book_covers";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("addForm".equals(action)) {
            request.getRequestDispatcher("/pages/admin/add_book.jsp").forward(request, response);
        } else if ("updateForm".equals(action)) {
            String bookIdStr = request.getParameter("bookId");
            try {
                int bookId = Integer.parseInt(bookIdStr);
                BookModel book = bookService.getBookById(bookId);
                if (book != null) {
                    request.setAttribute("book", book);
                    request.getRequestDispatcher("/pages/admin/book_update.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Book not found.");
                    displayBookList(request, response);
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Invalid book ID.");
                displayBookList(request, response);
            }
        } else {
            displayBookList(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            handleAdd(request, response);
        } else if ("update".equals(action)) {
            handleUpdate(request, response);
        } else if ("delete".equals(action)) {
            handleDelete(request, response);
        } else {
            displayBookList(request, response);
        }
    }

    private void displayBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bookList", bookService.getAllBooks());
        request.getRequestDispatcher("/pages/admin/manage_books.jsp").forward(request, response);
    }

    private void handleAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String priceStr = request.getParameter("price");
        double price = 0.0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid price format.");
            request.getRequestDispatcher("/pages/admin/add_book.jsp").forward(request, response);
            return;
        }

        Part filePart = request.getPart("coverImageFile");
        String coverImageFileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            String rootPath = getServletContext().getRealPath("/");
            if (imageUtil.uploadImage(filePart, rootPath, BOOK_COVER_FOLDER)) {
                coverImageFileName = imageUtil.getImageNameFromPart(filePart);
            } else {
                request.setAttribute("error", "Failed to upload cover image.");
                request.getRequestDispatcher("/pages/admin/add_book.jsp").forward(request, response);
                return;
            }
        } else {
            coverImageFileName = "default_book_cover.png"; // Or handle as needed
        }

        BookModel book = new BookModel(title, author, isbn, price, coverImageFileName);
        if (bookService.addBook(book)) {
            request.setAttribute("success", "Book added successfully.");
            displayBookList(request, response);
        } else {
            request.setAttribute("error", "Failed to add book.");
            request.getRequestDispatcher("/pages/admin/add_book.jsp").forward(request, response);
        }
    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdStr = request.getParameter("bookId");
        try {
            int bookId = Integer.parseInt(bookIdStr);
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            String priceStr = request.getParameter("price");
            double price = 0.0;
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Invalid price format.");
                request.setAttribute("book", bookService.getBookById(bookId));
                request.getRequestDispatcher("/pages/admin/book_update.jsp").forward(request, response);
                return;
            }

            Part filePart = request.getPart("coverImageFile");
            String coverImageFileName = null;
            if (filePart != null && filePart.getSize() > 0) {
                String rootPath = getServletContext().getRealPath("/");
                if (imageUtil.uploadImage(filePart, rootPath, BOOK_COVER_FOLDER)) {
                    coverImageFileName = imageUtil.getImageNameFromPart(filePart);
                } else {
                    request.setAttribute("error", "Failed to upload cover image.");
                    request.setAttribute("book", bookService.getBookById(bookId));
                    request.getRequestDispatcher("/pages/admin/book_update.jsp").forward(request, response);
                    return;
                }
            } else {
                BookModel existingBook = bookService.getBookById(bookId);
                if (existingBook != null) {
                    coverImageFileName = existingBook.getCoverImage(); // Keep existing image if no new one uploaded
                }
            }

            BookModel book = new BookModel(bookId, title, author, isbn, price, coverImageFileName);
            if (bookService.updateBook(book)) {
                request.setAttribute("success", "Book updated successfully.");
                displayBookList(request, response);
            } else {
                request.setAttribute("error", "Failed to update book.");
                request.setAttribute("book", book);
                request.getRequestDispatcher("/pages/admin/book_update.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid book ID.");
            displayBookList(request, response);
        }
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdStr = request.getParameter("bookId");
        try {
            int bookId = Integer.parseInt(bookIdStr);
            if (bookService.deleteBook(bookId)) {
                request.setAttribute("success", "Book deleted successfully.");
            } else {
                request.setAttribute("error", "Failed to delete book.");
            }
            displayBookList(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid book ID.");
            displayBookList(request, response);
        }
    }
}