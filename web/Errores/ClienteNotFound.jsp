<%-- 
    Document   : ClienteNoEncontrado
    Created on : 19/04/2020, 12:30:51 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cliente Not Found</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="MenuCajero.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Cliente no encontrado</h2><br>
                    <p class="mensajeInfo">
                        Se le recomienda:
                    </p><br>
                    <ul id="listaInfo">
                        <li>En caso de haber digitado un ID incorrecto, cerrar esta ventana e intentar buscarlo de nuevo.</li>
                        <li>Puede que la persona no esté registrada en el sistema, si desea puede 
                            <a href="RegistrarUsuario.jsp" id="urlCrear">crear un usuario</a>  y registrarlo como cliente.
                        </li>
                    </ul>
                </div>
            </div>
    </body>
</html>
