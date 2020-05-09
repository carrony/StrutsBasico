<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro de usuario sencillo</title>
	<style>
		form { width: 55%; border: 2px solid black; background: aliceblue;}
		label {width:30%; display:inline-block;}
		input {display:inline-block;}
		form>div { margin: 10px;}
		.error { color:red;}
	</style>
</head>
<body>
	<h1>Registrar un producto nuevo</h1>
	<form action="alta_producto.action" method="POST">
		<div>
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" id="nombre"  value="${producto.nombre}">
		</div>
		<div>
			<label for="descripcion">Descripción</label>
			<input type="input" name="descripcion" id="descripcion" value="${producto.descripcion}">
		</div>
		<div>
			<label for="precio">Precio</label>
			<input type="text" name="precio" id="precio">
			<c:if test = "${producto.precio <0}">
         		<p class="error"> Error. Debe introducir un dato numérico y mayor que 0</p>
      		</c:if>
		</div>
		<div><input type="submit"></div>
	</form>
</body>
</html>
