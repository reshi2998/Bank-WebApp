<%-- 
    Document   : MenuCliente
    Created on : 07/04/2020, 10:42:34 AM
    Author     : Josue
--%>

<%@page import="Proyecto1Progra4.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/menuClienteStyle.css" rel="stylesheet" type="text/css"/>

<%
    /*
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store"); 
    response.setDateHeader("Expires", 0); 
    response.setHeader("Pragma","no-cache"); 
    */
    try{
        String user = (String) session.getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }catch(Exception e){
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Menu de Cliente</title>
    </head>
    <body>
        <div id="wrapper">
            <%
                HttpSession sesionCliente = request.getSession(true);
                String usuario = String.valueOf(sesionCliente.getAttribute("user"));
            %>
            <header id="barraMenu">
                <input type="checkbox" id="btnMenu">
                <label id="icono" for="btnMenu"><img src="css/imagenes/iconoMenu.png" alt=""/></label>
                <nav class="menu">
                    <ul>
                        <li><a href="MenuCliente.jsp">Inicio</a></li>
                        <li>Quienes somos</li>
                        <li class="submenu"><a href="">Servicios<span><img src="css/imagenes/flechaAbajo.png" alt=""/></span></a>
                            <ul>
                                <li><a href="ServletListaCuentasClient">Listar cuentas</a></li>
                            </ul>
                        </li>
                        <li><a href="">Contáctenos</a></li>
                        <li class="submenu"><a href=""><%= usuario%><span><img src="css/imagenes/flechaAbajo.png" alt=""/></span></a>
                            <ul>
                                <li><a href="ServletCerrarSesion">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </header>
            <div id="contents">
                <div class="info">
                    <nav>
                        <ul>
                            <li class="opciones"><a href="ServletListaCuentasClient">Listar cuentas</a></li>
                            <li class="opciones"><a href="SeleccionarCuentasFav.jsp">Cuentas favoritas</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </body>  
</html>
