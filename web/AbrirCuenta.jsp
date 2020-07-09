<%-- 
    Document   : AbrirCuenta
    Created on : 14/04/2020, 05:21:43 PM
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
        <title>Apertura de cuentas</title>
        <link href="css/aperturaCuentaStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        //numero de cuenta random
        String num1 = String.valueOf((int) (Math.random() * (999999999 - 100000000) + 100000000));
        String num2 = String.valueOf((int) (Math.random() * (99999999 - 10000000) + 10000000)); 
        String numCuentaRand = num1 + num2;
        
        //fecha actual en formato yy-mm-dd
        java.sql.Date fechaActual = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        
        //valor de cuenta activa - 0 para inactiva - 1 para activa
        //será 1 porque al crear la cuenta obligatoriamente estará activa
        String numActiva = "1";
        
        //saldo inicial según enunciado será 0
        //saldo final también será 0 porque apenas se está creando la cuenta
        String saldoIniFin = "0";
        
        //ID digitado en la busqueda de cliente por id
        String id = String.valueOf(request.getAttribute("identificacion"));
    %>
    <body>
        <div id="wrapper">
            <form action="ServletAbrirCuenta" method="post">
                <p id="tituloForm">Creación de nueva cuenta</p>
                <table id="tablaForm">
                    <tbody>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="numCuenta">Número de cuenta</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="numCuenta" class="entrada" value=<%=numCuentaRand%> readonly name="numCuenta"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="tipoCuenta">Tipo de cuenta</label>
                            </td>
                            <td class="campo">
                                <select id="tipoCuenta" name="tipoCuenta">
                                    <option value="1">Cuenta corriente</option>
                                    <option value="2">Cuenta de ahorros</option>
                                    <option value="3">Cuenta especial</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="idCliente">ID de cliente</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="idCliente" class="entrada" value=<%=id%> readonly name="idCliente"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="moneda">Tipo de moneda</label>
                            </td>
                            <td class="campo">
                                <select id="moneda" name="moneda">
                                    <option value="CRC">Colón</option>
                                    <option value="USD">Dólar EEUU</option>
                                    <option value="EUR">Euro</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="fechaC">Fecha de creación</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="fechaC" class="entrada" value=<%=fechaActual%> readonly name="fechaC"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="limiteTransf">Límite de transferencia diaria</label>
                            </td>
                            <td class="campo">
                                <select id="limiteTransf" name="limiteTransf">
                                    <option value="50000">50 000</option>
                                    <option value="100000">100 000</option>
                                    <option value="500000">500 000</option>
                                    <option value="1000000">1 000 000</option>
                                    <option value="1500000">1 500 000</option>
                                    <option value="2000000">2 000 000</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="activa">Cuenta activa</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="activa" class="entrada" value=<%=numActiva%> readonly name="activa"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="saldoInicial">Saldo inicial</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="saldoInicial" class="entrada" value=<%=saldoIniFin%> readonly name="saldoInicial"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="etiqueta">
                                <label class="label" for="saldoFinal">Saldo final</label>
                            </td>
                            <td class="campo">
                                <input type="text" id="saldoFinal" class="entrada" value=<%=saldoIniFin%> readonly name="saldoFinal"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" id="btnCrearCuenta" value="Crear cuenta"/>
            </form>
        </div>
    </body>
</html>
