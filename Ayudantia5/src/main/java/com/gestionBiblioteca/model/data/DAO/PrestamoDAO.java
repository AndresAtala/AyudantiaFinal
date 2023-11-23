package com.gestionBiblioteca.model.data.DAO;

import com.gestionBiblioteca.model.Prestamo;
import org.jooq.DSLContext;

import java.util.Date;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class PrestamoDAO {

    public void realizarPrestamo(DSLContext query, Prestamo prestamo) {
        try {
            query.insertInto(table("Prestamo"),
                            field("isbn"),
                            field("idUsuario"),
                            field("fechaInicio"),
                            field("fechaDevolucion"))
                    .values(prestamo.getLibro().getIsbn(),
                            prestamo.getUsuario().getId(),
                            prestamo.getFechaInicio(),
                            prestamo.getFechaDevolucion())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void devolverLibro(DSLContext query, String isbn, String idUsuario, Date fechaDevolucion) {
        try {
            query.update(table("Prestamo"))
                    .set(field("fechaDevolucion"), fechaDevolucion)
                    .where(field("isbn").eq(isbn)
                            .and(field("idUsuario").eq(idUsuario))
                            .and(field("fechaDevolucion").isNull()))
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public List<Prestamo> obtenerPrestamosVigentes(DSLContext query) {
        List<Prestamo> prestamos = null;
        try {
            prestamos = query.selectFrom(table("Prestamo"))
                    .where(field("fechaDevolucion").isNull())
                    .fetchInto(Prestamo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prestamos;
    }
}
