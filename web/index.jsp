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
    
        <!--------- produtos em estoque --------->
        <div class="small-container">
            <h2 class="title">Produtos em Estoque</h2>
            <div class="row">
                <% 
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    List<Produto> produtosDisponiveis = (List<Produto>) request.getAttribute("produtosDisponiveis");
                    if (produtosDisponiveis.isEmpty()) {
                %>
                <div>Desculpe, ainda não existem produtos em estoque</div>
                <%
                    } else {
                        for (int i = 0; i < produtosDisponiveis.size(); i++) {
                            Produto p = produtosDisponiveis.get(i);
                            Categoria c = categoriaDAO.obter(p.getCategoriaIdFk());
                %>
                <div class="col-4">
                    <img src="MostrarProdutoFoto?id=<%= p.getId() %>" width="200" height="160"/>
                    <h4><%= p.getDescricao() %></h4>
                    <div class="rating">
                        Categoria: <%= c.getDescricao() %>
                    </div>
                    <p>R$ <%= p.getPreco() %></p>
                    <p>Quantidade: <%= p.getQuantidade() %></p>
                    <a href="AdicionarProdutoSacolaCompras?produtoId=<%= p.getId() %>" class="btn2">
                        Adicionar à Sacola
                    </a>
                    <%
                        if (p.getFoto() == null || p.getFoto().trim().length() == 0) {
                    %>
                    <div>O produto não tem foto</div>
                    <%
                        } else {
                    %>
                    <a href="DownloadProdutoFoto?id=<%= p.getId() %>" class="btn2">
                        Download Foto
                    </a>
                    <%
                        }
                    %>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
            
        <hr/>
        <h1>Sacola de Compras</h1>
        <% 
            List<SacolaComprasItem> sacolaCompras = (List<SacolaComprasItem>) request.getAttribute("sacolaCompras");
            double total = 0;
            if (sacolaCompras == null || sacolaCompras.isEmpty()) {
        %>
        <div>Sua Sacola de Compras está vazia (e seu estômago)</div>
        <%
            } else {
                for (int i = 0; i < sacolaCompras.size(); i++) {
                    SacolaComprasItem sacolaItem = sacolaCompras.get(i);
                    total += sacolaItem.getQuantidade() * sacolaItem.getProduto().getPreco();
        %>
        <div>
            <h4><%= sacolaItem.getProduto().getDescricao() %></h4>
            <h5>R$ <%= sacolaItem.getProduto().getPreco() %></h5>
            <h6>Quantidade: <%= sacolaItem.getQuantidade() %></h6>
            <a href="RemoverProdutoSacolaCompras?produtoId=<%= sacolaItem.getProduto().getId() %>" class="btn">
                Remover da Sacola de Compras
            </a>
        </div>
        <%
                }
            }
        %>
        <div>Total: R$ <%= total %></div>
        
        <!--------- footer --------->        
        <%@ include file="parts/footer.jsp" %>
    </body>
</html>