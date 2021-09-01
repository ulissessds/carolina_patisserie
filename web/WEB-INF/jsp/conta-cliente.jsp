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
            <div class="container">
                <div class="row">
                    
                    <div class="col-2">
                        <h2>Olá, <%= usuario.getNome() %></h2>
                        <h3>Bem vindo à sua página de Cliente</h3>
                    </div>

                    <div class="col-2">
                        <a href="VerPerfil" class="btn2">Ver Perfil</a>
                        <br/>
                        <a href="ExcluirUsuario" class="btn2">Excluir Cadastro</a>
                        <br/>
                        <a href="Logout" class="btn2">Sair</a>
                    </div>
                        
                </div>
            </div>
            <br/>
            <br/>
        </div>
    
        <%@ include file="../../parts/produtos-estoque.jsp" %>
        
        <hr/>  
        <div class="account-page">
            <%@ include file="../../parts/sacola-compras.jsp" %>
            
            <a href="" class="btn2">Comprar</a>
        </div>
        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>