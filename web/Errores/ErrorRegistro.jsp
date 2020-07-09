<%-- 
    Document   : Error
    Created on : 12/04/2020, 02:53:05 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Error</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="RegistrarUsuario.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Ups!! Ha ocurrido un error inesperado en el registro</h2><br>
                    <p class="mensajeInfo">
                        Por favor, regrese a la página anterior e inténtelo de nuevo.
                    </p>
                </div>
            </div>
    </body>
</html>
