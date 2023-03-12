<%-- 
    Document   : pruebaScriptJSP
    Created on : Feb 23, 2023, 9:23:23 PM
    Author     : paulhendea
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p><%= new Date() %></p>
        <p>
            <% Calendar cal = Calendar.getInstance();
            out.println("La fecha actual es: " +
                cal.get(Calendar.DATE) + "/" +
                cal.get(Calendar.MONTH) + "/" +
                cal.get(Calendar.YEAR)); %>
        </p>
        <p>
            <%! private int accessCount = 0; %>
            Accesos a la página: <%= ++accessCount %>
        </p>
    </body>
</html>
