<%-- 
    Document   : index
    Created on : 17/08/2021, 16:22:29
    Author     : uliss
--%>

<%@page import="doceria.categoria.modelo.CategoriaDAO"%>
<%@page import="doceria.categoria.modelo.Categoria"%>
<%@page import="doceria.sacolacompras.modelo.SacolaComprasItem"%>
<%@page import="doceria.produto.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="parts/meta.jsp" %>
        <title>Carolina Pâtisserie | E-commerce Website Design</title>
        <%@ include file="parts/links.jsp" %>
    </head>
    <body>
        <div class="header">
            <%@ include file="parts/navbar.jsp" %>
            
            <div class="account-page">
                <div class="container">
                    <div class="row">

                        <div class="col-2">
                            <h1>Frase de efeito<br/>Colocar aqui!</h1>
                            <p>Pequeno texto. Fazendo um resumo motivacional para se comer doces.</p>
                            <a href="" class="btn">Explore agora →</a>
                        </div>

                        <div class="col-2">
                            <%@ include file="parts/login-register-form.jsp" %>
                        </div>

                    </div>
                </div>
            </div>
        </div>
            
        <div class="categories"></div>
    
        <%@ include file="parts/produtos-estoque.jsp" %>
            
        <hr/>
        <div class="account-page">
            <%@ include file="parts/sacola-compras.jsp" %>
            <br/>
            <div>Faça Login para finalizar sua compra!</div>
        </div>
        
        <!--------- footer --------->        
        <%@ include file="parts/footer.jsp" %>
    </body>
</html>