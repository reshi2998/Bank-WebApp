
package Proyecto1Progra4.modelo;

import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class Favorita implements Serializable{

    public Favorita(String idCliente, String numCuenta) {
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
    }

    public Favorita() {
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", getIdCliente(), getNumCuenta());
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    
    private String idCliente;
    private String numCuenta;
}
