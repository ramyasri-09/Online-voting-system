<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form method="post" action="LoginServlet">
        <label>Username</label>
        <input type="text" name="username" required />
        <label>Password</label>
        <input type="password" name="password" required />
        <input type="submit" value="Login" class="btn" />
    </form>
    <p>Don't have an account? <a href="register.jsp">Register here</a></p>
</div>
</body>
</html>
