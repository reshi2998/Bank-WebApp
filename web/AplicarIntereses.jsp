<%-- 
    Document   : AplicarIntereses
    Created on : 26/04/2020, 03:24:11 PM
    Author     : Josue
--%>

<%@page import="Proyecto1Progra4.modelo.Movimiento"%>
<%@page import="Proyecto1Progra4.modelo.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
        ArrayList<Cuenta> listaC = (ArrayList) request.getAttribute("listadoCuentas");
        ArrayList<Movimiento> listaM = (ArrayList) request.getAttribute("lisadoMoves");
    %>
    <body>
        <div id="wrapper">
            <header>
                <h1>Acreditación de intereses</h1>
                <h3>Lo intereses se aplicarán a todas las cuentas existentes y se desplegará la lista de cuentas con su respectivo interés.</h3>
                <nav>
                    <ul>
                        <li class="active">
                            <a href="MenuCajero.jsp">Cancelar y volver</a>
                        </li>
                    </ul>
                </nav>
            </header>
            <div id="contents">
                <nav id="navForms">
                    <ul>
                        <li>
                            <div class="form1">
                                <form action="ServletAplicarIntereses" method="post">
                                    <table id="tablaForm1">
                                        <tbody>
                                            <tr>
                                                <td class="etiqueta">
                                                    <label class="label">Presione para aplicar intereses</label>
                                                </td>
                                                <td>
                                                    <input type="submit" class="btn" value="Aplicar"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
                            </div>
                        </li>
                    </ul>
                </nav>
                <section>
                    <div>
                        <table class="tablaCuentas">
                            <thead>
                                <tr>
                                    <th class="thTitulos">Número de cuenta</th>
                                    <th class="thTitulos">ID de cliente</th>
                                    <th class="thTitulos">Moneda</th>
                                    <th class="thTitulos">Saldo Actual</th>
                                </tr>
                            </thead>
                            <%
                                try{
                                    for(Cuenta c : listaC){
                            %>
                            <tr>
                                <td class="tdDatos"><%= c.getNumCuenta()%></td>
                                <td class="tdDatos"><%= c.getIdCliente()%></td>
                                <td class="tdDatos"><%= c.getNombreMoneda()%></td>
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
                <section>
                    <div>
                        <table class="tablaCuentas">
                            <thead>
                                <tr>
                                    <th class="thTitulos">Movimiento</th>
                                    <th class="thTitulos">Número de cuenta</th>
                                    <th class="thTitulos">Monto del movimiento</th>
                                    <th class="thTitulos">Fecha</th>
                                    <th class="thTitulos">Detalle</th>
                                </tr>
                            </thead>
                            <%
                                try{
                                    for(Movimiento m : listaM){
                            %>
                            <tr>
                                <td class="tdDatos"><%= m.getIdMovimiento()%></td>
                                <td class="tdDatos"><%= m.getNumCuenta()%></td>
                                <td class="tdDatos"><%= m.getMonto()%></td>
                                <td class="tdDatos"><%= m.getFecha()%></td>
                                <td class="tdDatos"><%= m.getDetalle()%></td>
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
