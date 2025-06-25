package com.voting;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String candidate = request.getParameter("candidate");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingdb", "root", "Ramya@1431");

            // Check if already voted
            PreparedStatement check = conn.prepareStatement("SELECT * FROM votes WHERE username=?");
            check.setString(1, username);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                response.getWriter().println("You have already voted!");
            } else {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO votes(username, candidate) VALUES(?, ?)");
                ps.setString(1, username);
                ps.setString(2, candidate);
                ps.executeUpdate();

                response.sendRedirect("result.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
