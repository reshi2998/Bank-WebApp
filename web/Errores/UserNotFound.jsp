<%-- 
    Document   : UserNotFound
    Created on : 22/04/2020, 11:32:28 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Not Found</title>
        <link href="css/ClienteNotFoundStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="index.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Usuario no encontrado</h2><br>
                    <p class="mensajeInfo">
                        Usuario o contraseña incorrectos.<br>Se le recomienda:
                    </p><br>
                    <ul id="listaInfo">
                        <li>Intentar iniciar sesión de nuevo.</li>
                        <li>Si aún no es cliente de Banco Imre, favor dirigirse a nuestra sucursal
                            más cercana y solicitar que se le registre como cliente.<br>
                            (Para efectos de la revisión del proyecto se habilita la opcion de registrarse para eviar insertar
                            datos quemados en la base de datos).
                        </li>
                    </ul>
                </div>
            </div>
    </body>
</html>
