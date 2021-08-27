<%-- 
    Document   : conta-cliente
    Created on : 27/07/2021, 14:06:23
    Author     : uliss
--%>

<%@page import="java.util.List"%>
<%@page import="doceria.categoria.modelo.Categoria"%>
<%@page import="doceria.categoria.modelo.CategoriaDAO"%>
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
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Produto produto = (Produto) request.getAttribute("produto");
            Categoria categoria = categoriaDAO.obter(produto.getCategoriaIdFk());
        %>
        
        <div class="account-page">
            <div class="container">
                
                <div class="row">
                    
                    <div class="col-3">
                        <h2>Dados do Produto</h2>
                        <table>
                            <tr>
                                <td style="background-color: #fefefe;">Descrição:</td>
                                <td><%= produto.getDescricao() %></td>
                            </tr>
                            <br/>
                            <tr>
                                <td style="background-color: #fefefe;">Preço:</td>
                                <td><%= produto.getPreco() %></td>
                            </tr>
                            <br/>
                            <tr>
                                <td style="background-color: #fefefe;">Quantidade:</td>
                                <td><%= produto.getQuantidade() %></td>
                            </tr>
                            <br/>
                            <tr>
                                <td style="background-color: #fefefe;">Categoria:</td>
                                <td><%= categoria.getDescricao() %></td>
                            </tr>
                            <br/>
                        </table>
                    </div>
                            
                    <div class="col-3">
                        <h2>Atualizar Produto</h2>
                        <br/>
                        <%
                            List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                        %>
                        <form action="AtualizarProduto" method="post">
                            <input type="hidden" name="id" value="<%= produto.getId() %>" />
                            <label for="select">Escolha a categoria:</label> 
                            <select name="categoriaDescricao" id="select">
                            <%
                                for(int i = 0; i < categorias.size(); i++) {
                                    Categoria c = categorias.get(i);
                            %>
                                <option value="<%= c.getDescricao() %>"><%= c.getDescricao() %></option>
                            <%
                                }
                            %>
                            </select>
                            <label for="descricao-label">Nova Descrição:</label>
                            <input type="text" id="descricao-label" name="novaDescricao"/>
                            <label for="preco-label">Novo Preço:</label>
                            <input type="number" id="preco-label" name="novoPreco" step=".01" min="0"/>
                            <label for="quantidade-label">Nova Quantidade:</label>
                            <input type="number" id="quantidade-label" name="novaQuantidade" min="0"/>
                            <button type="submit" class="btn">Atualizar Produto</button>
                        </form>
                    </div>
                            
                </div>
                            
                <br/> <hr/> <br/>
                
                <div class="row">
                    <div class="col-3">
                        <h2>Excluir este Produto</h2>
                        <br/>
                        <h3>Atenção! Esta ação é definitiva</h3>
                        <br/>
                        <a href="ExcluirProduto?id=<%= produto.getId() %>" class="btn">
                            Excluir Produto
                        </a>
                    </div>
                </div>
                
            </div>
         </div>
        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>