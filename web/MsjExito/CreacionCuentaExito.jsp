<%-- 
    Document   : CreacionCuentaExito
    Created on : 26/04/2020, 05:34:37 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String cuenta = request.getParameter("numCuenta");
        String monto = request.getParameter("monto");
    %>
    <head>
        <meta charset="UTF-8">
        <title>Deposito Existoso</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="MenuCajero.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Creación de cuenta exitosa!!!</h2><br>
                    <p class="mensajeInfo">
                        La cuenta se ha creado y ligado al usuario exitosamente.
                    </p>
                </div>
            </div>
    </body>
</html>
