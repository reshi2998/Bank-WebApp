<%-- 
    Document   : DatosIncompletosMenuCajero
    Created on : 23/04/2020, 02:23:56 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Campos incompletos</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="MenuCajero.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Datos incompletos</h2><br>
                    <p class="mensajeInfo">
                        Por favor, complete todos los datos solicitados.
                    </p>
                </div>
            </div>
    </body>
</html>
