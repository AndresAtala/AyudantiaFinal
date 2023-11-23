<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buscar Libro</title>
</head>
<body>
<h2>Buscar Libro</h2>
<form action="BuscarLibroServlet" method="post">
    Criterio de Búsqueda:
    <select name="criterio">
        <option value="titulo">Título</option>
        <option value="autor">Autor</option>
        <option value="genero">Género</option>
    </select>
    <br>
    Valor: <input type="text" name="valor" required><br>
    <input type="submit" value="Buscar Libro">
</form>
</body>
</html>
