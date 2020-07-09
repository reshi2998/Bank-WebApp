
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_TipoCuenta {
    LISTAR("SELECT id_tipo_cuenta, descripcion FROM tipo_cuenta ORDER BY id_tipo_cuenta; "),
    INSERTAR("INSERT INTO tipo_cuenta (id_tipo_cuenta, descripcion) VALUES (?, ?); "),
    CONSULTAR_ID("SELECT id_tipo_cuenta FROM tipo_cuenta WHERE descripcion = ?;"),
    ELIMINAR("DELETE FROM tipo_cuenta WHERE id_tipo_cuenta=?; ");

    IMEC_TipoCuenta(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
