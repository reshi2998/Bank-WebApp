
package Proyecto1Progra4.modelo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Josue
 */
public class Cuenta implements Serializable{

    public Cuenta(String numCuenta, int idTipoCuenta, String idCliente, String nombreMoneda, Date fechaCreacion, 
            double limiteTransDiaria, int activa, double saldoInicial, Date fechaUltimaAplic, double saldoFinal) {
        this.numCuenta = numCuenta;
        this.idTipoCuenta = idTipoCuenta;
        this.idCliente = idCliente;
        this.nombreMoneda = nombreMoneda;
        this.fechaCreacion = fechaCreacion;
        this.limiteTransDiaria = limiteTransDiaria;
        this.activa = activa;
        this.saldoInicial = saldoInicial;
        this.fechaUltimaAplic = fechaUltimaAplic;
        this.saldoFinal = saldoFinal;
    }

    public Cuenta() {
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s, %s, %s, %s, %s, %s,}", getNumCuenta(), getIdTipoCuenta(), getIdCliente(),
                getNombreMoneda(), getFechaCreacion(), getLimiteTransDiaria(), getActiva(), getSaldoInicial(), getFechaUltimaAplic(),
                getSaldoFinal());
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getLimiteTransDiaria() {
        return limiteTransDiaria;
    }

    public void setLimiteTransDiaria(double limiteTransDiaria) {
        this.limiteTransDiaria = limiteTransDiaria;
    }

    public int getActiva() {
        return activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Date getFechaUltimaAplic() {
        return fechaUltimaAplic;
    }

    public void setFechaUltimaAplic(Date fechaUltimaAplic) {
        this.fechaUltimaAplic = fechaUltimaAplic;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    private String numCuenta;
    private int idTipoCuenta;
    private String idCliente;
    private String nombreMoneda;
    private Date fechaCreacion;
    private double limiteTransDiaria;
    private int activa;
    private double saldoInicial;
    private Date fechaUltimaAplic;
    private double saldoFinal;
}
