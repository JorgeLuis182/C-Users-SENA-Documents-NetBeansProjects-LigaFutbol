<%-- 
    Document   : equipoFormulario
    Created on : 14 oct 2021, 23:11:00
    Author     : cristian araujo
--%>

<%@page import="clases.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo="Adicionar";
    Equipo equipo=null;
    if(request.getParameter("id")!=null){
        titulo="Modificar";
        equipo=new Equipo(request.getParameter("id"));
    }else{
        equipo=new Equipo();
    }
%>
<h3><%= titulo.toUpperCase() %> EQUIPO </h3>
<form name="formulario" method="post" action="principal.jsp?CONTENIDO=configuracion/equipoActualizar.jsp">
    <table>
        <tr><th>Nombre del equipo</th><td><input type="text" name="nombre" value="<%= equipo.getNombre() %>" required size="50" maxlength="50"> </td></tr>
    </table>
    <p>
        <input type="hidden" name="id" value="<%= equipo.getId() %>">
        <input type="submit" name="accion" value="<%= titulo %>">
</form>