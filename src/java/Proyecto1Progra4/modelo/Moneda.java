
package Proyecto1Progra4.modelo;

import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class Moneda implements Serializable{

    public Moneda(String nombre, String descripcion, String simbolo, double tipoCambioCompra, double tipoCambioVenta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.simbolo = simbolo;
        this.tipoCambioCompra = tipoCambioCompra;
        this.tipoCambioVenta = tipoCambioVenta;
    }

    public Moneda() {
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s}", getNombre(), getDescripcion(), getSimbolo(), getTipoCambioCompra(), getTipoCambioCompra());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getTipoCambioCompra() {
        return tipoCambioCompra;
    }

    public void setTipoCambioCompra(double tipoCambioCompra) {
        this.tipoCambioCompra = tipoCambioCompra;
    }

    public double getTipoCambioVenta() {
        return tipoCambioVenta;
    }

    public void setTipoCambioVenta(double tipoCambioVenta) {
        this.tipoCambioVenta = tipoCambioVenta;
    }
    
    private String nombre;
    private String descripcion;
    private String simbolo;
    private double tipoCambioCompra;
    private double tipoCambioVenta;
}
