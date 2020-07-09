
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josue
 */
public class ServletListaCuentasClient extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession sesion = request.getSession();
        String usuario = String.valueOf(sesion.getAttribute("user"));
        String id = servicioClient.obtenerId(usuario);
        ArrayList<Cuenta> lista = servicioCuenta.listarCuentasPorId(id);
        if(lista == null || lista.isEmpty()){
            request.setAttribute("noLista", true); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoCuentasCliente.jsp");
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("noLista", false); 
            request.setAttribute("listadoCuentas", lista); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoCuentasCliente.jsp");
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
    private final ServicioCliente servicioClient = new ServicioCliente();
}
