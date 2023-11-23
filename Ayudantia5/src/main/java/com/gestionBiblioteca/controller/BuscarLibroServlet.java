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

        String criterio = request.getParameter("criterio");
        String valor = request.getParameter("valor");

        try {

            DSLContext query = DBGenerator.conectarBD("LibreriaBD");


            LibroDAO libroDAO = new LibroDAO();
            List<Libro> librosEncontrados = libroDAO.buscarLibros(query, criterio, valor);


            request.setAttribute("librosEncontrados", librosEncontrados);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        request.getRequestDispatcher("resultadoBusqueda.jsp").forward(request, response);
    }
}
