<%-- 
    Document   : index
    Created on : 10/04/2020, 03:05:25 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Banco de Imre</title>
        <link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        //arreglar esto
        if(request.getParameter("cerrar") != null){
            session.invalidate();
        }
    %>
    <body>
        <div id="wrapper">
            <form action="ServletInicioSesion" method="post">
                <p id="tituloForm">INICIE SESIÓN EN BANCO IMRE</p>
                <hr>
                <br/><br/>
                <label id="labelUsuario">Usuario</label>
                </br></br>
                <input type="text" autocomplete="off" class="entrada" name="username"/>
                </br></br>
                <label id="labelClave">Clave de Acceso</label>
                </br></br>
                <input type="password" class="entrada" name="clave"/>
                </br></br>
                <input type="submit" id="btnInicioSesion" value="Iniciar Sesión"/>  
            </form>
        </div>
    </body>
</html>
