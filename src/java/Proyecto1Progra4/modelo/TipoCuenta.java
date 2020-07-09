
package Proyecto1Progra4.modelo;

import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class TipoCuenta implements Serializable{

    public TipoCuenta(int idTipoCuenta, String descripcion) {
        this.idTipoCuenta = idTipoCuenta;
        this.descripcion = descripcion;
    }

    public TipoCuenta() {
    }

    @Override
    public String toString() {
        return String.format("{%s, %s}", getIdTipoCuenta(), getDescripcion());
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private int idTipoCuenta;
    private String descripcion;
}
