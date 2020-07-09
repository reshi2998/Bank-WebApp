<%-- 
    Document   : MontoMenorASaldo
    Created on : 24/04/2020, 11:32:20 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Monto incorrecto</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        String saldoActual = String.valueOf(request.getAttribute("saldoActual"));
    %>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="BuscarCuentaRetiro.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Monto a retirar incorrecto</h2><br>
                    <p class="mensajeInfo">
                        EL monto que desea retirar es mayor asu saldo actual.<br><br>
                        Su saldo actual es de <%=saldoActual%>, intente con un monto menor por favor.
                    </p>
                </div>
            </div>
    </body>
</html>
