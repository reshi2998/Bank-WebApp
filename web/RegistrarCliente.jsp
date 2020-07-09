<%-- 
    Document   : RegistrarCliente
    Created on : 13/04/2020, 10:46:52 AM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //valida si hay sesion iniciada
    try{
        String user = (String) session.getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }catch(Exception e){
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Cliente</title>
        <link href="css/registrarClienteStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        String idU = (String) request.getAttribute("id_usuario");
    %>
    <body>
        <div id="wrapper">
            <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar">X</label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeExito">Registro de usuario exitoso!</h2><br><br>
                    <p class="mensajeInfo">
                        A continuación registre los datos del cliente (o cajero según su rol) que se le asignarán al 
                        usuario anteriormente creado.
                    </p>
                </div>
            </div>
            <form action="ServletRegistroCliente" method="post">
                <p id="tituloForm">Registre un Nuevo Cliente</p>
                <hr>
                <br/><br/>
                <label id="labelIdCliente">Identificación</label>
                <br/><br/>
                <input type="text" autocomplete="off" class="entrada" name="idCliente">
                <br/><br/>
                <label id="labelIdUsuario">Usuario</label>
                <br/><br/>
                <input type="text" class="entrada" value="<%=idU%>" readonly name="idUsuario">
                <br/><br/>
                <label id="labelApellidos">Apellidos</label>
                <br/><br/>
                <input type="text" autocomplete="off" class="entrada" name="apellidos">
                <br/><br/>
                <label id="labelNombre">Nombre</label>
                <br/><br/>
                <input type="text" autocomplete="off" class="entrada" name="nombre">
                <br/><br/>
                <label id="labelTelefono">Teléfono</label>
                <br/><br/>
                <input type="text" autocomplete="off" class="entrada" name="telefono">
                <br/><br/>
                <input type="submit" id="btnRegistrar" value="Registrar Cliente">
            </form>
        </div>    
    </body>
</html>
