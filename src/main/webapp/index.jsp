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
	<form action="alta_producto.action" method="POST">
		<div>
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" id="nombre">
		</div>
		<div>
			<label for="descripcion">Contraseña</label>
			<input type="input" name="descripcion" id="descripcion">
		</div>
		<div>
			<label for="precio">Precio</label>
			<input type="text" name="precio" id="precio">
		</div>
		<input type="submit">
	</form>
</body>
</html>
