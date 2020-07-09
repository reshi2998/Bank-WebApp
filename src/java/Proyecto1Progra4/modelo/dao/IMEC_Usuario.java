
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_Usuario {
    INSERTAR("INSERT INTO usuario (id_usuario, clave_acceso, clave_vencida, rol) VALUES (?, ?, ?, ?); "),
    CONSULTAR_ROL("SELECT rol FROM usuario WHERE id_usuario = ? and clave_acceso = ?;"),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    ELIMINAR("DELETE FROM usuario WHERE id_usuario=?; "),
    VALIDAR("SELECT id_usuario, clave_acceso, clave_vencida, rol FROM usuario WHERE id_usuario = ? and clave_acceso = ? and rol = ?; "),
    CONSULTAR_USUARIO("SELECT id_usuario, clave_acceso FROM usuario WHERE id_usuario = ? and clave_acceso = ?; "),
    LISTAR("SELECT id_usuario, clave_acceso, clave_vencida, rol FROM usuario ORDER BY id_usuario; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
