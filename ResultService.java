package com.voting;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Results</title></head><body>");
        out.println("<h2>Voting Results</h2>");
        out.println("<table border='1'><tr><th>Candidate</th><th>Votes</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingdb", "root", "Ramya@1431");

            PreparedStatement ps = conn.prepareStatement("SELECT candidate, COUNT(*) AS votes FROM votes GROUP BY candidate");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("candidate") + "</td><td>" + rs.getInt("votes") + "</td></tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</table></body></html>");
    }
}
