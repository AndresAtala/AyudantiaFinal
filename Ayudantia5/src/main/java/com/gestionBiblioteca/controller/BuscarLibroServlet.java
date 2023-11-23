package com.gestionBiblioteca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.gestionBiblioteca.model.Libro;
import com.gestionBiblioteca.model.data.DBGenerator;
import com.gestionBiblioteca.model.data.DAO.LibroDAO;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet("/BuscarLibroServlet")
public class BuscarLibroServlet extends HttpServlet {
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
        String criterio = request.getParameter("criterio");
        String valor = request.getParameter("valor");

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("LibreriaBD");

            // Buscar libros
            LibroDAO libroDAO = new LibroDAO();
            List<Libro> librosEncontrados = libroDAO.buscarLibros(query, criterio, valor);

            // Puedes almacenar la lista de libros encontrados en el request para mostrarla en la página JSP
            request.setAttribute("librosEncontrados", librosEncontrados);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada en un entorno de producción
        }

        // Redirigir a una página que muestre los resultados de la búsqueda
        request.getRequestDispatcher("resultadoBusqueda.jsp").forward(request, response);
    }
}
