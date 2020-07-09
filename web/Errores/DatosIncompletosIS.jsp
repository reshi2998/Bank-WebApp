<%-- 
    Document   : CamposIncompletos
    Created on : 12/04/2020, 02:55:58 PM
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
            <label for="cerrar" id="btnCerrar"><a href="index.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Datos incompletos</h2><br>
                    <p class="mensajeInfo">
                        Por favor, complete todos los datos solicitados (usuario y contraseña).<br><br>
                        (Para efectos de este proyecto ingrese con la clave de acceso siempre).
                    </p>
                </div>
            </div>
    </body>
</html>
