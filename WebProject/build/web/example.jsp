<%-- 
    Document   : example.jsp
    Created on : May 29, 2023, 4:26:58 PM
    Author     : azmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%--
            String name = (String) request.getAttribute("name");
            out.println(name);
        --%>
        
        ${name}
        <c:out value="Hello World ${name}" />
    </body>
</html>
