<%-- 
    Document   : pruebaerror
    Created on : Feb 23, 2023, 8:45:53 PM
    Author     : paulhendea
--%>

<%@page errorPage="error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><%= 0/0 %></p>
    </body>
</html>
