<%-- 
    Document   : footer
    Created on : 26/07/2021, 23:59:17
    Author     : uliss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <% if (request.getAttribute("mensagem2") != null) { %>
        <div id="Erro"><%= request.getAttribute("mensagem2")%></div>
        <% } else if (request.getAttribute("mensagem") != null) { %>
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