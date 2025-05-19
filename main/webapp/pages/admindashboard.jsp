<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
     <link rel="stylesheet" href="../css/admindashboard.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admindashboard.css">
</head>
<body>
    <div class="admin-container">
        <div class="sidebar">
            <h2>Admin Panel</h2>
            <ul>
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Manage Users</a></li>
                <li><a href="#">Manage Orders</a></li>
                <li><a href="#" class="active">Manage Books</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
            </ul>
        </div>
        <div class="main-content">
            <div class="dashboard-header">
                <h1>Book Management</h1>
                <a href="#" class="add-book-button" onclick="openAddBookModal()">Add New Book</a>
            </div>

            <div class="card-grid">
                <div class="card">
                    <h3>Total Books</h3>
                    <p class="card-value">150</p>
                </div>
                <div class="card">
                    <h3>Active Books</h3>
                    <p class="card-value">120</p>
                </div>
                <div class="card">
                    <h3>Out of Stock</h3>
                    <p class="card-value">30</p>
                </div>
            </div>

            <div class="book-list-section">
                <h2>List of Books</h2>
                <table class="book-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>ISBN</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody id="bookTableBody">
                        <tr>
                            <td>1</td>
                            <td>The Great Gatsby</td>
                            <td>F. Scott Fitzgerald</td>
                            <td>978-0743273565</td>
                            <td>$10.99</td>
                            <td class="action-buttons">
                                <a href="#" class="view" onclick="viewBook(1)">View</a>
                                <a href="#" class="edit" onclick="openEditBookModal(1)">Edit</a>
                                <button class="delete" onclick="deleteBook(1)">Delete</button>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>To Kill a Mockingbird</td>
                            <td>Harper Lee</td>
                            <td>978-0061120084</td>
                            <td>$12.50</td>
                            <td class="action-buttons">
                                <a href="#" class="view" onclick="viewBook(2)">View</a>
                                <a href="#" class="edit" onclick="openEditBookModal(2)">Edit</a>
                                <button class="delete" onclick="deleteBook(2)">Delete</button>
                            </td>
                        </tr>
                        </tbody>
                </table>
            </div>

            <div id="addBookModal" class="modal">
                <div class="modal-content">
                    <span class="close-button" onclick="closeAddBookModal()">&times;</span>
                    <h3>Add New Book</h3>
                    <form id="addBookForm">
                        <label for="addTitle">Title:</label>
                        <input type="text" id="addTitle" name="title" required><br><br>
                        <label for="addAuthor">Author:</label>
                        <input type="text" id="addAuthor" name="author" required><br><br>
                        <label for="addISBN">ISBN:</label>
                        <input type="text" id="addISBN" name="isbn" required><br><br>
                        <label for="addPrice">Price:</label>
                        <input type="number" id="addPrice" name="price" step="0.01" required><br><br>
                        <button type="submit" class="button">Add Book</button>
                    </form>
                </div>
            </div>

            <div id="editBookModal" class="modal">
                <div class="modal-content">
                    <span class="close-button" onclick="closeEditBookModal()">&times;</span>
                    <h3>Edit Book</h3>
                    <form id="editBookForm">
                        <input type="hidden" id="editBookId" name="bookId">
                        <label for="editTitle">Title:</label>
                        <input type="text" id="editTitle" name="title" required><br><br>
                        <label for="editAuthor">Author:</label>
                        <input type="text" id="editAuthor" name="author" required><br><br>
                        <label for="editISBN">ISBN:</label>
                        <input type="text" id="editISBN" name="isbn" required><br><br>
                        <label for="editPrice">Price:</label>
                        <input type="number" id="editPrice" name="price" step="0.01" required><br><br>
                        <button type="submit" class="button">Save Changes</button>
                    </form>
                </div>
            </div>

            <script>
                // Add Book Modal
                const addBookModal = document.getElementById('addBookModal');
                const addBookForm = document.getElementById('addBookForm');

                function openAddBookModal() {
                    addBookModal.style.display = 'block';
                }

                function closeAddBookModal() {
                    addBookModal.style.display = 'none';
                    addBookForm.reset();
                }

                addBookForm.addEventListener('submit', function(event) {
                    event.preventDefault();
                    // In a real application, you would send this data to the backend
                    console.log('Adding book:', {
                        title: document.getElementById('addTitle').value,
                        author: document.getElementById('addAuthor').value,
                        isbn: document.getElementById('addISBN').value,
                        price: document.getElementById('addPrice').value
                    });
                    closeAddBookModal();
                    // Optionally, update the UI with the new "book"
                });

                // Edit Book Modal
                const editBookModal = document.getElementById('editBookModal');
                const editBookForm = document.getElementById('editBookForm');

                function openEditBookModal(bookId) {
                    // In a real application, you would fetch book data based on the ID
                    document.getElementById('editBookId').value = bookId;
                    document.getElementById('editTitle').value = 'Sample Book Title ' + bookId;
                    document.getElementById('editAuthor').value = 'Sample Author';
                    document.getElementById('editISBN').value = 'SAMPLE-ISBN-' + bookId;
                    document.getElementById('editPrice').value = 15.99;
                    editBookModal.style.display = 'block';
                }

                function closeEditBookModal() {
                    editBookModal.style.display = 'none';
                    editBookForm.reset();
                }

                editBookForm.addEventListener('submit', function(event) {
                    event.preventDefault();
                    const bookId = document.getElementById('editBookId').value;
                    // In a real application, you would send the updated data to the backend
                    console.log('Editing book ID:', bookId, {
                        title: document.getElementById('editTitle').value,
                        author: document.getElementById('editAuthor').value,
                        isbn: document.getElementById('editISBN').value,
                        price: document.getElementById('editPrice').value
                    });
                    closeEditBookModal();
                    // Optionally, update the UI with the changed data
                });

                function viewBook(bookId) {
                    console.log('Viewing book ID:', bookId);
                    // In a real application, you would navigate to a detailed view page
                }

                function deleteBook(bookId) {
                    console.log('Deleting book ID:', bookId);
                    // In a real application, you would send a delete request to the backend
                    // and then update the UI
                }

                // In a real application, you would likely fetch the initial book data
                // using JavaScript (e.g., using fetch API) and populate the table dynamically.
            </script>
        </div>
    </div>
</body>
</html>