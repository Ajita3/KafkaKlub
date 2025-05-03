<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
   
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("../login.jsp"); // Adjust path if needed
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>KafkaKlub - Home</title>
    <link rel="stylesheet" type="text/css" href="../css/home.css" />
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
       <img src="${pageContext.request.contextPath}/resources/image/system/BookHome.jpg" class="hero-img">
       
    </section>

    <section id="about" class="about-section">
        <h2>Why KafkaKlub?</h2>
        <p>
            At KafkaKlub, we go beyond just selling books — we offer a personalized reading experience. 
            With carefully curated collections, support for independent authors, and a passion for every genre,
            we’re not just another bookstore — we’re your reading companion.
        </p>
    </section>

    <script src="script.js"></script>
</body>
</html>
    