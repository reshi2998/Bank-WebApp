<%-- 
    Document   : BuscarClienteCrearCuenta
    Created on : 18/04/2020, 10:29:05 PM
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
        <title>Buscar cliente</title>
         <link href="css/listadoCuentasStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <h1>Búsque una cliente por su número de identificación</h1>
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
                                <form action="ServletBuscarCliente" method="post">
                                    <table id="tablaForm1">
                                        <tbody>
                                            <tr>
                                                <td class="etiqueta">
                                                    <label class="label" for="idCliente">Número de identificación</label>
                                                </td>
                                                <td class="campo">
                                                    <input type="text" id="idCliente" class="entrada" name="idCliente"/>
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
                    </ul>
                </nav>
            </div>
        </div>
    </body>
</html>
