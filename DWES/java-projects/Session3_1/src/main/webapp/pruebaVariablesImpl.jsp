<%-- 
    Document   : pruebaVariablesImpl
    Created on : Feb 23, 2023, 9:27:02 PM
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
            La IP de tu ordenador es: <%= request.getRemoteHost() %><BR>
            El nombre del servidor es <%= request.getServerName() %><BR>
            El puerto del servidor: <%= request.getServerPort() %><BR>
            La IP del servidor es: <%= request.getRemoteAddr() %><BR>
            El protocolo que estas usando es: <%= request.getProtocol()%>
        </p>
    </body>
</html>
