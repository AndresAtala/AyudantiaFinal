<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 22-11-2023
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Usuario</title>
</head>
<body>
<h2>Registrar Usuario</h2>
<form action="AgregarUsuarioServlet" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    ID: <input type="text" name="id" required><br>
    Dirección: <input type="text" name="direccion" required><br>
    Número de Teléfono: <input type="text" name="numeroTelefono" required><br>
    Correo Electrónico: <input type="email" name="correoElectronico" required><br>
    <input type="submit" value="Registrar Usuario">
</form>
</body>
</html>

