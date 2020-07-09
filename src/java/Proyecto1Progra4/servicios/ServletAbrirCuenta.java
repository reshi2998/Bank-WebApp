
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.dao.ServicioCuenta;
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
public class ServletAbrirCuenta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String numCuenta = request.getParameter("numCuenta");
        int tipoCuenta = Integer.parseInt(request.getParameter("tipoCuenta"));
        String idCliente = request.getParameter("idCliente");
        String moneda = request.getParameter("moneda");
        Date fechaC = Date.valueOf(request.getParameter("fechaC"));
        Double limite = Double.parseDouble(request.getParameter("limiteTransf"));
        int activa = Integer.parseInt(request.getParameter("activa"));
        double saldoInicial = Double.parseDouble(request.getParameter("saldoInicial"));
        double saldoFinal = Double.parseDouble(request.getParameter("saldoFinal"));
        
        if((numCuenta != null) && !numCuenta.isEmpty() && (tipoCuenta == 1 || tipoCuenta == 2 || tipoCuenta == 3) &&
                (idCliente != null) && !idCliente.isEmpty() && (moneda != null) && !moneda.isEmpty() && (fechaC != null) &&
                (limite != 0) && (activa == 1) && (saldoInicial == 0) && (saldoFinal == 0)){
            boolean creacion = servicio.insertarCuenta(numCuenta, tipoCuenta, idCliente, moneda, fechaC, limite, activa, 
                    saldoInicial, fechaC, saldoFinal);
            if(creacion == true) {
                //enviar validacion para mostrar modal "creacion exitosa"
                RequestDispatcher dispatcher = request.getRequestDispatcher("MsjExito/CreacionCuentaExito.jsp");
                dispatcher.forward(request, response);
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/ErrorRegistro.jsp");
                dispatcher.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/CamposIncompletos.jsp");
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

    private final ServicioCuenta servicio = new ServicioCuenta();
}
