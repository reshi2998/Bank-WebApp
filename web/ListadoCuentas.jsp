<%-- 
    Document   : ListadoCuentas
    Created on : 24/04/2020, 03:41:58 PM
    Author     : Josue
--%>

<%@page import="Proyecto1Progra4.modelo.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Proyecto1Progra4.modelo.dao.ServicioCuenta"%>
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
        <meta charset="UTF-8" />
        <title>Listado de cuentas</title>
        <link href="css/listadoCuentasStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <jsp:useBean class="Proyecto1Progra4.modelo.dao.ServicioCuenta" id="sc" scope="session"></jsp:useBean>
    <%
        ArrayList<Cuenta> lista = (ArrayList) request.getAttribute("listadoCuentas");
    %>
    <body>
        <div id="wrapper">
            <header>
                <h1>Búsqueda de cuentas por ID de cliente - Realizar depósito</h1>
                <nav>
                    <ul>
                        <li class="active">
                            <a href="MenuCajero.jsp">Volver al menú</a>
                        </li>
                    </ul>
                </nav>
            </header>
            <div id="contents">
                <nav id="navForms">
                    <ul>
                        <li>
                            <div class="form1">
                                <form action="ServletListadoCuentas" method="post">
                                    <table id="tablaForm1">
                                        <tbody>
                                            <tr>
                                                <td class="etiqueta">
                                                    <label class="label" for="id">ID del cliente</label>
                                                </td>
                                                <td class="campo">
                                                    <input type="text" id="id" class="entrada" placeholder="Identificación" name="id"/>
                                                </td>
                                                <td>
                                                    <input type="submit" class="btn" value="Buscar"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </li>
                        <li>
                            <%
                                try{
                                    boolean valida = (Boolean) request.getAttribute("validaForm2");
                                    if(valida){
                            %>
                            <div class="form2">
                                <form action="ServletBuscarCuenta" method="post">
                                    <table id="tablaForm2">   
                                        <tbody>
                                            <tr>
                                                <td class="etiqueta">
                                                    <label class="label" for="numCuenta">Número de cuenta</label>
                                                </td>
                                                <td class="campo">
                                                    <input type="text" id="numCuenta" class="entrada" placeholder="Copie y pegue el # aquí" name="numCuenta"/>
                                                </td>
                                                <td>
                                                    <input type="submit" class="btn" value="Buscar Cuenta"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>      
                                </form>
                            </div>
                            <%
                                    }
                                }catch(Exception e){
                                }   
                            %>
                        </li>
                    </ul>
                </nav>
                <section>
                    <div>
                        <table class="tablaCuentas">
                            <thead>
                                <tr>
                                    <th class="thTitulos">Número de cuenta</th>
                                    <th class="thTitulos">Tipo de cuenta</th>
                                    <th class="thTitulos">ID de cliente</th>
                                    <th class="thTitulos">Moneda</th>
                                    <th class="thTitulos">Activa</th>
                                    <th class="thTitulos">Saldo Actual</th>
                                </tr>
                            </thead>
                            <%
                                try{
                                    for(Cuenta c : lista){
                            %>
                            <tr>
                                <td class="tdDatos"><%= c.getNumCuenta()%></td>
                                <td class="tdDatos"><%= c.getIdTipoCuenta()%></td>
                                <td class="tdDatos"><%= c.getIdCliente()%></td>
                                <td class="tdDatos"><%= c.getNombreMoneda()%></td>
                                <td class="tdDatos"><%= c.getActiva()%></td>
                                <td class="tdDatos"><%= c.getSaldoFinal()%></td>
                            </tr>
                            <%
                                    }
                                }catch(Exception e){
                                }
                            %>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
