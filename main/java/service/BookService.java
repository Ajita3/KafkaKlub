package service;

import model.BookModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.DbConfig;

public class BookService {

    private Connection dbConn;

    public BookService() {
        try {
			dbConn = DbConfig.getDbConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Use a static getConnection method for simplicity
    }

    public List<BookModel> getAllBooks() {
        List<BookModel> books = new ArrayList<>();
        String query = "SELECT book_id, title, author, isbn, price, cover_image FROM books";
        try (PreparedStatement stmt = dbConn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                books.add(new BookModel(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("isbn"), rs.getDouble("price"), rs.getString("cover_image")));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all books: " + e.getMessage());
        }
        return books;
    }

    public BookModel getBookById(int id) {
        String query = "SELECT book_id, title, author, isbn, price, cover_image FROM books WHERE book_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new BookModel(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("isbn"), rs.getDouble("price"), rs.getString("cover_image"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching book by ID: " + e.getMessage());
        }
        return null;
    }

    public boolean addBook(BookModel book) {
        String query = "INSERT INTO books (title, author, isbn, price, cover_image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getIsbn());
            stmt.setDouble(4, book.getPrice());
            stmt.setString(5, book.getCoverImage());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
        return false;
    }

    public boolean updateBook(BookModel book) {
        String query = "UPDATE books SET title = ?, author = ?, isbn = ?, price = ?, cover_image = ? WHERE book_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getIsbn());
            stmt.setDouble(4, book.getPrice());
            stmt.setString(5, book.getCoverImage());
            stmt.setInt(6, book.getBookId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteBook(int id) {
        String query = "DELETE FROM books WHERE book_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
        return false;
    }

    public int getTotalBooks() {
        String query = "SELECT COUNT(*) FROM books";
        try (PreparedStatement stmt = dbConn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error getting total books: " + e.getMessage());
        }
        return 0;
    }
}