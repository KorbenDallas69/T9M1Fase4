<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Captura el Modelo del Producto a Consultar<br>
<br>
<form action="Consultar" method="post">
	Modelo:<br>
	<input type="text" name="modelo" value=""><br>
	
	<input type="submit" value="Consultar"><br>
</form>
<a href="modcantprod.jsp">Modificar Cantidad de un Producto</a><br>
<a href="agregarprod.jsp">Agregar un Producto</a>

</body>
</html>