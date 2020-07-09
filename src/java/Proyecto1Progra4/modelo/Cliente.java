
package Proyecto1Progra4.modelo;

import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class Cliente implements Serializable{

    public Cliente(String idCliente, String usuarioIdUsuario, String apellidos, String nombre, String telefono) {
        this.idCliente = idCliente;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %s, %s, %s}", getIdCliente(), getUsuarioIdUsuario(), getApellidos(), getNombre(), getTelefono());
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(String usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    private String idCliente;
    private String usuarioIdUsuario;
    private String apellidos;
    private String nombre;
    private String telefono;
}
