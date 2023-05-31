<%-- 
    Document   : dis
    Created on : May 29, 2023, 3:57:12 PM
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
            String name = (String)request.getAttribute("name");
            out.println(name);
        %>
    </body>
</html>
