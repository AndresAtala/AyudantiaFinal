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

        String nombre = request.getParameter("nombre");
        String id = request.getParameter("id");
        String direccion = request.getParameter("direccion");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoElectronico = request.getParameter("correoElectronico");


        Usuario usuario = new Usuario(nombre, id, direccion, numeroTelefono, correoElectronico);

        try {

            DSLContext query = DBGenerator.conectarBD("LibreriaBD");

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.registrarUsuario(query, usuario);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}

