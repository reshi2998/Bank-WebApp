<%-- 
    Document   : ListadoMovCliente
    Created on : 26/04/2020, 10:43:43 AM
    Author     : Josue
--%>

<%@page import="Proyecto1Progra4.modelo.Movimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Listado de movimiento</title>
        <link href="css/listadoCuentasStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        ArrayList<Movimiento> lista = (ArrayList) request.getAttribute("listadoMovimientos");
        String numCuenta = request.getParameter("numC");
    %>
    <body>
        <div id="wrapper">
            <header>
                <h1>Lista de movimientos</h1><br>
                <%
                    boolean nolista = (Boolean) request.getAttribute("noLista");
                    if(nolista == true){
                %>
                <h3>No hay movimientos registrados para la cuenta <%=numCuenta%>.</h3><br>
                <%
                    }else {
                %>
                <h3>Movimientos registrados para la cuenta <%=numCuenta%></h3>
                <nav>
                    <ul>
                        <li class="active">
                            <a href="MenuCliente.jsp">Volver</a>
                        </li>
                    </ul>
                </nav>
            </header>
            <div id="contents">
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
                                    for(Movimiento m : lista){
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
                            <%
                                } //cierre del else
                            %>    
        </div>
    </body>
</html>
