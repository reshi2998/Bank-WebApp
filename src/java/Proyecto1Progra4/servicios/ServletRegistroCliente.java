
package Proyecto1Progra4.servicios;

import Proyecto1Progra4.modelo.dao.ServicioCliente;
import Proyecto1Progra4.modelo.dao.ServicioUsuario;
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
public class ServletRegistroCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("idCliente");
        String idUsuario = request.getParameter("idUsuario");
        String apellidos = request.getParameter("apellidos");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        
        if ((id != null) && !id.isEmpty() && (idUsuario != null) && !idUsuario.isEmpty() && (apellidos != null) && 
                !apellidos.isEmpty() && (nombre != null) && !nombre.isEmpty() && (telefono != null) && !telefono.isEmpty()){
            boolean insercion = servicio.insertarCliente(id, idUsuario, apellidos, nombre, telefono);
            if(insercion == true){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/MenuCajero.jsp");
                dispatcher.forward(request, response);
            }else {
                //como ocurrio un error en el registro de cliente debo eliminar el usuario que debia ser ligado a dicho cliente
                servicioUsuario.eliminarUsuario(idUsuario); 
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/ErrorRegistro.jsp");
                dispatcher.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/DatosIncompletosRC.jsp");
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

    private final ServicioCliente servicio = new ServicioCliente();
    private final ServicioUsuario servicioUsuario = new ServicioUsuario();
}
