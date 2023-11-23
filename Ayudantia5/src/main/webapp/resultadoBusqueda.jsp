<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados de Búsqueda</title>
</head>
<body>
<h2>Resultados de Búsqueda</h2>

<c:if test="${not empty librosEncontrados}">
    <table border="1">
        <tr>
            <th>Título</th>
            <th>Autor</th>
            <th>ISBN</th>
            <th>Género</th>
            <th>Año de Publicación</th>
        </tr>

        <c:forEach var="libro" items="${librosEncontrados}">
            <tr>
                <td>${libro.titulo}</td>
                <td>${libro.autor}</td>
                <td>${libro.isbn}</td>
                <td>${libro.genero}</td>
                <td>${libro.anoPublicacion}</td>
            </tr>
        </c:forEach>
    </table>
    <li><a href="index.jsp">INICIO</a></li>
</c:if>

<c:if test="${empty librosEncontrados}">
    <p>No se encontraron libros que coincidan con la búsqueda.</p>
    <li><a href="index.jsp">INICIO</a></li>
</c:if>
</body>
</html>
