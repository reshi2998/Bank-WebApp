
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.dao.ServicioCuenta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josue
 */
public class ServletBuscarCuentaRet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String cuenta = request.getParameter("numCuenta");
        
        if(cuenta != null && !cuenta.isEmpty()){
            if(servicio.validarCuentaNumCuenta(cuenta)){
                request.setAttribute("cuenta", cuenta);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Retiro.jsp");
                dispatcher.forward(request, response);
            }else {
                //desplegar mensaje de que  no existe cuenta
                //request.setAttribute("redireccion", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/CuentaNotFound.jsp");
                dispatcher.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/DatosIncompletosBuscarCuenta.jsp");  
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
    }// </editor-fold>

    private final ServicioCuenta servicio = new ServicioCuenta();
}
