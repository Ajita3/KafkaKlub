<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> Login/Registration Form</title>
<link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="../css/login.css" />
</head>
<body>
<div class = "container" id="container">
        <div class ="form-container register-container">
           <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
  <h1>Register</h1>
  <input type="text" name="name" placeholder="Name" required>
  <input type="email" name="email" placeholder="Email" required>
  <input type="password" name="password" placeholder="Password" required>

  <div class="content">
    <div class="checkbox">
      <input type="checkbox" id="register-checkbox" required>
      <label for="register-checkbox">I agree to the terms</label>
    </div>
  </div>

  <button type="submit">Register</button>
  <span>or use your email for registration</span>

  <div class="social-container">
    <a href="#" class="social"><i class="lni lni-facebook-fill"></i></a>
    <a href="#" class="social"><i class="lni lni-google"></i></a>
    <a href="#" class="social"><i class="lni lni-linkedin-original"></i></a>
  </div>
</form>
           
        
        </div>
        
        <div class="form-container login-container">
           <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
  <h1>Login</h1>
  <input type="email" name="email" placeholder="Email" required>
  <input type="password" name="password" placeholder="Password" required>

  <div class="content">
    <div class="checkbox">
      <input type="checkbox" id="login-checkbox">
      <label for="login-checkbox">Remember me</label>
    </div>
    <div class="pass-link">
      <a href="#">Forgot Password</a>
    </div>
  </div>

  <button type="submit">Login</button>
  <span>or use your account</span>

  <div class="social-container">
    <a href="#" class="social"><i class="lni lni-facebook-fill"></i></a>
    <a href="#" class="social"><i class="lni lni-google"></i></a>
    <a href="#" class="social"><i class="lni lni-linkedin-original"></i></a>
  </div>
</form>
            
         </div>
        
        <div class="overlay-container">
             <div class="overlay">
                 <div class ="overlay-panel overlay-left">
                     <h1 class="title">Welcome Back<br>Friends!</h1>
                     <p>If you already have an account, log in to explore a world of great reads.</p>
                     <button class="ghost" id="login">Login
                     <i class="lni lni-arrow-left login"></i>
                     </button>
                     
                     
                 </div>
                 
                   <div class="overlay-panel overlay-right">
                      <h1 class="title">Begin your <br> reading journey</h1>
                      <p> If you're new here, sign up and embark on a journey through stories that inspire.</p>
                      <button class="ghost" id="register">Register
                        <i class="lni lni-arrow-right register"></i>
                        
                      </button>
                      
                   </div>
                 
               </div>
          </div>
</div>

<script>

const registerButton = document.getElementById("register");
const loginButton = document.getElementById("login");
const container = document.getElementById("container");

registerButton.addEventListener("click", () => {
  container.classList.add("right-panel-active");
});

loginButton.addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});
</script>


</body>
</html>
