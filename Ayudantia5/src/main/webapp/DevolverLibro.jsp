<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Devolver Libro</title>
</head>
<body>
<h2>Devolver Libro</h2>
<form action="DevolverLibroServlet" method="post">
    ID del Usuario: <input type="text" name="idUsuario" required><br>
    ISBN del Libro: <input type="text" name="isbnLibro" required><br>
    Fecha de Devolución: <input type="date" name="fechaDevolucion" required><br>
    <input type="submit" value="Devolver Libro">
</form>
</body>
</html>
