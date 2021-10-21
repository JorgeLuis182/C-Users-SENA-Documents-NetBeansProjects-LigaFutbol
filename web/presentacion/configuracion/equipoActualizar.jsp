<%-- 
    Document   : equipoActualizar
    Created on : 14 oct 2021, 23:11:22
    Author     : cristian araujo
--%>

<%@page import="clases.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Equipo equipo=new Equipo();

switch(request.getParameter("accion")){
    case "Adicionar":
        equipo.setNombre(request.getParameter("nombre"));
        equipo.guardar();
        break;
    case "Modificar":
        equipo.setId(request.getParameter("id"));
        equipo.setNombre(request.getParameter("nombre"));
        equipo.modificar();
        break;
    case "Eliminar":
        equipo.setId(request.getParameter("id"));
        equipo.eliminar();
        break;
}
%>
<script type="text/javascript"> location="principal.jsp?CONTENIDO=configuracion/equipo.jsp" </script> 
