<%-- 
    Document   : Deposito
    Created on : 23/04/2020, 02:37:16 PM
    Author     : Josue
--%>

<%@page import="java.util.Calendar"%>
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
        <title>Realizar Depósito</title>
        <link href="css/aperturaCuentaStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        //numero de cuenta buscado
        String cuenta = String.valueOf(request.getAttribute("cuenta"));
        
        //fecha actual en formato yy-mm-dd
        java.sql.Date fechaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        //valor para atribut aplicado, 1 porque si el deposito se realiza pasa a ser aplicado
        String apli = "1";
    %>
    <body>
        <div id="wrapper">
            <form action="ServletDepositar" method="post">
                <p id="tituloForm">Realizar Depósito</p>
                <table id="tablaForm">
                    <tbody>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="numCuenta">Número de cuenta</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="numCuenta" class="entrada" value=<%=cuenta%> readonly name="numCuenta"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="monto">Monto a depositar</label>
                            </td>
                            <td class="campo">
                                <input type="number" id="monto" class="entrada" min="1" name="monto"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="fecha">Fecha de trámite</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="fecha" class="entrada" value=<%=fechaActual%> readonly name="fecha"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="aplicado">Aplicado</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="aplicado" class="entrada" value=<%=apli%> readonly name="aplicado"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="detalle">Detalle</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="detalle" class="entrada" name="detalle"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" id="btnDeposito" value="Realizar Depósito"/>
            </form>
        </div>
    </body>
</html>
