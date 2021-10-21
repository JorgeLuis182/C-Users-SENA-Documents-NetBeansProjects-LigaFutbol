<%-- 
    Document   : registrarEquipo
    Created on : 12 oct 2021, 18:15:24
    Author     : cristian araujo
--%>
<%@page import="clasesGenericas.ConectorBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    String lista="";
    ArrayList<Equipo> datos=Equipo.getListEnObjetos();
    for (int i = 0; i < datos.size(); i++) {
            Equipo equipo = datos.get(i);
            lista+="<tr>";
            lista+="<td>"+equipo.getId()+"</td>";
            lista+="<td>"+equipo.getNombre()+"</td>";
            lista+="<td>";
            lista+="<a href='principal.jsp?CONTENIDO=configuracion/equipoFormulario.jsp?id= "+equipo.getId()+"' title='Modificar'>/</a>";
            lista+="<label onClick='Eliminar( "+equipo.getId()+" );' title='Eliminar'>X</label>";
            lista+="</td>";
            lista+="</tr>";
        }
%>
<h3>LISTA DE EQUIPOS INSCRITOS</h3>
<table border="1">
    <tr><th>ID</th><th>NOMBRE</th><td> <a href="principal.jsp?CONTENIDO=configuracion/equipoFormulario.jsp">+</a> </td></tr>
    <%=lista%>
</table>
<script type="text/javascript">
    function Eliminar(id){
        var respuesta = confirm("Realmente desea eliminar este gasto?");
        if(respuesta) location='principal.jsp?CONTENIDO=configuracion/equipoActualizar.jsp&accion=Eliminar&id='+id;
    }
</script>