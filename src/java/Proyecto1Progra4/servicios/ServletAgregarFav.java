
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.dao.ServicioCliente;
import Proyecto1Progra4.modelo.dao.ServicioCuenta;
import Proyecto1Progra4.modelo.dao.ServicioFavorita;
import Proyecto1Progra4.modelo.dao.ServicioUsuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletAgregarFav extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String cuenta = request.getParameter("cuenta");
        HttpSession sesion = request.getSession();
        String user = (String) sesion.getAttribute("user");
        
        if(cuenta != null && !cuenta.isEmpty()){
            if(servicioCuenta.validarCuentaNumCuenta(cuenta)){
                String id = servicioClient.obtenerId(user);
                servicioFav.insertarFav(id, cuenta);
                request.setAttribute("listaFav", servicioFav.listarCuentasFav(id));
                RequestDispatcher dispatcher = request.getRequestDispatcher("SeleccionarCuentasFav.jsp");
                dispatcher.forward(request, response);
            }
        } else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/CuentaNotFoundClient.jsp");
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

    private final ServicioFavorita servicioFav = new ServicioFavorita();
    private final ServicioCuenta servicioCuenta = new ServicioCuenta();
    private final ServicioUsuario servicioUser = new ServicioUsuario();
    private final ServicioCliente servicioClient = new ServicioCliente();
}
