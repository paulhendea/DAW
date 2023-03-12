<%-- 
    Document   : process2_1
    Created on : Feb 23, 2023, 9:47:57 PM
    Author     : paulhendea
--%>

<jsp:useBean id="usuario" scope="request" class="Entidad.InfoUsuario" />
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
        <form method="POST" action="process2_1.jsp">
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
        <jsp:setProperty name="usuario" property="nombre" value="<%= nombre %>" />
        <jsp:setProperty name="usuario" property="email" value="<%= email %>" />
        <jsp:forward page="process2_2.jsp"></jsp:forward>
        <% } %>
    </body>
</html>
