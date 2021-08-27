<%-- 
    Document   : conta-admin
    Created on : 28/07/2021, 08:11:28
    Author     : uliss
--%>

<%@page import="doceria.produto.modelo.Produto"%>
<%@page import="doceria.categoria.modelo.CategoriaDAO"%>
<%@page import="doceria.categoria.modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
        <% if (usuario.isAdministrador()) { %>
            
            <div class="account-page">
                <div class="container">
                    <div class="row">

                        <div class="col-3">
                            <h2>Olá, <%= usuario.getNome() %></h2>
                            <h3>Bem vindo à sua página de Administrador</h3>
                        </div>
                            
                        <div class="col-3">
                            <a href="ConsultarCategorias" class="btn2">Gerenciar Categorias de Produto</a>
                            <br/>
                            <a href="VerPerfil" class="btn2">Ver Perfil</a>
                            <br/>
                            <a href="ExcluirUsuario" class="btn2">Excluir Cadastro</a>
                            <br/>
                            <a href="Logout" class="btn2">Sair</a>
                        </div>
                            
                        <div class="col-3">
                            <h2>Adicionar Novo Produto</h2>
                            <br/>
                            <%
                                List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                                if (categorias.isEmpty()) {
                            %>
                                <div>Não existem categorias! É necessário primeiro cadastrar alguma categoria</div>
                            <%
                                } else {
                            %>
                                <form action="AdicionarProduto" method="post">
                                    <label for="select-label">Escolha a categoria:</label> 
                                    <select name="categoria_id_fk" id="select-label">
                                    <%
                                        for(int i = 0; i < categorias.size(); i++) {
                                            Categoria c = categorias.get(i);
                                    %>
                                        <option value="<%= c.getId() %>"><%= c.getDescricao() %></option>
                                    <%
                                        }
                                    %>
                                    </select>
                                    <br/>
                                    <label for="descricao-label">Descrição do Produto:</label>
                                    <input type="text" id="descricao-label" name="descricao" required/>
                                    <label for="preco-label">Preço do produto:</label>
                                    <input type="number" id="preco-label" name="preco" step=".01" min="0" required/>
                                    <label for="quantidade-label">Quantidade do Produto:</label>
                                    <input type="number" id="quantidade-label" name="quantidade" min="0" required/>
                                    
                                    <br/><br/>
                                    <hr/><br/>
                                    <button type="submit" class="btn">Cadastrar Produto</button>
                                    <button type="reset" class="btn">Resetar</button>
                                </form>
                            <%
                                }
                            %>
                        </div>

                    </div>
                        
                    <%
                        if (request.getAttribute("mensagem") != null) {
                    %>
                        <div class="row">
                            <div class="col-3">
                                <div id="Erro"><%= request.getAttribute("mensagem") %></div>
                            </div> 
                        </div>
                    <%
                        }
                    %>
                </div>
                
            </div>
                        
            <hr/> <br/>
    
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
                        <a href="AtualizarProdutoFoto?id=<%= p.getId() %>" class="btn2">
                            Atualizar Foto
                        </a>
                        <%
                            if (p.getFoto() == null || p.getFoto().trim().length() == 0) {
                        %>
                        <div>O produto não tem foto</div>
                        <%
                            }
                        %>
                        <a href="AlterarProduto?id=<%= p.getId() %>" class="btn2">
                            Alterar Produto
                        </a>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
                    
        <% } else { %>
                
            <h2>Você não tem acesso à essa página.</h2>
                
        <% } %>
        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>
