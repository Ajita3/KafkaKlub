<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Footer</title>
    <link rel="stylesheet" type="text/css" href="../css/footer.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
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
                    <li><a href="<%=request.getContextPath()%>/pages/signup.jsp">Sign Up</a></li>
                    <li><a href="<%=request.getContextPath()%>/pages/login.jsp">Login</a></li>
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