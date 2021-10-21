<%-- 
    Document   : inicio
    Created on : 12 oct 2021, 17:29:27
    Author     : cristian araujo
--%>
<%@page import="clasesGenericas.ConectorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LigaDeFutbol</title>
    </head>
    <body>
        <p>
        <div id="banner"></div>
        <div id="menu"> 
                <a href="principal.jsp?CONTENIDO=configuracion/equipo.jsp">REGISTRAR EQUIPO</a>
                <a href="principal.jsp?CONTENIDO=configuracion/registrarPartido.jsp">REGISTRAR UN PARTIDO</a>
                <a href="principal.jsp?CONTENIDO=configuracion/equipo.jsp">LISTA DE POSICIONES</a>
                <a href="../index.jsp">SALIR</a>
        </div>
        <div id="contenido"> <jsp:include page='<%=request.getParameter("CONTENIDO")%>' flush="true" /> </div>
        </p>
    </body>
</html>
