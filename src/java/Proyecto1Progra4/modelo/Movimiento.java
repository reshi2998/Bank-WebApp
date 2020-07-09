
package Proyecto1Progra4.modelo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Josue
 */
public class Movimiento implements Serializable{

    public Movimiento(int idMovimiento, String numCuenta, double monto, Date fecha, int aplicado, String detalle) {
        this.idMovimiento = idMovimiento;
        this.numCuenta = numCuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
        this.detalle = detalle;
    }

    public Movimiento() {
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s, %s}", getIdMovimiento(), getNumCuenta(), getMonto(), getFecha(), getAplicado(),
                getDetalle());
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAplicado() {
        return aplicado;
    }

    public void setAplicado(int aplicado) {
        this.aplicado = aplicado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    private int idMovimiento;
    private String numCuenta;
    private double monto;
    private Date fecha;
    private int aplicado;
    private String detalle;
}
