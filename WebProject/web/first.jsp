<%-- 
    Document   : first
    Created on : May 26, 2023, 10:57:00 AM
    Author     : azmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        response.sendRedirect("second.jsp");
        %>
        <h1>Hello World!</h1>
    </body>
</html>
