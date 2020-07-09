
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.Cuenta;
import Proyecto1Progra4.modelo.dao.ServicioCliente;
import Proyecto1Progra4.modelo.dao.ServicioCuenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josue
 */
public class ServletListadoCuentasRet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        
        if(id != null && !id.isEmpty()){
            if(servicioCliente.validarClienteID(id)){ //si el cliente existe
                //listarCuentasPorID devuelve un arraylist de cuentas 
                ArrayList<Cuenta> lista = servicioCuenta.listarCuentasPorId(id);
                if(lista == null || lista.isEmpty()){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/NoListaCuentas.jsp");
                    dispatcher.forward(request, response);
                }else {
                    request.setAttribute("listadoCuentas", lista); 
                    //para validar y se despligue otro form (para buscar numero de cuenta)
                    request.setAttribute("validaForm2", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoCuentasRetiro.jsp");
                    dispatcher.forward(request, response);         
                }                
            }else { //si el cliente no existe
                RequestDispatcher dispatcher = request.getRequestDispatcher("Errores/CuentaNotFound.jsp");
                dispatcher.forward(request, response);
            }
        }else { //si no digito la identificacion
            RequestDispatcher dispatcher = request.getRequestDispatcher("Errores/DatosIncompletosList.jsp");
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

    private final ServicioCuenta servicioCuenta = new ServicioCuenta();
    private final ServicioCliente servicioCliente = new ServicioCliente();
}
