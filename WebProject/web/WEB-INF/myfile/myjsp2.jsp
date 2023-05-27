<%-- 
    Document   : myjsp2
    Created on : May 27, 2023, 11:25:04 AM
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
        <h1>Hello World!</h1>
        <% 
            out.println(request.getAttribute("college"));
        %>
        <% 
            out.println(session.getAttribute("city"));
        %>
        <% 
            out.println(config.getInitParameter("city1"));
        %>
        <% 
            out.println(application.getInitParameter("country1"));
        %>
    </body>
</html>
