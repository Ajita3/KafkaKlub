<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String loggedInUserName = (String) session.getAttribute("loggedInUserName");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>KafkaKlub Book Collection</title>
  <link rel="stylesheet" href="../css/collection.css">
  <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>

<body>
     <jsp:include page="header.jsp" />
  

   <h2 class="section-title">Explore More</h2>
  <div class="book-section">
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book11.png" alt="Book11">
      <div class="book-title">The White Nights</div>
      <div class="book-price">$11.25</div>
      <button class="add-cart-btn" onclick="addToCart('Silent Pages')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book12.png" alt="Book12">
      <div class="book-title">The waves</div>
      <div class="book-price">$13.40</div>
      <button class="add-cart-btn" onclick="addToCart('Stories Untold')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book13.png" alt="Book13">
      <div class="book-title">The Bell Jar</div>
      <div class="book-price">$10.99</div>
      <button class="add-cart-btn" onclick="addToCart('Beyond the Line')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book14.png" alt="Book14">
      <div class="book-title">The Stranger</div>
      <div class="book-price">$15.25</div>
      <button class="add-cart-btn" onclick="addToCart('Fragments of Light')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book15.png" alt="Book15">
      <div class="book-title">Normal People</div>
      <div class="book-price">$13.00</div>
      <button class="add-cart-btn" onclick="addToCart('Unwritten Dreams')">Add to Cart</button>
    </div>
  </div>

  <h2 class="section-title">New Arrivals</h2>
  <div class="book-section">
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book1.png" alt="Book1">
      <div class="book-title">The Space Between Us</div>
      <div class="book-price">$15.99</div>
      <button class="add-cart-btn" onclick="addToCart('The New Dawn')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book2.png" alt="Book2">
      <div class="book-title">The Stationery Shop Of Tehran</div>
      <div class="book-price">$12.50</div>
      <button class="add-cart-btn" onclick="addToCart('Whispers of Time')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book3.png" alt="Book3">
      <div class="book-title">A Thousand Splendid Suns</div>
      <div class="book-price">$13.99</div>
      <button class="add-cart-btn" onclick="addToCart('Into the Shadows')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book4.png" alt="Book4">
      <div class="book-title">Just Kids</div>
      <div class="book-price">$16.20</div>
      <button class="add-cart-btn" onclick="addToCart('Beneath the Sky')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book5.png" alt="Book5">
      <div class="book-title">The MetaMorphosis</div>
      <div class="book-price">$14.60</div>
      <button class="add-cart-btn" onclick="addToCart('Light in August')">Add to Cart</button>
    </div>
  </div>

  <h2 class="section-title">Best Sellers</h2>
  <div class="book-section">
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book6.png" alt="Book6">
      <div class="book-title">Palace of Illusion</div>
      <div class="book-price">$18.00</div>
      <button class="add-cart-btn" onclick="addToCart('Kafka’s Legacy')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book7.png" alt="Book7">
      <div class="book-title">The Forest Of Enchantments</div>
      <div class="book-price">$14.75</div>
      <button class="add-cart-btn" onclick="addToCart('Parallel Worlds')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book8.png" alt="Book8">
      <div class="book-title">Kafka On The Shore</div>
      <div class="book-price">$17.10</div>
      <button class="add-cart-btn" onclick="addToCart('Eternal Echoes')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book9.png" alt="Book9">
      <div class="book-title">Letters To Milena</div>
      <div class="book-price">$16.85</div>
      <button class="add-cart-btn" onclick="addToCart('Celestial Tides')">Add to Cart</button>
    </div>
    <div class="book-card">
      <img src="${pageContext.request.contextPath}/resources/image/system/Book10.png" alt="Book10">
      <div class="book-title">Crime and Punishment</div>
      <div class="book-price">$13.45</div>
      <button class="add-cart-btn" onclick="addToCart('The Last Archive')">Add to Cart</button>
    </div>
  </div>


  <script>
    function addToCart(bookTitle) {
      alert(`"${bookTitle}" has been added to your cart!`);
    }
  </script>
<jsp:include page="footer.jsp" />
</body>
</html>