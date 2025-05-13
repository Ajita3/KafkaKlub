<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>KafkaKlub - Home</title>
    <link rel="stylesheet" type="text/css" href="../css/home.css" />
    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <header>
        <div class="logo">📚 KafkaKlub</div>
        <nav>
            <ul>
                <li><a href="#collection">Collection</a></li>
                <li><a href="#about">About Us</a></li>
                <li><a href="#contact">Contact Us</a></li>
                <li><a href="#profile">Manage Profile</a></li>
            </ul>
        </nav>
    </header>

    <section class="hero">
        <div class="hero-text">
            <h1>Welcome to KafkaKlub!!!</h1>
            <p>Your one-stop destination for all genres — discover stories that speak to you.</p>
        </div>
    </section>

    <!-- Static Genre Images -->
    <section class="genre-banner">
        <div class="genre-images">
            <img src="${pageContext.request.contextPath}/resources/image/system/KidsBook.png" alt="Kids">
            <img src="${pageContext.request.contextPath}/resources/image/system/Fiction.png" alt="Fiction">
            <img src="${pageContext.request.contextPath}/resources/image/system/Non-fiction.png" alt="Non-Fiction">
        </div>
    </section>

    <!-- Genre Grid Section -->
    <section class="genre-grid-section">
        <h2>Explore by Genre</h2>
        <div class="genre-grid">
            <div class="genre-card"><i class="fas fa-user-ninja"></i><p>Thriller</p></div>
            <div class="genre-card"><i class="fas fa-masks-theater"></i><p>Drama</p></div>
            <div class="genre-card"><i class="fas fa-feather-alt"></i><p>Poetry</p></div>
            <div class="genre-card"><i class="fas fa-robot"></i><p>Sci-Fi</p></div>
            <div class="genre-card"><i class="fas fa-laugh-squint"></i><p>Comedy</p></div>
            <div class="genre-card"><i class="fas fa-user-secret"></i><p>Crime</p></div>
            <div class="genre-card"><i class="fas fa-ghost"></i><p>Horror</p></div>
            <div class="genre-card"><i class="fas fa-hat-wizard"></i><p>Fantasy</p></div>
            <div class="genre-card"><i class="fas fa-baby"></i><p>Kids</p></div>
        </div>
    </section>

    <!-- Books on Sale Section -->
    <section class="sale-section">
        <h2 class="sale-heading">Books on Sale</h2>
        <div class="book-grid">
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book6.png">
                <h4>Palace Of Illusion</h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book7.png">
                <h4>The Forest Of Enchantments </h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book8.png">
                <h4>Kafka On The Shore</h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book9.png">
                <h4>Letters To Milena</h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book10.png">
                <h4>Crime and Punishment</h4>
            </div>
        </div>
    </section>

    <!-- Recommended for You Section -->
    <section class="recommended-section">
        <h2>Recommended for You</h2>
        <div class="book-grid">
            <div class="book-card">
                 <img src="${pageContext.request.contextPath}/resources/image/system/Book1.png">
                <h4>The Space Between Us</h4>
            </div>
            <div class="book-card">
               <img src="${pageContext.request.contextPath}/resources/image/system/Book2.png">
                <h4>The Stationery Shop Of Tehran</h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book3.png">
                <h4>A Thousand Splendid Suns</h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book4.png">
                <h4>Just Kids</h4>
            </div>
            <div class="book-card">
                <img src="${pageContext.request.contextPath}/resources/image/system/Book5.png">
                <h4>The Metamorphosis</h4>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer>
        <div class="footer-container">
            <div class="footer-section">
                <h4>Follow Us</h4>
                <div class="social-icons">
                    <a href="#"><i class="fab fa-facebook-square"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                </div>
            </div>

            <div class="footer-section">
                <h4>Book Categories</h4>
                <ul>
                    <li><a href="#">Thriller</a></li>
                    <li><a href="#">Drama</a></li>
                    <li><a href="#">Poetry</a></li>
                    <li><a href="#">Sci-Fi</a></li>
                    <li><a href="#">Comedy</a></li>
                    <li><a href="#">Crime</a></li>
                    <li><a href="#">Horror</a></li>
                </ul>
            </div>

            <div class="footer-section">
                <h4>Quick Links</h4>
                <ul>
                    <li><a href="#">Cart</a></li>
                    <li><a href="#">Checkout</a></li>
                    <li><a href="#">Sign Up</a></li>
                    <li><a href="#">Login</a></li>
                    <li><a href="#">Collection</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div>

            <div class="footer-section">
                <h4>Contact</h4>
                <p>📍 Manhattan, New York</p>
                <p>📞 +91-9876543210</p>
                <p>📧 KafkaKlub@gmail.com</p>
                <iframe src="https://maps.google.com/maps?q=Manhattan,%20New%20York%20City&t=&z=13&ie=UTF8&iwloc=&output=embed" 
                        width="100%" height="250" allowfullscreen="" loading="lazy">
                </iframe>
            </div>
        </div>
    </footer>
</body>
</html>
