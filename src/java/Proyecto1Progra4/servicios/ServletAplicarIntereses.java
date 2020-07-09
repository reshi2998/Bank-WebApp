
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.Cuenta;
import Proyecto1Progra4.modelo.dao.ServicioCuenta;
import Proyecto1Progra4.modelo.dao.ServicioIntereses;
import Proyecto1Progra4.modelo.dao.ServicioMovimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josue
 */
public class ServletAplicarIntereses extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        String detalle = "Acreditación de intereses";
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        ArrayList<Cuenta> lista = servicioCuenta.listarTodasCuentas();

        for(Cuenta c : lista){
            String numCuenta = c.getNumCuenta();
            double tasa = servicioInteres.obtenerTasaInteres(c.getIdTipoCuenta(), c.getNombreMoneda());
            double saldoActual = c.getSaldoFinal();
            double montoInteres = saldoActual * tasa;
            double nuevoSaldo = saldoActual + montoInteres;
            servicioCuenta.modificarSaldoFecha(date, nuevoSaldo, numCuenta);
            servicioMovimiento.insertarMovimiento(numCuenta, montoInteres, date, 1, detalle);
        }
        request.setAttribute("lisadoMoves", servicioMovimiento.listarMovimientosDetalle(detalle));
        request.setAttribute("listadoCuentas", servicioCuenta.listarTodasCuentas());
        RequestDispatcher dispatcher = request.getRequestDispatcher("AplicarIntereses.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private final ServicioCuenta servicioCuenta = new ServicioCuenta();
    private final ServicioIntereses servicioInteres = new ServicioIntereses();
    private final ServicioMovimiento servicioMovimiento = new ServicioMovimiento();
}
