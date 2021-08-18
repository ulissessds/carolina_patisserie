<%-- 
    Document   : conta-cliente
    Created on : 27/07/2021, 14:06:23
    Author     : uliss
--%>

<%@page import="doceria.produto.modelo.Produto"%>
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
        
        <% 
            Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <div class="account-page">
            <br/>
            <br/>
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h2 class="title"><%= produto.getDescricao() %></h2>
                        
                    </div>

                    <div class="col-2">
                        <h2>Atualizar Foto do Produto</h2>
                        <form method="post" enctype="multipart/form-data" action="UploadProdutoFoto">
                            <input type="hidden" name="id" value="<%= produto.getId() %>" />
                            <input type="file" name="foto" placeholder="Selecione uma foto" />
                            <br/>
                            <input type="submit" value="Atualizar" />
                        </form>
                        <%
                            if (request.getAttribute("mensagem") != null) {
                        %>
                        <div><%= request.getAttribute("mensagem") %></div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
            <br/>
            <br/>
        </div>
        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>