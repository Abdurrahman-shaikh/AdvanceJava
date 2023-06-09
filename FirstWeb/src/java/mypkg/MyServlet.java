package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<form action='/FirstWeb/S1' method='GET'>");
            out.println("<input type='text' name = 'fname' placeholder = 'First Name'/>");
            out.println("<input type='text' name = 'lname' placeholder = 'Last Name'/>");
            out.println("<input type='submit' value='Send'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            response.sendRedirect("/FirstWeb/S2");
            String name = request.getParameter("fname");
            String lastname = request.getParameter("lname");
            out.println("Hi " + name + " " + lastname);
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
