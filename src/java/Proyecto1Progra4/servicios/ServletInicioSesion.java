
package Proyecto1Progra4.servicios;

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
public class ServletInicioSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter();
              
        String id = request.getParameter("username");
        String clave = request.getParameter("clave");


        if (id != null && !id.isEmpty() && clave != null && !clave.isEmpty()) { //si los campos contienen datos
            if(servicio.validarUsuario(id, clave)){ //si el usuario existe
                int rol = servicio.obtenerRol(id, clave); //obtiene el rol para saber a cual pagina redirigirlo
                if(rol == 0){ //si el rol es 0 es cliente
                    //se crea sesion de cliente guardando el username
                    HttpSession sesionCliente = request.getSession();
                    sesionCliente.setAttribute("user", id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/MenuCliente.jsp");   
                    dispatcher.forward(request, response);
                }
                else{ //si el rol es 1 es cjaero
                    //se crea sesion para cajero guardando el username
                    HttpSession sesionCajero = request.getSession();
                    sesionCajero.setAttribute("user", id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/MenuCajero.jsp");  
                    dispatcher.forward(request, response);
                } 
            }else { //Si la consulta del usuario devuelve false el usuario no existe
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/UserNotFound.jsp");  
                dispatcher.forward(request, response);
            }
        }else { //Si algun campo esta incompleto
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/DatosIncompletosIS.jsp");  
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

    private final ServicioUsuario servicio = new ServicioUsuario();
}
