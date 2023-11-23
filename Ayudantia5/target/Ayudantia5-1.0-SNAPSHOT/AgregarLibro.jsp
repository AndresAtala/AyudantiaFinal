<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Libro</title>
</head>
<body>
<h2>Agregar Libro</h2>
<form action="AgregarLibroServlet" method="post">
    Título: <input type="text" name="titulo" required><br>
    Autor: <input type="text" name="autor" required><br>
    ISBN: <input type="text" name="isbn" required><br>
    Género: <input type="text" name="genero" required><br>
    Año de Publicación: <input type="number" name="anoPublicacion" required><br>
    <input type="submit" value="Agregar Libro">
</form>
</body>
</html>
