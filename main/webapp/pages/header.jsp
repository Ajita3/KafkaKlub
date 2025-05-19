<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String loggedInUserName = (String) session.getAttribute("loggedInUserName");
    String userRole = (String) session.getAttribute("userRole"); // Assuming you store user role in session
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header.css" />
    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <header id="main-header">
        <div class="logo">📚 KafkaKlub</div>
        <nav>
            <ul>
                <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/collection">Collection</a></li>
                <li><a href="<%=request.getContextPath()%>/about">About Us</a></li>
                <li><a href="<%=request.getContextPath()%>/contact">Contact Us</a></li>
                <% if (loggedInUserName != null) { %>
                    <% if ("admin".equals(userRole)) { %>
                        <li><a href="<%=request.getContextPath()%>/admin/dashboard">Admin Dashboard</a></li>
                    <% } else { %>
                        <li><a href="<%=request.getContextPath()%>/profile">Manage Profile</a></li>
                    <% } %>
                    <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
                <% } else { %>
                    <li><a href="<%=request.getContextPath()%>/login">Login</a></li>
                    <li><a href="<%=request.getContextPath()%>/signup">Sign Up</a></li>
                <% } %>
            </ul>
        </nav>
    </header>
</body>
</html>