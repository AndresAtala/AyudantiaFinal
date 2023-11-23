<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Realizar Préstamo</title>
</head>
<body>
<h2>Realizar Préstamo</h2>
<form action="RealizarPrestamoServlet" method="post">
    ID del Usuario: <input type="text" name="idUsuario" required><br>
    ISBN del Libro: <input type="text" name="isbnLibro" required><br>
    Fecha de Inicio del Préstamo: <input type="date" name="fechaInicio" required><br>
    <input type="submit" value="Realizar Préstamo">
</form>
</body>
</html>
