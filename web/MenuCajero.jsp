<%-- 
    Document   : MenuCajero
    Created on : 11/04/2020, 09:43:56 AM
    Author     : Josue
--%>

<%@page import="java.util.Optional"%>
<%@page import="Proyecto1Progra4.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <title>Menu de Cajero</title>
        <link href="css/menuClienteStyle.css" rel="stylesheet" type="text/css"/>
        <!--<link rel="stylesheet" href="css/menuClienteStyle.css?v=0.0.0">-->
    </head>
    <body>
        <div id="wrapper">
            <%
                HttpSession sesionCajero = request.getSession(true);
                String usuario = String.valueOf(sesionCajero.getAttribute("user"));
            %>
            <header id="barraMenu">
                <input type="checkbox" id="btnMenu">
                <label id="icono" for="btnMenu"><img src="css/imagenes/iconoMenu.png" alt=""/></label>
                <nav class="menu">
                    <ul>
                        <li>Inicio</a></li>
                        <li>Quienes somos</a></li>
                        <li class="submenu"><a href="">Servicios<span><img src="css/imagenes/flechaAbajo.png" alt=""/></span></a>
                            <ul>
                                <%
                                    boolean redireccion = false;
                                    request.setAttribute("redireccion", false);
                                %>
                                <li><a href="RegistrarUsuario.jsp">Crear nuevo usuario</a></li>
                                <li><a href="BuscarClienteCrearCuenta.jsp">Abrir cuenta</a></li>
                                <li><a href="BuscarCuentaDeposito.jsp">Realizar depósito (buscar por # cuenta)</a></li>
                                <li><a href="ListadoCuentas.jsp">Realizar depósito (bucar por ID)</a></li>
                                <li><a href="BuscarCuentaRetiro.jsp">Realizar retiro (buscar por # cuenta)</a></li>
                                <li><a href="ListadoCuentasRetiro.jsp">Realizar retiro (bucar por ID)</a></li>
                                <li><a href="AplicarIntereses.jsp">Aplicar intereses a todas las cuentas</a></li>
                            </ul>
                        </li>
                        <li>Contáctenos</a></li>
                        <li id="itemDerecho"><a href=""><%= usuario%><span><img src="css/imagenes/flechaAbajo.png" alt=""/></span></a>
                            <ul>
                                <!-- Lo envio al servlet que cierra la sesion -->
                                <li><a href="ServletCerrarSesion">Cerrar sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </header>
            <div id="contents">
                <div class="info">
                    <nav>
                        <ul>
                            <li class="opciones"><a href="RegistrarUsuario.jsp">Crear nuevo usuario</a></li>
                            <li class="opciones"><a href="BuscarClienteCrearCuenta.jsp">Abrir cuenta</a></li>
                            <li class="opciones"><a href="ListadoCuentas.jsp">Realizar depósito (bucar por ID de cliente)</a></li>
                            <li class="opciones"><a href="BuscarCuentaDeposito.jsp">Realizar depósito (buscar por No. cuenta)</a></li>
                            <li class="opciones"><a href="ListadoCuentasRetiro.jsp">Realizar retiro (bucar por ID de cliente)</a></li>
                            <li class="opciones"><a href="BuscarCuentaRetiro.jsp">Realizar retiro (buscar por No. cuenta)</a></li>
                            <li class="opciones"><a href="AplicarIntereses.jsp">Aplicar intereses a todas las cuentas</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </body>
</html>
