
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_Cuenta {
    INSERTAR("INSERT INTO cuenta (num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion, "
            + "limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); "),
    LISTAR("SELECT num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion,"
            + "limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final FROM cuenta"
            + " WHERE cliente_id_cliente=?; "),
    LISTAR_TODAS("SELECT num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion,"
            + "limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final FROM cuenta; "),
    BUSCAR("SELECT num_cuenta, tipo_cuenta_id_tipo_cuenta, cliente_id_cliente, moneda_nombre, fecha_creacion, "
            + "limite_transferencia_diaria, activa, saldo_inicial, fecha_ultima_aplicacion, saldo_final FROM cuenta"
            + " WHERE num_cuenta=?; "),
    CONSULTAR_SALDO("SELECT saldo_final FROM cuenta WHERE num_cuenta = ?;"),
    CONSULTAR_ID("SELECT cliente_id_cliente FROM cuenta WHERE num_cuenta = ?;"),
    MODIFICAR("UPDATE cuenta SET fecha_ultima_aplicacion=?, saldo_final=? WHERE num_cuenta=?; "),
    ELIMINAR("DELETE FROM cuenta WHERE num_cuenta=?; ");

    IMEC_Cuenta(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
