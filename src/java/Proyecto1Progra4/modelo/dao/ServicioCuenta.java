
package Proyecto1Progra4.modelo.dao;

import Proyecto1Progra4.datos.BaseDatos;
import Proyecto1Progra4.modelo.Cuenta;
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
import java.util.Optional;

/**
 *
 * @author Josue
 */
public class ServicioCuenta {
    
    public boolean insertarCuenta(String numCuenta, int idTipo, String idCliente, String moneda, Date fechaCrea, double limite,
            int activa, double saldoInicial, Date fechaUltima, double saldoFinal){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, numCuenta);
            stm.setInt(2, idTipo);
            stm.setString(3, idCliente);
            stm.setString(4, moneda);
            stm.setDate(5, fechaCrea);
            stm.setDouble(6, limite);
            stm.setInt(7, activa);
            stm.setDouble(8, saldoInicial);
            stm.setDate(9, fechaUltima);
            stm.setDouble(10, saldoInicial);
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
    
    public boolean modificarSaldoFecha(Date fechaUltima, double saldoFinal, String numCuenta){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.MODIFICAR.obtenerComando());) {
            stm.clearParameters();
            stm.setDate(1, fechaUltima);
            stm.setDouble(2, saldoFinal);
            stm.setString(3, numCuenta);
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
    
    public double obtenerSaldoActual(String numCuenta) {
        double saldo = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.CONSULTAR_SALDO.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, numCuenta);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    saldo = rs.getInt("saldo_final");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return saldo;
    }
    
    public ArrayList<Cuenta> listarCuentasPorId(String idCliente) {
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.LISTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, idCliente);
            try(ResultSet rs = stm.executeQuery()){
                while (rs.next()) {
                    Cuenta cuenta = new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getDate("fecha_creacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_inicial"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("saldo_final")
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
    
    public ArrayList<Cuenta> listarTodasCuentas() {
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(IMEC_Cuenta.LISTAR_TODAS.obtenerComando())) {
            while (rs.next()) {
                Cuenta cuenta = new Cuenta(
                        rs.getString("num_cuenta"),
                        rs.getInt("tipo_cuenta_id_tipo_cuenta"),
                        rs.getString("cliente_id_cliente"),
                        rs.getString("moneda_nombre"),
                        rs.getDate("fecha_creacion"),
                        rs.getDouble("limite_transferencia_diaria"),
                        rs.getInt("activa"),
                        rs.getDouble("saldo_inicial"),
                        rs.getDate("fecha_ultima_aplicacion"),
                        rs.getDouble("saldo_final")
                );
                listaCuentas.add(cuenta);
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
    
    public String obtenerID(String cuenta) {
        String id = "";
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.CONSULTAR_ID.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, cuenta);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    id = rs.getString("cliente_id_cliente");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return id;
    }
    
    //se genera la tabla con codigo html como string y retorna el string
//    public String obtenerTablaCuentas(String idCliente) { 
//        String id = idCliente;
//        StringBuilder r = new StringBuilder();
//        r.append("<table class=\"tablaCuentas\">");
//
//        r.append("<thead>");
//        r.append("<th width=\"180px\">Número de cuenta</th>");
//        r.append("<th width=\"180px\">Tipo de cuenta</th>");
//        r.append("<th width=\"180px\">ID de cliente</th>");
//        r.append("<th width=\"180px\">Moneda</th>");
//        r.append("<th width=\"180px\">Activa</th>");
//        r.append("<th width=\"180px\">Saldo Actual</th>");
//        r.append("</thead>");
//
//        r.append("<tbody>");
//        List<Cuenta> cuentas = listarCuentasPorId(id);
//        for (Cuenta c : cuentas) {
//            r.append("<tr>");
//            r.append(String.format("<td width=\"180px\"><label>%s</label></td>", c.getNumCuenta()));
//            r.append(String.format("<td width=\"180px\"><label>%s</label></td>", c.getIdTipoCuenta()));
//            r.append(String.format("<td width=\"180px\"><label>%s</label></td>", c.getIdCliente()));
//            r.append(String.format("<td width=\"180px\"><label>%s</label></td>", c.getNombreMoneda()));
//            r.append(String.format("<td width=\"180px\"><label>%s</label></td>", c.getActiva()));
//            r.append(String.format("<td width=\"180px\"><label>%s</label></td>", c.getSaldoFinal()));
//            r.append("</tr>");
//        }
//        r.append("</tbody>");
//
//        r.append("</table>");
//        return r.toString();
//    }
    
    //metodo estatico para obtenerTabla de arriba
//    public static String obtenerTablaCuentas(ServicioCuenta instancia, String idCliente) {
//        return instancia.obtenerTablaCuentas(idCliente);
//    }
    
    public Optional<Cuenta> obtenerCuentaNumCuenta(String numCuenta) {
        Optional<Cuenta> cuenta = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.BUSCAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, numCuenta);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    cuenta = Optional.of(new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getDate("fecha_creacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_inicial"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("saldo_final")
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
        return cuenta;
    }
    
    public boolean validarCuentaNumCuenta(String numCuenta) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.BUSCAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, numCuenta);
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
//        ServicioCuenta su = new ServicioCuenta();
//        System.out.println(date);
//        List<Cuenta> cuentas = su.listarTodasCuentas();
//        int i = 0;
//        for (Cuenta u : cuentas) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//        }
    }
}
