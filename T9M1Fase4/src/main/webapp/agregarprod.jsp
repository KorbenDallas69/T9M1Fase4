<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar un Nuevo Producto</title>
</head>
<body>
Captura los Datos del Nuevo Producto<br>
<br>
<form action="Newproduct" method="post">

	Cantidad:<br>
	<input type="text" name="cantidad" value=""><br>
	Modelo:<br>
	<input type="text" name="modelo" value=""><br>
	Marca:<br>
	<input type="text" name="marca" value=""><br>
	Descripcion:<br>
	<input type="text" name="descripcion" value=""><br>
	Proveedor:<br>
	<input type="text" name="proveedor" value=""><br>
	<input type="submit" value="Registrar"><br>
</form>
<a href="modcantprod.jsp">Modificar Cantidad de un Producto</a><br>
<a href="consultarprod.jsp">Buscar Un Producto</a>
</body>
</html>