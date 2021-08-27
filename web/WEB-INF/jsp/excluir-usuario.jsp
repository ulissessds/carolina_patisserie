<%-- 
    Document   : perfil-cliente
    Created on : 28/07/2021, 07:53:09
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
                        <h1>Sentiremos sua falta <%= usuario.getNome() %>...</h1>
                        <p>Atenção! Esta ação é definitiva.</p>
                        <p>Após excluir seu cadastro, será necessário criar um novo cadastro caso deseje utilizar nossos serviços novamente.</p>
                    </div>
                            
                    <div class="col-2">
                        <h2>Insira Login e Senha para confirmar exclusão</h2>
                        <form action="ConfirmarExclusao" method="post">
                            <input type="text" name="login" placeholder="Login" required />
                            <input type="password" name="senha" placeholder="Senha" required/>
                            <button type="submit" class="btn">Excluir meu cadastro</button>
                        </form>
                    </div>
                            
                </div>
            </div>
        </div>
                        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>