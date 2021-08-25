<%-- 
    Document   : perfil-cliente
    Created on : 28/07/2021, 07:53:09
    Author     : uliss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../../parts/meta.jsp" %>
        <title>Carolina Pâtisserie | E-commerce Website Design</title>
        <%@ include file="../../parts/links.jsp" %>
    </head>
    <body>
        <%@ include file="../../parts/navbar.jsp" %>
        
        <jsp:useBean id="usuario" class="doceria.usuario.modelo.Usuario" scope="session" />
        
        <div class="account-page">
            <div class="container">
                <h2>Perfil do Cliente</h2>
                <table>
                    <tr>
                        <td>Nome:</td>
                        <td><jsp:getProperty name="usuario" property="nome" /></td>
                    </tr>
                    <br/>
                    <tr>
                        <td>E-mail:</td>
                        <td><jsp:getProperty name="usuario" property="email" /></td>
                    </tr>
                    <br/>
                    <tr>
                        <td>Login:</td>
                        <td><jsp:getProperty name="usuario" property="login" /></td>
                    </tr>
                    <br/>
                    <tr>
                        <td>Usuario criado em:</td>
                        <td><jsp:getProperty name="usuario" property="criado_em" /></td>
                    </tr>
                    <br/>
                </table>
            </div>
        </div>
                        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>