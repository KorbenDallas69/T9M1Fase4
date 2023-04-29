<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="modelo.Producto"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Resultado de la Consulta<br>
<br>
<%
	Producto prod=(Producto) request.getAttribute("Producto");
%>
<h1>RESULTADOS DE LA CONSULTA</h1><br>
<h1>Item:</h1><br>
<%=prod.getItem()%>
<h1>Cantidad:</h1><br>
<%=prod.getQty()%>
<h1>Modelo:</h1><br>
<%=prod.getModelo()%>
<h1>Marca: </h1><br>
<%=prod.getMarca()%>
<h1>Descripcion:</h1><br>
<%=prod.getDescripcion()%>
<h1>Proveedor:</h1><br>
<%=prod.getProvdr()%>
<br>
<a href="modcantprod.jsp">Modificar Cantidad de un Producto</a><br>
<br>
<a href="agregarprod.jsp">Agregar un Producto</a><br>
<br>
<a href="index.jsp">Loggear Otro Usuario</a>

</body>
</html>