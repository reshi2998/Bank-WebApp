
package Proyecto1Progra4.modelo.dao;

import Proyecto1Progra4.datos.BaseDatos;
import Proyecto1Progra4.modelo.Movimiento;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Josue
 */
public class ServicioMovimiento {
    
    public boolean insertarMovimiento(String numCuenta, double monto, Date fecha, int aplicado, String detalle){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Movimiento.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, numCuenta);
            stm.setDouble(2, monto);
            stm.setDate(3, fecha);
            stm.setInt(4, aplicado);
            stm.setString(5, detalle);
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
    
    public ArrayList<Movimiento> listarMovimientos(String numCuenta) {
        ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Movimiento.LISTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, numCuenta);
            try(ResultSet rs = stm.executeQuery()){
                while (rs.next()) {
                    Movimiento movimiento = new Movimiento(
                            rs.getInt("id_movimiento"),
                            rs.getString("cuenta_num_cuenta"),
                            rs.getDouble("monto"),
                            rs.getDate("fecha"),
                            rs.getInt("aplicado"),
                            rs.getString("detalle")
                    );
                    listaMovimientos.add(movimiento);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaMovimientos;
    }
    
    public ArrayList<Movimiento> listarMovimientosDetalle(String detalle) {
        ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Movimiento.LISTAR_DETALLE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, detalle);
            try(ResultSet rs = stm.executeQuery()){
                while (rs.next()) {
                    Movimiento movimiento = new Movimiento(
                            rs.getInt("id_movimiento"),
                            rs.getString("cuenta_num_cuenta"),
                            rs.getDouble("monto"),
                            rs.getDate("fecha"),
                            rs.getInt("aplicado"),
                            rs.getString("detalle")
                    );
                    listaMovimientos.add(movimiento);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaMovimientos;
    }
    
    public ArrayList<Movimiento> listarTodosMovimientos() {
        ArrayList<Movimiento> listaM = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(IMEC_Movimiento.LISTAR_TODOS.obtenerComando())) {
            while (rs.next()) {
                Movimiento movimiento = new Movimiento(
                        rs.getInt("id_movimiento"),
                        rs.getString("cuenta_num_cuenta"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha"),
                        rs.getInt("aplicado"),
                        rs.getString("detalle")
                );
                listaM.add(movimiento);
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return listaM;
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
//        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//        ServicioMovimiento su = new ServicioMovimiento();
////        System.out.println(su.insertarMovimiento("79236726438256304", 200000, date, 1, "Ahorro PS4"));
//        List<Movimiento> moves = su.listarTodosMovimientos();
//        int i = 0;
//        for (Movimiento u : moves) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//        }
    }
}
