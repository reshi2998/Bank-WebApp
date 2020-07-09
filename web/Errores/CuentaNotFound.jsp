<%-- 
    Document   : CuentaNotFound
    Created on : 23/04/2020, 04:10:04 PM
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
                    <h2 id="mensajeError">Cuenta no encontrada</h2><br>
                    <p class="mensajeInfo">
                        No existe una cuenta asociada al número de cuenta digitado.
                    </p>
                </div>
            </div>
    </body>
</html>
