<%-- 
    Document   : resultadoPartido
    Created on : 15 oct 2021, 14:20:46
    Author     : cristian araujo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="clases.ResultadoPartido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String filtro="";
    String lista="";
    ResultadoPartido resultadoPartido=new ResultadoPartido();
    if(!filtro.equals("")) filtro+=" and ";
    ArrayList<ResultadoPartido> datos=ResultadoPartido.getListEnObjetos();
    for (int i = 0; i < datos.size(); i++) {
            resultadoPartido = datos.get(i);
            lista+="<tr>";
            lista+="<td>"+resultadoPartido.getId()+"</td>";
            lista+="<td>"+resultadoPartido.getFecha()+"</td>";
            lista+="<td>"+resultadoPartido.getHora()+"</td>";
            lista+="<td>"+resultadoPartido.getLugar()+"</td>";
            lista+="<td>"+resultadoPartido.getEquipoLocal()+"</td>";
            lista+="<td>"+resultadoPartido.getGolesEquipoLocal()+"</td>";
            lista+="<td>"+resultadoPartido.getEquipoVisitante()+"</td>";
            lista+="<td>"+resultadoPartido.getGolesEquipoVisitante()+"</td>";
            lista+="<td>";
            lista+="<a href='principal.jsp?CONTENIDO=configuracion/registrarPartidoFormulario.jsp?id="+resultadoPartido.getId()+"' title='Modificar'>/</a>";
            lista+="<label onClick='Eliminar( "+resultadoPartido.getId()+" );' title='Eliminar'> X </label>";
            lista+="</td>";
            lista+="</tr>";
        }


%>
<h3>REGISTRO DE PARTIDOS JUGADOS</h3>
<form name="formulario" method="post" action="">
    <table>
        <tr><td> <input type="checkbox" name="equipo"/> Fecha desde <input type="date" name="fecha"/> hasta <input type="date" name="fecha"/></td> </tr>
        <tr><td> <input type="checkbox" name="equipo"/> Equipo <input type="text" name="equipo"/> </td> </tr>
        <tr><td> <input type="checkbox" name="equipo"/> Lugar <input type="text" name="lugar" size="20" /></td> </tr>
        <tr><td> <input type="checkbox" name="equipo"/> Hora <input type="time" name="hora" /></td> </tr>
        
    </table>
    <p>
</form>
    <table border="1">
        <tr><th>Id</th><th>Fecha</th><th>Hora</th><th>Lugar</th><th>Equipo Local</th><th>Goles local</th><th>Equipo visitante</th><th>Goles visitante</th>
            <th><a href="principal.jsp?CONTENIDO=configuracion/registrarPartidoFormulario.jsp" title="Registrar Partido">+</a></th>
        </tr>
        <%= lista %>   
    </table>
<script type="text/javascript">
    function Eliminar(id){
        var respuesta=confirm("Realmente desea eliminar este resgistro");
        if(respuesta) location='principal.jsp?CONTENIDO=configuracion/registrarPartidoActualizar.jsp&accion=Eliminar&id='+id;
    }
</script>