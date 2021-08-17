<%-- 
    Document   : conta-cliente
    Created on : 27/07/2021, 14:06:23
    Author     : uliss
--%>

<%@page import="doceria.usuario.modelo.Usuario"%>
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
        
        <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
        <div class="account-page">
            <br/>
            <br/>
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1>Olá, <%= usuario.getNome() %></h1>
                    </div>

                    <div class="col-2">
                        <a href="VerPerfil">Ver Perfil</a>
                        <br/>
                        <br/>
                        <a href="Logout">Sair</a>
                    </div>
                </div>
            </div>
            <br/>
            <br/>
        </div>
        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>