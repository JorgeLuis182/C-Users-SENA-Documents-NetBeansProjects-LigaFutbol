<%-- 
    Document   : validar
    Created on : 14 oct 2021, 22:15:52
    Author     : cristian araujo
--%>

<%@page import="clasesGenericas.ConectorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
ConectorBD conector=new ConectorBD();
String mensaje="";
if(conector.conectar()) mensaje="Conectado a la Bd";
else mensaje="No se conecto a la Bd";
%>
<%= mensaje %>