<%-- 
    Document   : RegistrarUsuario
    Created on : 10/04/2020, 05:59:49 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //valida si hay sesion iniciada
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
        <title>Registro de Usuario</title>
        <link href="css/registrarUsuarioStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar">X</label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeExito">Información para registro de usuario</h2><br>
                    <p class="mensajeInfo">
                        En el campo "Rol" se le solicita el nivel de usuario, el cual puede ser:
                    </p><br>
                    <ul id="listaInfo">
                        <li>0 para cliente.</li>
                        <li>1 para cajero.</li>
                    </ul>
                </div>
            </div>
            <form action="ServletRegistroUsuario" method="post">
                <p id="tituloForm">Registre un Nuevo Usuario</p>
                <hr>
                <br/><br/>
                <label id="labelUsuario">Usuario</label>
                <br/><br/>
                <input type="text" autocomplete="off" class="entrada" name="username">
                <br/><br/>
                <label id="labelClave">Clave de acceso</label>
                <br/><br/>
                <input type="text" class="entrada" name="claveA">
                <br/><br/>
                <label id="labelRol">Rol</label>
                <br/><br/>
                <input type="number" id="entradaRol" name="rol" value="0" min="0" max="1">
                <br/><br/>
                <input type="submit" id="btnRegistrar" value="Registrar Usuario">
            </form>
        </div>          
    </body>
</html>
