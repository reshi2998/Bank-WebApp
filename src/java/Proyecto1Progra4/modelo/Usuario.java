
package Proyecto1Progra4.modelo;

import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class Usuario implements Serializable {

    public Usuario(String idUsuario, String claveAcceso, int claveVencida, int rol) {
        this.idUsuario = idUsuario;
        this.claveAcceso = claveAcceso;
        this.claveVencida = claveVencida;
        this.rol = rol;
    }

    public Usuario() {
    }
    

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s}", getIdUsuario(), getClaveAcceso(), getClaveVencida(), getRol());
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public int getClaveVencida() {
        return claveVencida;
    }

    public void setClaveVencida(int claveVencida) {
        this.claveVencida = claveVencida;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    private String idUsuario;
    private String claveAcceso;
    private int claveVencida;
    private int rol;
}
