<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Contact Us - KafkaKlub</title>
  <link rel="stylesheet" href="contact.css"/>
  <link rel="stylesheet" type="text/css" href="../css/contactus.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"/>
</head>
<body>
  <!-- Logo -->
  <div class="logo-top-right">📚 KafkaKlub</div>

  <!-- Title -->
  <h1 class="main-title">CONTACT US</h1>

  <!-- Main Content Container -->
  <div class="contact-wrapper">
    <!-- Left Form -->
    <div class="form-container">
      <form class="contact-form">
        <label for="name">Full Name</label>
        <input type="text" id="name" placeholder="Your Name" required/>

        <label for="email">Email</label>
        <input type="email" id="email" placeholder="Your Email" required/>

        <label for="feedback">Feedback</label>
        <textarea id="feedback" placeholder="Your Feedback" required></textarea>

        <button type="submit">Submit</button>
      </form>
    </div>

    <!-- Right Info -->
    <div class="info-container">
      <p><i class="fas fa-envelope"></i> kafkaklub@gmail.com</p>
      <p><i class="fas fa-phone-alt"></i> +91-9876543210</p>

      <p class="follow-label">Follow us at:</p>
      <div class="social-links">
        <a href="#"><i class="fab fa-facebook-square"></i> Facebook</a>
        <a href="#"><i class="fab fa-instagram"></i> Instagram</a>
      </div>

      <p><i class="fas fa-map-marker-alt"></i> We are located at: Manhattan, New York</p>
    </div>
  </div>

  <p class="footer-text">Thank you for visiting us. We appreciate you!</p>
</body>
</html>
