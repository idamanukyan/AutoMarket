<%@ page import="com.example.auto_am.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Login</title>
    <link href="css/loginStyle.css" rel="stylesheet">
</head>

<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        response.sendRedirect("/home");
    }
    String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>


<h2>Welcome to the Garage Company's Official Website</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="/register" method="post" role="form">
            <h1>Create Account</h1>
            <div class="social-container">
                <img src="css/icons/fb_icon.jpg">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <img src="css/icons/g+_icon.png">
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <img src="css/icons/linkedin_icon.png">
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your email for registration</span>
            <input type="text" name="name" id="name" placeholder="Name"/>
            <input type="text" name="surname" id="surname" placeholder="Surname"/>
            <input type="email" name="email" id="email" placeholder="Email"/>
            <input type="password" name="password" id="password" placeholder="Password"/>
            <input type="password" name="re-password" id="re-password" placeholder="Re-password"/>
            <button>Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="/login" method="post" role="form">
            <h1>Sign in</h1>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <span>or use your account</span>
            <input type="email" name="email" id="username" placeholder="Email"/>
            <input type="password" name="password" id="password" placeholder="Password"/>

            <button>Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>


<script>
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
</script>

