<%-- 
    Document   : process
    Created on : Feb 23, 2023, 9:33:09 PM
    Author     : paulhendea
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
            if ((request.getParameter("name") == null
                && request.getParameter("email") == null)
                || 
                (request.getParameter("name").equals("") 
                && request.getParameter("email").equals(""))) 
            { 
        %>
        Complete este formulario: 
        <form method="POST" action="process.jsp">
            Su nombre: <input type="text" name="name"><BR>
            Su email: <input type="email" name="email"><BR>
            <input type="submit" value="submit">
        </form>
        <% 
            } else {
        %>
        <% String nombre, email; %>
        <% 
            nombre = request.getParameter("name");
            email = request.getParameter("email");
        %>
        Usted ha indicado la siguiente información: <BR>
        <b>Nombre: </b> <%= nombre %><BR>
        <b>Email: </b><%= email %><BR>
        <% } %>
    </body>
</html>
