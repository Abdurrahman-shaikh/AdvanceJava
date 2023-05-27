<%-- 
    Document   : A
    Created on : May 25, 2023, 11:40:03 AM
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
        <%!
            int x = 1;
        %>
        
        <%
            String st = "Integral University";
            out.println(st);
            out.println(x);
            x++;
        %>
        <%
          int age = 21;  
        %>
        <br>
        <%= 
           age  
        %>
    </body>
</html>
