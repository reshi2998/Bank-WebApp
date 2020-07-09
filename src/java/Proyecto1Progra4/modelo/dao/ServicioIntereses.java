
package Proyecto1Progra4.modelo.dao;

import Proyecto1Progra4.datos.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Josue
 */
public class ServicioIntereses {
    
    public double obtenerTasaInteres(int tipo, String moneda) {
        double tasa = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Intereses.CONSULTAR_INTERES.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, tipo);
            stm.setString(2, moneda);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    tasa = rs.getDouble("tasa_interes");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return tasa;
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
//        ServicioIntereses su = new ServicioIntereses();
//        System.out.println(su.obtenerTasaInteres(2, "CRC"));
    }
}
