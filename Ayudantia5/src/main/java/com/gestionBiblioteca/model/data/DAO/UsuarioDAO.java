package com.gestionBiblioteca.model.data.DAO;

import com.gestionBiblioteca.model.Usuario;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.*;

public class UsuarioDAO {

    public void registrarUsuario(DSLContext query, Usuario usuario) {
        try {
            query.insertInto(table("Usuario"),
                            field("nombre"),
                            field("id"),
                            field("direccion"),
                            field("numeroTelefono"),
                            field("correoElectronico"))
                    .values(usuario.getNombre(), usuario.getId(), usuario.getDireccion(),
                            usuario.getNumeroTelefono(), usuario.getCorreoElectronico())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
