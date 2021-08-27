<%-- 
    Document   : consultar-categorias
    Created on : 26/08/2021, 17:55:12
    Author     : uliss
--%>

<%@page import="doceria.categoria.modelo.Categoria"%>
<%@page import="java.util.List"%>
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
        
        <div class="account-page">
            <div class="container">
                
                <div class="row">
                    
                    <div class="col-3">
                        <h2>Categorias Cadastradas</h2>
                        <%
                            List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                            if (categorias.isEmpty()) {
                        %>
                        <div>Não existem categorias cadastradas</div>
                        <%
                            } else {
                        %>
                        <table>
                            <%
                                for(int i = 0; i < categorias.size(); i++) {
                                    Categoria c = categorias.get(i);
                            %>
                            <tr>
                                <td style="background-color: #fefefe;">Descrição: </td>
                                <td><%= c.getDescricao() %></td>
                                <td style="background-color: #fefefe;">ID: </td>
                                <td><%= c.getId()%></td>
                            </tr>
                            <br/>
                            <%
                                }
                            %>
                        </table>
                        <%
                            }
                        %>
                    </div>
                            
                    <div class="col-3">
                        <h2>Atualizar Categoria</h2>
                        <br/>
                        <%
                            if (categorias.isEmpty()) {
                        %>
                        <div>Não existem categorias cadastradas</div>
                        <%
                            } else {
                        %>
                        <form action="AtualizarCategoria" method="post">
                            <label for="select">Escolha a categoria:</label> 
                            <select name="select" id="select">
                            <%
                                for(int i = 0; i < categorias.size(); i++) {
                                    Categoria c = categorias.get(i);
                            %>
                                <option value="<%= c.getId() %>"><%= c.getDescricao() %></option>
                            <%
                                }
                            %>
                            </select>
                            <input type="text" name="novaDescricao" placeholder="Inserir nova Descrição" required/>
                            <button type="submit" class="btn">Atualizar Categoria</button>
                        </form>
                        <%
                            }
                        %>
                        
                        <%
                            if (request.getAttribute("mensagem") != null) {
                        %>
                        <div id="Erro"><%= request.getAttribute("mensagem") %></div>
                        <%
                            }
                        %>
                    </div>
                            
                </div>
                    
                <br/><hr/><br/>
                
                <div class="row">
                    
                    <div class="col-3">
                        <h2>Adicionar Nova Categoria</h2>
                        <br/>
                        <form action="AdicionarCategoria" method="post">
                            <input type="text" name="descricao" placeholder="Inserir Descrição da Categoria" required/>
                            <button type="submit" class="btn">Adicionar</button>
                        </form>
                        <%
                            if (request.getAttribute("mensagem2") != null) {
                        %>
                        <div id="Erro"><%= request.getAttribute("mensagem2") %></div>
                        <%
                            }
                        %>
                    </div>
                    
                    <div class="col-3">
                        <h2>Excluir Categoria</h2>
                        <br/>
                        <%
                            if (categorias.isEmpty()) {
                        %>
                        <div>Não existem categorias cadastradas</div>
                        <%
                            } else {
                        %>
                        <form action="ExcluirCategoria" method="post">
                            <label for="select">Escolha a categoria:</label> 
                            <select name="select" id="select">
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
                            <br/><hr/><br/>
                            <h3>Atenção! Esta ação é definitiva!</h3>
                            <br/><hr/><br/>
                            <button type="submit" class="btn">Excluir Categoria</button>
                        </form>
                        <%
                            }
                        %>
                        
                        <%
                            if (request.getAttribute("mensagem3") != null) {
                        %>
                        <div id="Erro"><%= request.getAttribute("mensagem3") %></div>
                        <%
                            }
                        %>
                    </div>
                            
                </div>
                    
                <div class="row">
                    <a href="Logout" class="btn2">Sair</a>
                </div>
                
            </div>
        </div>
                        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>
