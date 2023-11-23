package com.gestionBiblioteca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.gestionBiblioteca.model.*;
import com.gestionBiblioteca.model.data.DBGenerator;
import com.gestionBiblioteca.model.data.DAO.UsuarioDAO;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet("/AgregarUsuarioServlet")
public class AgregarUsuarioServlet extends HttpServlet {

    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("LibreriaBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        String direccion = request.getParameter("direccion");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoElectronico = request.getParameter("correoElectronico");

        // Crear un objeto Usuario con la información
        Usuario usuario = new Usuario(nombre, id, direccion, numeroTelefono, correoElectronico);

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("LibreriaBD");

            // Agregar el usuario a la base de datos
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.registrarUsuario(query, usuario);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada en un entorno de producción
        }

        // Redirigir a una página de éxito o mostrar un mensaje
        response.sendRedirect("index.jsp");
    }
}

