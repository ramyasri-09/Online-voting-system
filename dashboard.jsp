<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String user = (session != null) ? (String) session.getAttribute("username") : null;
%>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
<% if (user != null) { %>
    <h2>Welcome, <%= user %>!</h2>
    <form method="post" action="VoteServlet">
        <label>Choose your candidate:</label><br>
        <input type="radio" name="candidate" value="Candidate A" required /> Candidate A<br>
        <input type="radio" name="candidate" value="Candidate B" /> Candidate B<br>
        <input type="submit" value="Vote" class="btn" />
    </form>
    <br>
    <a href="result.jsp" class="btn">View Results</a>
<% } else { %>
    <p>You are not logged in. <a href="login.jsp">Login</a></p>
<% } %>
</div>
</body>
</html>
