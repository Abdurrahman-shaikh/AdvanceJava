package mypkg;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "FriendDetailsServlet", urlPatterns = {"/FriendServlet"})
public class FriendDetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String friendId = request.getParameter("id");
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
                String username = "azmi";
                String password = "Aza@#11221";
                Connection con = DriverManager.getConnection(url, username, password);
                String query = "SELECT id, name, city, country FROM friends WHERE id = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, friendId);
                ResultSet rs = stmt.executeQuery();

                rs.next();
                    String friendName = rs.getString("name");
                    String friendCity = rs.getString("city");
                    String friendCountry = rs.getString("country");
                    out.println("<h1>Friend Details</h1>");
                    out.println("<p>ID: " + friendId + "</p>");
                    out.println("<p>Name: " + friendName + "</p>");
                    out.println("<p>City: " + friendCity + "</p>");
                    out.println("<p>Country: " + friendCountry + "</p>");

                con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
