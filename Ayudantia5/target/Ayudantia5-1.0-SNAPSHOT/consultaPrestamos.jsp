<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Consulta de Préstamos</title>
</head>
<body>
<h2>Préstamos Vigentes</h2>

<c:if test="${not empty prestamosVigentes}">
    <table border="1">
        <tr>
            <th>Libro</th>
            <th>Usuario</th>
            <th>Fecha de Inicio</th>
            <th>Fecha de Devolución</th>
        </tr>

        <c:forEach var="prestamo" items="${prestamosVigentes}">
            <tr>
                <td>${prestamo.libro.titulo}</td>
                <td>${prestamo.usuario.nombre}</td>
                <td>${prestamo.fechaInicio}</td>
                <td>${prestamo.fechaDevolucion}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty prestamosVigentes}">
    <p>No hay préstamos vigentes en este momento.</p>
</c:if>
</body>
</html>
