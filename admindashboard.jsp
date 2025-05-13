<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Dashboard - BookStore</title>
  <link rel="stylesheet" href="admin-dashboard.css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<header>📚 KafkaKlub Admin Dashboard</header>

<div class="dashboard">

  <!-- Monthly Sales Chart -->
  <div class="card">
    <h2>📈 Monthly Sales Overview</h2>
    <canvas id="salesChart" class="chart-container"></canvas>
  </div>

  <!-- Most Sold Books -->
  <div class="card">
    <h2>🔥 Most Sold Books</h2>
    <ul class="book-list" id="mostSoldList">
      <!-- Filled by JavaScript -->
    </ul>
  </div>

  <!-- Most Expensive Books -->
  <div class="card">
    <h2>💰 Most Expensive Books</h2>
    <ul class="book-list" id="mostExpensiveList">
      <!-- Filled by JavaScript -->
    </ul>
  </div>

</div>

<script>
  // Chart Data
  const salesData = {
    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun"],
    datasets: [{
      label: "Sales",
      data: [240, 350, 300, 400, 320, 450],
      borderColor: "#14b8a6",
      backgroundColor: "rgba(20, 184, 166, 0.1)",
      tension: 0.3,
      fill: true
    }]
  };

  new Chart(document.getElementById("salesChart"), {
    type: 'line',
    data: salesData,
    options: {
      responsive: true,
      plugins: {
        legend: { display: false },
        tooltip: { mode: 'index', intersect: false }
      },
      scales: {
        y: { beginAtZero: true }
      }
    }
  });

  // Book Data
  const mostSoldBooks = [
    { title: "Kafka's Metamorphosis", sold: 1200 },
    { title: "1984", sold: 980 },
    { title: "To Kill a Mockingbird", sold: 870 }
  ];

  const mostExpensiveBooks = [
    { title: "First Edition Kafka", price: "$129.99" },
    { title: "Rare Ulysses Copy", price: "$99.95" },
    { title: "Signed Tolkien Trilogy", price: "$89.50" }
  ];

  // Populate Most Sold Books
  const soldList = document.getElementById("mostSoldList");
  mostSoldBooks.forEach(book => {
    const li = document.createElement("li");
    li.innerHTML = `<span class="book-title">${book.title}</span><span class="book-value">${book.sold} sold</span>`;
    soldList.appendChild(li);
  });

  // Populate Most Expensive Books
  const expensiveList = document.getElementById("mostExpensiveList");
  mostExpensiveBooks.forEach(book => {
    const li = document.createElement("li");
    li.innerHTML = `<span class="book-title">${book.title}</span><span class="book-value">${book.price}</span>`;
    expensiveList.appendChild(li);
  });
</script>

</body>
</html>
