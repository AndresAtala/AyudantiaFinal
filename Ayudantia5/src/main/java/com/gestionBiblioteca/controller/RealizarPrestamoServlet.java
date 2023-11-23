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

@WebServlet("/RealizarPrestamoServlet")
public class RealizarPrestamoServlet extends HttpServlet {

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
        String idUsuario = request.getParameter("idUsuario");
        String isbnLibro = request.getParameter("isbnLibro");
        String fechaInicioStr = request.getParameter("fechaInicio");

        // Convertir la fecha de inicio a un objeto Date
        Date fechaInicio = null;
        try {
            fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicioStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Crear objetos Libro, Usuario y Prestamo
        Libro libro = new Libro(); // Necesitas obtener el libro de la base de datos según el ISBN
        Usuario usuario = new Usuario(); // Necesitas obtener el usuario de la base de datos según el ID
        Prestamo prestamo = new Prestamo(libro, usuario, fechaInicio, null); // Fecha de devolución inicialmente nula

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("LibrosBD");

            // Realizar el préstamo
            PrestamoDAO prestamoDAO = new PrestamoDAO();
            prestamoDAO.realizarPrestamo(query, prestamo); // Corregir esta línea

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada en un entorno de producción
        }
        response.sendRedirect("index.jsp");

    }
}
