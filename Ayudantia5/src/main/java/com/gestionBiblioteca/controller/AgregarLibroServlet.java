package com.gestionBiblioteca.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.gestionBiblioteca.model.*;
import com.gestionBiblioteca.model.data.DBGenerator;
import com.gestionBiblioteca.model.data.DAO.LibroDAO;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;


@WebServlet("/AgregarLibroServlet")
public class AgregarLibroServlet extends HttpServlet {
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
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String isbn = request.getParameter("isbn");
        String genero = request.getParameter("genero");
        int anoPublicacion = Integer.parseInt(request.getParameter("anoPublicacion"));

        // Crear un objeto Libro con la información
        Libro libro = new Libro(titulo, autor, isbn, genero, anoPublicacion);

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("LibreriaBD");

            // Agregar el libro a la base de datos
            LibroDAO libroDAO = new LibroDAO();
            libroDAO.agregarLibro(query, libro);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada en un entorno de producción
        }

        // Redirigir a una página de éxito o mostrar un mensaje
        response.sendRedirect("index.jsp"); //cambiar INdex por otra wea
    }
}

