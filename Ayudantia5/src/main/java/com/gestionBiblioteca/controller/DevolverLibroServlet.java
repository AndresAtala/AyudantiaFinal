package com.gestionBiblioteca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.gestionBiblioteca.model.*;
import com.gestionBiblioteca.model.data.DBGenerator;
import com.gestionBiblioteca.model.data.DAO.PrestamoDAO;
import org.jooq.DSLContext;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/DevolverLibroServlet")
public class DevolverLibroServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("LibreriaBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idUsuario = request.getParameter("idUsuario");
        String isbnLibro = request.getParameter("isbnLibro");
        String fechaDevolucionStr = request.getParameter("fechaDevolucion");


        Date fechaDevolucion = null;
        try {
            fechaDevolucion = new SimpleDateFormat("yyyy-MM-dd").parse(fechaDevolucionStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Libro libro = new Libro();
        Usuario usuario = new Usuario();
        Prestamo prestamo = new Prestamo(libro, usuario, null, fechaDevolucion);

        try {
            DSLContext query = DBGenerator.conectarBD("LibreriaBD");

            PrestamoDAO prestamoDAO = new PrestamoDAO();
            prestamoDAO.devolverLibro(query, prestamo.getLibro().getIsbn(), prestamo.getUsuario().getId(), prestamo.getFechaDevolucion());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        response.sendRedirect("index.jsp");
    }
}

