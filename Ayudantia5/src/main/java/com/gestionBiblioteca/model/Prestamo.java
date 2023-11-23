package com.gestionBiblioteca.model;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaDevolucion;


    public Prestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }


    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

