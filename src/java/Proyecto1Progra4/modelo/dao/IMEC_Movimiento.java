
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_Movimiento {
    INSERTAR("INSERT INTO movimiento (cuenta_num_cuenta, monto, fecha, aplicado, detalle) VALUES (?, ?, ?, ?, ?); "),
    LISTAR_TODOS("SELECT id_movimiento, cuenta_num_cuenta, monto, fecha, aplicado, detalle FROM movimiento; "),
    LISTAR("SELECT id_movimiento, cuenta_num_cuenta, monto, fecha, aplicado, detalle FROM movimiento WHERE cuenta_num_cuenta = ?; "),
    LISTAR_DETALLE("SELECT id_movimiento, cuenta_num_cuenta, monto, fecha, aplicado, detalle FROM movimiento WHERE detalle = ?; ");;

    IMEC_Movimiento(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
