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
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String isbn = request.getParameter("isbn");
        String genero = request.getParameter("genero");
        int anoPublicacion = Integer.parseInt(request.getParameter("anoPublicacion"));


        Libro libro = new Libro(titulo, autor, isbn, genero, anoPublicacion);

        try {
            DSLContext query = DBGenerator.conectarBD("LibreriaBD");

            LibroDAO libroDAO = new LibroDAO();
            libroDAO.agregarLibro(query, libro);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }


        response.sendRedirect("index.jsp");
    }
}

