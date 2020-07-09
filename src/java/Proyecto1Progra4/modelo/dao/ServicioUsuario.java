
package Proyecto1Progra4.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Proyecto1Progra4.datos.BaseDatos;
import Proyecto1Progra4.modelo.Usuario;

/**
 *
 * @author Josue
 */
public class ServicioUsuario {
    
    public boolean insertarUsuario(String id, String clave, int claveVencida, int rol){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, clave);
            stm.setInt(3, claveVencida);
            stm.setInt(4, rol);
            if(stm.executeUpdate() == 1) {
                return true;
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }
    
    public boolean eliminarUsuario(String id){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.ELIMINAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            if(stm.executeUpdate() == 1) {
                return true;
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }
    
    public Optional<Usuario> obtenerUsuario(String id, String clave, int rol) {
        Optional<Usuario> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.VALIDAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, clave);
            stm.setInt(3, rol);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Usuario(
                            rs.getString("id_usuario"),
                            rs.getString("clave_acceso"),
                            rs.getInt("clave_vencida"),
                            rs.getInt("rol")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }
    
    public int obtenerRol(String id, String clave) {
        int numRol = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR_ROL.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, clave);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    numRol = rs.getInt("rol");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return numRol;
    }
    
    public boolean validarUsuario(String id, String clave) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR_USUARIO.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, clave);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.absolute(1)) {
                    return true;
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }
    
    public List<Usuario> obtenerListaUsuarios() {
        List<Usuario> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Usuario.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Usuario e = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("clave_acceso"),
                        rs.getInt("clave_vencida"),
                        rs.getInt("rol")
                );
                r.add(e);
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }
    
    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerConexion();
        return cnx;
    }

    public static void main(String[] args) {
        ServicioUsuario su = new ServicioUsuario();
        System.out.println(su.eliminarUsuario("josu"));
//        List<Usuario> usuarios = su.obtenerListaUsuarios();
//        int i = 0;
//        for (Usuario u : usuarios) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//        }
//        System.out.println(su.insertarUsuario("perro", "contra123", 111, 0));
//        System.out.println(su.validarUsuario("josu", "demon"));

    }
}
