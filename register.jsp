<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form method="post" action="RegisterServlet">
        <label>Username</label>
        <input type="text" name="username" required />
        <label>Password</label>
        <input type="password" name="password" required />
        <input type="submit" value="Register" class="btn" />
    </form>
    <p>Already registered? <a href="login.jsp">Login here</a></p>
</div>
</body>
</html>
