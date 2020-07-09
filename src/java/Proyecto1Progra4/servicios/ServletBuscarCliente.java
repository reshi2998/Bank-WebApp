
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.dao.ServicioCliente;
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
public class ServletBuscarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        String id = request.getParameter("idCliente");
        
        if(id != null && !id.isEmpty()){
            if(servicio.validarClienteID(id)){
                request.setAttribute("identificacion", id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/AbrirCuenta.jsp");
                dispatcher.forward(request, response);
            }else {
                //desplegar mensaje de que  no existe cliente
                request.setAttribute("redireccion", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/ClienteNotFound.jsp");
                dispatcher.forward(request, response);
            }
        }else {
            response.sendRedirect("/Errores/CamposIncompletos.jsp");
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

    private final ServicioCliente servicio = new ServicioCliente();
}
