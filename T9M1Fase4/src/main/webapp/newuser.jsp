<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
</head>
<body>
Captura tus datos de Usuario<br>
<br>
<form action="Newuser" method="post">
	Usuario:<br>
	<input type="text" name="usuario" value=""><br>
	Password:<br>
	<input type="text" name="password" value=""><br>
	Nombre:<br>
	<input type="text" name="nombre" value=""><br>
	Apellido:<br>
	<input type="text" name="apellido" value=""><br>
	Edad:<br>
	<input type="text" name="edad" value=""><br>
	<input type="submit" value="Registrar"><br>
</form>
<a href="index.jsp">Regresar</a> <br>
<% String msg=(String)request.getAttribute("usuarioExistente");
if (msg==null){
	msg="";
	}
%>
<%=msg%>
</body>
</html>