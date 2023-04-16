<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="controller.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceso Ususario Registrado</title>
</head>
<body>
<form action="User" method="post">
Usuario:<br>
<input type="text" name="usuario" value=""><br>
Password:<br>
<input type="text" name="password" value=""><br>
<input type="submit" name="1">
</form>

<a href="newuser.jsp">¿No Eres Usuario? Registrate aqui</a>
<% String message = (String)request.getAttribute("usuarioRegistrado");
	if (message == null){
		message="";
	}
%>
<%=message%>
</body>
</html>