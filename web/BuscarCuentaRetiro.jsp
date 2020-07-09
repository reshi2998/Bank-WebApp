<%-- 
    Document   : BuscarCuentaRetiro
    Created on : 24/04/2020, 11:10:41 PM
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
        <title>Buscar cuenta</title>
    </head>
    <body>
        <div id="wrapper">
            
            <form action="ServletBuscarCuentaRet" method="post">
                <p id="tituloForm">Por favor busque una cuenta</p>
                    <table id="tablaForm">
                        <tbody>
                            <tr>
                                <td class="etiqueta">
                                    <label class="label" for="numCuenta">Número de cuenta</label>
                                </td>
                                <td class="campo">
                                    <input type="text" id="numCuenta" class="entrada" name="numCuenta"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                <input type="submit" id="btnBuscarCueta" value="Buscar"/>
            </form>
        </div>
    </body>
</html>
</html>
