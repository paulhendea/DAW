<%-- 
    Document   : pruebaAccion
    Created on : Feb 23, 2023, 9:28:46 PM
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
        <h1>Hello World!</h1>
        <p>
            <% if (Math.random() < 0.5) { %>
                <jsp:forward page="/consejos/consejo1.html"></jsp:forward>
            <% } else { %>
                <jsp:forward page="/consejos/consejo2.html"></jsp:forward>
            <% } %>
        </p> 
    </body>
</html>
