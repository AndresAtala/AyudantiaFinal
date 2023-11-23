package com.gestionBiblioteca.model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablas(create);
        DBConnector.closeConnection();
    }

    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearTablas(DSLContext create) {
        // Crear tabla Libro
        create.createTableIfNotExists("Libro")
                .column("titulo", VARCHAR(100))
                .column("autor", VARCHAR(100))
                .column("isbn", VARCHAR(20))
                .column("genero", VARCHAR(50))
                .column("anoPublicacion", INTEGER)
                .constraint(primaryKey("isbn"))
                .execute();

        // Crear tabla Usuario
        create.createTableIfNotExists("Usuario")
                .column("nombre", VARCHAR(100))
                .column("id", VARCHAR(20))
                .column("direccion", VARCHAR(200))
                .column("numeroTelefono", VARCHAR(15))
                .column("correoElectronico", VARCHAR(100))
                .constraint(primaryKey("id"))
                .execute();

        // Crear tabla Préstamo
        create.createTableIfNotExists("Prestamo")
                .column("isbn", VARCHAR(20).nullable(false))
                .column("idUsuario", VARCHAR(20).nullable(false))
                .column("fechaInicio", DATE)
                .column("fechaDevolucion", DATE)
                .constraint(primaryKey("isbn", "idUsuario"))
                .constraint(foreignKey("isbn").references("Libro", "isbn"))
                .constraint(foreignKey("idUsuario").references("Usuario", "id"))
                .execute();

        // Crear tabla Biblioteca
        create.createTableIfNotExists("Biblioteca")
                .column("nombre", VARCHAR(100))
                .column("direccion", VARCHAR(200))
                .column("numeroTelefono", VARCHAR(15))
                .constraint(primaryKey("nombre"))
                .execute();
    }
}



