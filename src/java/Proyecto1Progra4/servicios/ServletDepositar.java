
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.dao.ServicioCuenta;
import Proyecto1Progra4.modelo.dao.ServicioMovimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josue
 */
public class ServletDepositar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String numCuenta = request.getParameter("numCuenta");
        double monto = Double.parseDouble(request.getParameter("monto"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        int aplicado = Integer.parseInt(request.getParameter("aplicado"));
        String detalle = request.getParameter("detalle");
        
        if(numCuenta != null && !numCuenta.isEmpty() && (monto > 0) && fecha != null && (aplicado == 1 || aplicado == 0) &&
                detalle != null && !detalle.isEmpty()){
            double saldoActual = servicioCuenta.obtenerSaldoActual(numCuenta);
            double saldoNuevo = saldoActual + monto;
            servicioCuenta.modificarSaldoFecha(fecha, saldoNuevo, numCuenta);
            servicioMov.insertarMovimiento(numCuenta, monto, fecha, aplicado, detalle);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/MsjExito/DepositoExitoso.jsp");  
            dispatcher.forward(request, response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/DatosIncompletosDeposito.jsp");  
            dispatcher.forward(request, response);
        }
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
    }

    private final ServicioCuenta servicioCuenta = new ServicioCuenta();
    private final ServicioMovimiento servicioMov = new ServicioMovimiento();
}
