<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro de usuario sencillo</title>
</head>
<body>
	<h1>Registro Simple de usuario</h1>
	<form action="loguearse.action" method="POST">
		<div>
			<label for="usuario">Usuario</label>
			<input type="text" name="usuario" id="usuario">
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input type="text" name="password" id="password">
		</div>
		<input type="submit">
	</form>
</body>
</html>
