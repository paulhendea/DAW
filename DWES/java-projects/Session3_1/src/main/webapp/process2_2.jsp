<%-- 
    Document   : process2_2
    Created on : Feb 23, 2023, 9:48:06 PM
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
        <p>
            Usted ha indicado la siguiente información: <BR>
            <b>Nombre: </b><jsp:getProperty name="usuario" property="nombre" /><BR>
            <b>Email: </b><jsp:getProperty name="usuario" property="email" /><BR>
            Mensaje generado por Beans!
        </p>
    </body>
</html>
