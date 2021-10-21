<%-- 
    Document   : registrarPartidoFormulario
    Created on : 15 oct 2021, 15:09:54
    Author     : cristian araujo
--%>
<%@page import="clases.Equipo"%>
<%@page import="clases.ResultadoPartido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String titulo="Adicionar";
    ResultadoPartido resultadopartido=null;
    if(request.getParameter("id")!=null){
            titulo="Modificar";
            resultadopartido=new ResultadoPartido(request.getParameter("id"));
        }else{
            resultadopartido=new ResultadoPartido();
    }
%>
<h3> <%= titulo.toUpperCase() %> EQUIPO</h3>
<form name="formulario" method="post" action="principal.jsp?CONTENIDO=configuracion/registrarPartidoActualizar.jsp"> 
    <table>
        <tr><th>Fecha</th><td> <input type="date" name="fecha" value="<%= resultadopartido.getFecha() %>"> </td></tr>
        <tr><th>Hora</th><td> <input type="time" name="hora" value="<%= resultadopartido.getHora() %>"> </td></tr>
        <tr><th>Lugar</th><td> <input type="text" name="lugar" value="<%= resultadopartido.getLugar() %>"> </td></tr>
        <tr><th>Equipo Local</th><td> <select name="equipoLocal"> <%=Equipo.getListaEnOptions(resultadopartido.getEquipoLocal().toString())%> </select> </td></tr>
        <tr><th>Goles Eq local</th><td> <input type="number" name="golesLocal" value="<%= resultadopartido.getGolesEquipoLocal() %>"> </td></tr>
        <tr><th>Equipo Visitante</th><td> <select name="equipoVisitante" ><%=Equipo.getListaEnOptions(resultadopartido.getEquipoVisitante().toString())%></select> </td></tr>
        <tr><th>Goles eq Visitante</th><td> <input type="number" name="golesVisitante" value="<%= resultadopartido.getGolesEquipoVisitante() %>">  </td></tr>
    </table>
    <input type="hidden" name="id" value="<%= resultadopartido.getId() %>">
    <input type="submit" name="accion" value="<%= titulo %>">
</form>