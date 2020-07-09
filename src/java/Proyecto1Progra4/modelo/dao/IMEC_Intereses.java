
package Proyecto1Progra4.modelo.dao;

/**
 *
 * @author Josue
 */
public enum IMEC_Intereses {
    CONSULTAR_INTERES("SELECT tasa_interes FROM interes WHERE cuenta_id_tipo = ? and moneda_nombre = ?;");
    
    IMEC_Intereses(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
