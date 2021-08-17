<%-- 
    Document   : conta
    Created on : 26/07/2021, 17:32:11
    Author     : uliss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="parts/meta.jsp" %>
        <title>Carolina Pâtisserie | E-commerce Website Design</title>
        <%@ include file="parts/links.jsp" %>
    </head>
    <body>
        <%@ include file="parts/navbar.jsp" %>
        
        <div class="account-page">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <img src="http://placekitten.com/g/340/350" alt="descrição da imagem"/>
                    </div>

                    <div class="col-2">
                        <div class="form-container">
                            <div class="form-btn">
                                <span onclick="login()">Entrar</span>
                                <span onclick="register()">Registrar</span>
                                <hr id="Indicator"/>
                            </div>

                            <form id="LoginForm" action="Login" method="post">
                                <input type="text" name="login" placeholder="Login" required />
                                <input type="password" name="senha" placeholder="Senha" required />
                                <button type="submit" class="btn">Entrar</button>
                                <a href="">Esqueci a senha</a><br/>
                                <% if (request.getAttribute("mensagem") != null) { %>
                                <div id="Erro"><%= request.getAttribute("mensagem")%></div>
                                <% } %>
                            </form>

                            <form id="RegisterForm" action="CadastrarUsuario" method="post"> 
                                <input type="text" name="nome" placeholder="Nome" required />
                                <input type="email" name="email" placeholder="E-mail" required />
                                <input type="text" name="login" placeholder="Login" required />
                                <input type="password" name="senha" placeholder="Senha" required />
                                <button type="submit" class="btn">Registrar</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <%@ include file="parts/footer.jsp" %>
    </body>
</html>
