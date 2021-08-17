<%-- 
    Document   : conta-admin
    Created on : 28/07/2021, 08:11:28
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
                
                <% if (usuario.isAdministrador()) { %>
                
                <div class="row">
                    <div class="col-2">
                        <h1>Olá, Administrador</h1><br/>
                        <h3>Bem vindo, <%= usuario.getNome() %></h3>
                    </div>

                    <div class="col-2">
                        <a href="VerPerfil">Ver Perfil</a>
                        <br/>
                        <br/>
                        <a href="Logout">Sair</a>
                    </div>
                </div>
                    
                <% } else { %>
                
                <h2>Você não tem acesso à essa página.</h2>
                
                <% } %>
                
            </div>
            <br/>
            <br/>
        </div>
        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>
