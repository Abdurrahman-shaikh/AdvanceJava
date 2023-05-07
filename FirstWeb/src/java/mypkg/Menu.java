package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<div class='menu'>");
            out.println("<ul>");
            out.println("<li><a href='#'>Home</a></li>");
            out.println("<li><a href='#'>About Us</a></li>");
            out.println("<li><a href='#'>Contact Us</a></li>");
            out.println("</ul>");
            out.println("</div>");

            // Add some content below the menu bar
            out.println("<div class='content'>");
            out.println("<h1>Welcome to my website!</h1>");
            out.println("<p>This is some example content.</p>");
            out.println("</div>");
            
            String page = request.getParameter("page");
        if (page == null) {
            response.sendRedirect("home.html");
        } else if (page.equals("aboutus")) {
            response.sendRedirect("aboutus.html");
        } else if (page.equals("contact")) {
            response.sendRedirect("contact.html");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

            
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
