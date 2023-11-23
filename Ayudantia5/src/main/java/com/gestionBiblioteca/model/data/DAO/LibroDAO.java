package com.gestionBiblioteca.model.data.DAO;

import com.gestionBiblioteca.model.Libro;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.TableField;

import static org.jooq.impl.DSL.*;

import java.util.ArrayList;
import java.util.List;

public class LibroDAO {


    public void agregarLibro(DSLContext query, Libro libro) {
        try {
            query.insertInto(table("Libro"),
                            field("titulo"),
                            field("autor"),
                            field("isbn"),
                            field("genero"),
                            field("anoPublicacion"))
                    .values(libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.getGenero(), libro.getAnoPublicacion())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
    }

    public List<Libro> obtenerTodosLosLibros(DSLContext query) {
        List<Libro> libros = new ArrayList<>();
        Result<Record> result = query.select().from(table("Libro")).fetch();
        for (Record record : result) {
            Libro libro = construirLibroDesdeRecord(record);
            libros.add(libro);
        }
        return libros;
    }


    public List<Libro> buscarLibros(DSLContext query, String criterio, String valor) {
        List<Libro> libros = new ArrayList<>();
        Result<Record> result = query.select().from(table("Libro")).where(field(criterio).like("%" + valor + "%")).fetch();
        for (Record record : result) {
            Libro libro = construirLibroDesdeRecord(record);
            libros.add(libro);
        }
        return libros;
    }

    private Libro construirLibroDesdeRecord(Record record) {
        return new Libro(
                record.get(field("titulo", String.class)),
                record.get(field("autor", String.class)),
                record.get(field("isbn", String.class)),
                record.get(field("genero", String.class)),
                record.get(field("anoPublicacion", Integer.class))
        );
    }
}
