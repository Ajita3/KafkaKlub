<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Portal</title>
    <link rel="stylesheet" href="styles.css">
      <link rel="stylesheet" type="text/css" href="../css/userprofile.css" />
</head>
<body>

    <div class="container">
        <!-- User Profile Section -->
        <div class="profile-section">
            <h2>User Profile</h2>
            <div class="profile-info">
                <div class="profile-item">
                    <label for="username">Username:</label>
                    <span id="username">AjitaP</span>
                </div>
                <div class="profile-item">
                    <label for="email">Email:</label>
                    <span id="email">ajitap@example.com</span>
                </div>
                <div class="profile-item">
                    <label for="contact">Contact:</label>
                    <span id="contact">+1234567890</span>
                </div>
                <div class="profile-item">
                    <label for="password">Password:</label>
                    <span id="password">********</span>
                    <button onclick="editPassword()">Change Password</button>
                </div>
            </div>
            <button onclick="editProfile()">Edit Profile</button>
        </div>

        <!-- Search Section -->
        <div class="search-section">
            <h3>Search</h3>
            <input type="text" id="searchInput" placeholder="Search for books or authors..." onkeyup="search()">
            <div id="searchResults"></div>
        </div>

        <!-- Real-Time Data Section -->
        <div class="realtime-section">
            <h3>Real-Time Data</h3>
            <div id="realTimeData">Loading...</div>
        </div>
    </div>

    <script src> // Simulating real-time data update
    function updateRealTimeData() {
        const realTimeData = document.getElementById('realTimeData');
        realTimeData.textContent = new Date().toLocaleTimeString();
    }
    setInterval(updateRealTimeData, 1000);

    // Search functionality (dummy data)
    const books = [
        'The Great Gatsby',
        'Harry Porter',
        'Anna Karenina',
        'Pride and Prejudice',
        'Emma',
    ];

    const authors = [
        'F. Scott Fitzgerald',
        'Herman Melville',
        'Leo Tolstoy',
        'Jane Austen',
        'George Orwell',
    ];

    // Search function to filter books and authors
    function search() {
        const query = document.getElementById('searchInput').value.toLowerCase();
        const results = [];

        if (query) {
            results.push(...books.filter(book => book.toLowerCase().includes(query)));
            results.push(...authors.filter(author => author.toLowerCase().includes(query)));
        }

        displaySearchResults(results);
    }

    // Display search results
    function displaySearchResults(results) {
        const searchResultsDiv = document.getElementById('searchResults');
        searchResultsDiv.innerHTML = results.length > 0 ? results.join('<br>') : 'No results found';
    }

    // Edit profile functionality (Dummy)
    function editProfile() {
        alert("Profile editing feature coming soon.");
    }

    // Change password functionality (Dummy)
    function editPassword() {
        alert("Password change feature coming soon.");
    }

    </script>
</body>
</html>
    