
package Proyecto1Progra4.servicios;

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
public class ServletRegistroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idU = request.getParameter("username");
        String claveA = request.getParameter("claveA");
        int claveV = 1;
        int rol = Integer.parseInt(request.getParameter("rol"));
        int banderaModal;
        
        if ((idU != null) && !idU.isEmpty() && (claveA != null) && !claveA.isEmpty() && (claveV != 0) && (rol == 1 || rol == 0)){
            boolean insercion = servicio.insertarUsuario(idU, claveA, claveV, rol);
            if(insercion == true){
                request.setAttribute("id_usuario", idU);
                //puede servir como condicion de acceso en RegistrarCiente de que ya se registro el usuario 
                banderaModal = 1;
                request.setAttribute("ventanaModal", banderaModal);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistrarCliente.jsp");
                dispatcher.forward(request, response);
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/ErrorRegistro.jsp");
                dispatcher.forward(request, response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Errores/DatosIncompletosRU.jsp");
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
