
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.Movimiento;
import Proyecto1Progra4.modelo.dao.ServicioMovimiento;
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
public class ServletListaMovCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String numCuenta = request.getParameter("numC");
        ArrayList<Movimiento> lista = servicio.listarMovimientos(numCuenta);
        if(lista == null || lista.isEmpty()){
            request.setAttribute("noLista", true); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoCuentasCliente.jsp");
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("noLista", false); 
            request.setAttribute("listadoMovimientos", lista); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListadoMovCliente.jsp");
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

    private final ServicioMovimiento servicio = new ServicioMovimiento();
}
