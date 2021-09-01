<%-- 
    Document   : sacola-compras
    Created on : 31/08/2021, 18:03:02
    Author     : uliss
--%>

<%@page import="doceria.sacolacompras.modelo.SacolaComprasItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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