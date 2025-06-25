package com.voting;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingdb", "root", "Ramya@1431");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
