<%-- 
    Document   : SeleccionarCuentasFav
    Created on : 26/04/2020, 09:13:30 PM
    Author     : Josue
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Proyecto1Progra4.modelo.Favorita"%>
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
        ArrayList<Favorita> lista = (ArrayList) request.getAttribute("listaFav");
    %>
    <body>
        <div id="wrapper">
            <header>
                <h1>Vinculación de cuentas favoritas</h1>
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
                                <form action="ServletAgregarFav" method="post">
                                    <table id="tablaForm1">
                                        <tbody>
                                            <tr>
                                                <td class="etiqueta">
                                                    <label class="label" for="cuenta">Número de cuenta a vincular</label>
                                                </td>
                                                <td class="campo">
                                                    <input type="text" id="cuenta" class="entrada" placeholder="Identificación" name="cuenta"/>
                                                </td>
                                                <td>
                                                    <input type="submit" class="btn" value="Seleccionar"/>
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
                                    <th class="thTitulos">ID cliente</th>
                                    <th class="thTitulos">Numero cuenta</th>
                                </tr>
                            </thead>
                            <%
                                try{
                                    for(Favorita f : lista){
                            %>
                            <tr>
                                <td class="tdDatos"><%= f.getIdCliente()%></td>
                                <td class="tdDatos"><%= f.getNumCuenta()%></td>
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
