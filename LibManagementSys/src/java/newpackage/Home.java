package newpackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String username = "azmi";
        String password = "Aza@#11221";
        String query = "SELECT * FROM login_info";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(query);

            rs.next();
            String s = (String)rs.getString("email");
            String p = (String)rs.getString("password");
            if (user.equals(s) && pass.equals(p)) {
                out.println("You are logged in");
                out.println("<a href =books>" + "Name of book" + "</a>");
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");
            out.println("<style>");
            out.println("ul { list-style-type: none; padding: 0; }");
            out.println("li { margin-bottom: 10px; }");
            out.println(".book-title { font-weight: bold; }");
            out.println(".book-author { font-style: italic; }");
            out.println("</style>");
            out.println("</head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>List of Books</h2>");
            out.println("<ul>");
            out.println("<li><span class=\"book-title\">Book 1:</span> <span class=\"book-author\"><a href = issue >Author 1 </a></span></li>");
            out.println("<li><span class=\"book-title\">Book 2:</span> <span class=\"book-author\">Author 2</span></li>");
            out.println("<li><span class=\"book-title\">Book 3:</span> <span class=\"book-author\">Author 3</span></li>");
            // Add more list items for each book
            out.println("</ul>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("LastName", pass);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
