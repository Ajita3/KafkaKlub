<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>About Us - KafkaKlub</title>
  <link rel="stylesheet" href="aboutus.css" />
   <link rel="stylesheet" type="text/css" href="../css/aboutus.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

  <div class="container">
    <!-- Left Side Image -->
    <div class="left-pane">
      <img src="${pageContext.request.contextPath}/resources/image/system/BookHomeThree.jpg" alt="BooHomeThree" >
    </div>

    <!-- Right Side Content -->
    <div class="right-pane">
      <div class="header-logo">
        <div class="logo-text">📚 KafkaKlub</div>
      </div>

      <h1 class="main-heading">About Us</h1>

      <div class="section">
        <h2>Our Mission</h2>
        <p>
          KafkaKlub’s mission is to cultivate a love for reading by offering hand-picked selections for all ages and
          interests. We strive to make books easily accessible while fostering a vibrant literary community.
        </p>
      </div>

      <div class="section">
        <h2>Our Story</h2>
        <p>
          Founded in 2020 by book lovers and tech innovators, KafkaKlub has evolved from a humble bookstore into a
          leading digital book hub. With dedication and passion, we’ve brought together thousands of readers globally.
        </p>
      </div>

      <div class="stats">
        <div class="stat-item"><i class="fas fa-book"></i> 30,000+ Books Sold</div>
        <div class="stat-item"><i class="fas fa-users"></i> 8,000+ Customers</div>
        <div class="stat-item"><i class="fas fa-briefcase"></i> 200+ Workforce</div>
      </div>
    </div>
  </div>

</body>
</html>
