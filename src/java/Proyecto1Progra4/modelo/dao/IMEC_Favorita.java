
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_Favorita {
    INSERTAR("INSERT INTO favorita (cliente_id_cliente, cuenta_num_cuenta) VALUES (?, ?); "),
    LISTAR("SELECT cliente_id_cliente, cuenta_num_cuenta FROM favorita WHERE cliente_id_cliente = ?; ");

    IMEC_Favorita(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
