
package Proyecto1Progra4.modelo.dao;

import Proyecto1Progra4.datos.BaseDatos;
import Proyecto1Progra4.modelo.Favorita;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josue
 */
public class ServicioFavorita {
    
    public boolean insertarFav(String id, String num){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Favorita.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, num);
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
    
    public ArrayList<Favorita> listarCuentasFav(String idCliente) {
        ArrayList<Favorita> listaCuentas = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Favorita.LISTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, idCliente);
            try(ResultSet rs = stm.executeQuery()){
                while (rs.next()) {
                    Favorita cuenta = new Favorita(
                            rs.getString("cliente_id_cliente"),
                            rs.getString("cuenta_num_cuenta")
                    );
                    listaCuentas.add(cuenta);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaCuentas;
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
