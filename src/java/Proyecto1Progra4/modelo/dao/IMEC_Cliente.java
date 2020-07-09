
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_Cliente {
    INSERTAR("INSERT INTO cliente (id_cliente, usuario_id_usuario, apellidos, nombre, telefono) VALUES (?, ?, ?, ?, ?); "),
    CONSULTAR_ID("SELECT id_cliente FROM cliente WHERE usuario_id_usuario = ?;"),
    MODIFICAR("UPDATE cliente SET apellidos=?, nombre=?, telefono=? WHERE id_cliente=?; "),
    VALIDAR("SELECT * FROM cliente WHERE id_cliente=?; "),
    ELIMINAR("DELETE FROM cliente WHERE id_cliente=?; ");

    IMEC_Cliente(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
