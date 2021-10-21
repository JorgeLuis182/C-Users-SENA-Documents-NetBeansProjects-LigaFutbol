<%-- 
    Document   : registrarPartidoActualizar
    Created on : 15 oct 2021, 16:12:00
    Author     : cristian araujo
--%>

<%@page import="clases.ResultadoPartido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ResultadoPartido resultadoPartido=new ResultadoPartido();

    
    switch(request.getParameter("accion")){
        case "Adicionar":
            resultadoPartido.setFecha(request.getParameter("fecha"));
            resultadoPartido.setHora(request.getParameter("hora"));
            resultadoPartido.setLugar(request.getParameter("lugar"));
            resultadoPartido.setIdequipoLocal(request.getParameter("equipoLocal"));
            resultadoPartido.setGolesEquipoLocal(Integer.parseInt(request.getParameter("golesLocal")));
            resultadoPartido.setIdEquipoVisitante(request.getParameter("equipoVisitante"));
            resultadoPartido.setGolesEquipoVisitante(Integer.parseInt(request.getParameter("golesVisitante")));
            resultadoPartido.guardar();
            break;
            
        case "Modificar":
            resultadoPartido.setId(request.getParameter("id"));
            resultadoPartido.setFecha(request.getParameter("fecha"));
            resultadoPartido.setHora(request.getParameter("hora"));
            resultadoPartido.setLugar(request.getParameter("lugar"));
            resultadoPartido.setIdequipoLocal(request.getParameter("equipoLocal"));
            resultadoPartido.setGolesEquipoLocal(Integer.parseInt(request.getParameter("golesLocal")));
            resultadoPartido.setIdEquipoVisitante(request.getParameter("equipoVisitante"));
            resultadoPartido.setGolesEquipoVisitante(Integer.parseInt(request.getParameter("golesVisitante")));
            resultadoPartido.modificar();
            break;
            
        case "Eliminar":
            resultadoPartido.setId(request.getParameter("id"));
            resultadoPartido.eliminar();
            break;
    }
%>
<script type="text/javascript"> location="principal.jsp?CONTENIDO=configuracion/registrarPartido.jsp" </script>
