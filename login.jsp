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
           <form action = "#">
           <h1> Register</h1>
           <input type= "text" placeholder="Name">
           <input type = "email" placeholder="Email">
           <input type = "password" placeholder="password">
           <button> Register</button>
           <span>or use your account</span>
           <div class="social-container">
           <a href = "#" class="social"> <i class="lni lni-facebook-fill"></i></a>
           <a href= "#" class="social"> <i class="lni lni-google"></i></a>
           <a href="#" class="social"> <i class="lni lni-linkedin-original"></i></a>
           </div>
           </form>
        
        </div>
        
        <div class="form-container login-container">
            <form action="#">
            <h1> Login</h1>
             <input type="email" placeholder ="Email">
             <input type="password" placeholder="Password">
             <div class ="content">
                <div class ="checkbox">
                <input type="checkbox" name="checkbox" id="checkbox">
                <label for ="Remember me"></label>
                </div>
                <div class="pass-link">
                     <a href="#" > Forgot Password</a>
                </div>
               </div>
               <button>Login</button>
               <span>or use your account</span>
               <div class="social-container">
                <a href = "#" class="social"> <i class="lni lni-facebook-fill"></i></a>
                <a href= "#" class="social"> <i class="lni lni-google"></i></a>
                <a href="#" class="social"> <i class="lni lni-linkedin-original"></i></a>
               </div>
        
             </form>
         </div>
        
        <div class="overlay-container">
             <div class="overlay">
                 <div class ="overlay-panel overlay-left">
                     <h1 class="title">Hello<br> friends</h1>
                     <p>if you have an account, login here and feast on good books</p>
                     <button class="ghost" id="login">Login
                     <i class="lni lni-arrow-left login"></i>
                     </button>
                     
                     
                 </div>
                 
                   <div class="overlay-panel overlay-right">
                      <h1 class="title">Start your <br> journey now</h1>
                      <p> If you don't have an account yet, join us and start your reading journey.</p>
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
