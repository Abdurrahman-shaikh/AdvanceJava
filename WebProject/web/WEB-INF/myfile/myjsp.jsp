<%-- 
    Document   : myjsp
    Created on : May 27, 2023, 11:17:34 AM
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
    request.setAttribute("college","IUL");
    RequestDispatcher dispatcher = request.getRequestDispatcher("mp2");
    dispatcher.forward(request,response);
        %>
        <%
    session.setAttribute("city","Awadh");
        %>
        
    </body>
</html>
