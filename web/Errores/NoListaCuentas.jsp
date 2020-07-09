<%-- 
    Document   : NoListaCuentas
    Created on : 26/04/2020, 09:52:07 AM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List Npt Found</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="MenuCajero.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">No se encontraron cuentas</h2><br>
                    <p class="mensajeInfo">
                        No existen cuentas ligadas a la identificación que digitó.<br>
                        Abra una nueva cuenta para este cliente.
                    </p>
                </div>
            </div>
    </body>
</html>
