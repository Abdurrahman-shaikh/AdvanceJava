<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%@page errorPage="errorHandling.jsp" %>
        <%@page session="true" %>
        <%@include file="A.jspf" %>
        <%@include file="B.jspf" %>
        <%@include file="C.jspf" %>
        <% out.println(getServletConfig().getServletName()); %>
        <br>
        <% 
            ArrayList<String> al = new ArrayList<>();
            al.add("Azamgarh");
            al.add("Lucknow");
            for(String s : al){
                out.println(s);
            }
        %>
        
        <% session.setAttribute("name","Mohan Kumar"); %>
        <% 
            int x = 10,y = 0, z;
            z = x/y;
            out.println(z);
        %>
        
    </body>
</html>
