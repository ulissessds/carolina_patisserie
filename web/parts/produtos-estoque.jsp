<%-- 
    Document   : navbar
    Created on : 27/07/2021, 00:00:52
    Author     : uliss
--%>

<%@page import="doceria.categoria.modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="doceria.produto.modelo.Produto"%>
<%@page import="doceria.categoria.modelo.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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