
package Proyecto1Progra4.modelo.dao;

import Proyecto1Progra4.datos.BaseDatos;
import Proyecto1Progra4.modelo.TipoCuenta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */
public class ServicioTipoCuenta {
    
    public List<TipoCuenta> listarTiposCuenta(){
        List<TipoCuenta> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_TipoCuenta.LISTAR.obtenerComando())) {
            while (rs.next()) {
                TipoCuenta t = new TipoCuenta(
                        rs.getInt("id_tipo_cuenta"),
                        rs.getString("descripcion")
                );
                r.add(t);
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
    
    public int obtenerIdTipoCuenta(String desc) {
        int idTipo = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_TipoCuenta.CONSULTAR_ID.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, desc);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    idTipo = rs.getInt("id_tipo_cuenta");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return idTipo;
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
        ServicioTipoCuenta su = new ServicioTipoCuenta();
        List<TipoCuenta> tipos = su.listarTiposCuenta();
        int i = 0;
        for (TipoCuenta u : tipos) {
            System.out.printf("%4d: %s,%n", ++i, u);
        }
        System.out.println(su.obtenerIdTipoCuenta("Cuenta de ahorros"));
//        System.out.println(su.insertarTipoCuenta(1, "Cuenta Ahorro", 0.13));
    }
}
