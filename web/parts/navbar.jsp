<%-- 
    Document   : navbar
    Created on : 27/07/2021, 00:00:52
    Author     : uliss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="http://placekitten.com/125/70" alt="descrição da imagem"/>
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="">Início</a></li>
                <li><a href="">Produtos</a></li>
                <li><a href="">Sobre Nós</a></li>
                <li><a href="">Contato</a></li>
                <li><a href="conta.jsp">Conta</a></li>
            </ul>
        </nav>
        <!-- Sacola de Compras -->
        <img src="http://placekitten.com/g/30/30" alt="descrição da imagem"/>
        <!-- Menu Sanduíche -->
        <img src="images/menu.png" class="menu-icon" onclick="menuToggle()" alt="menu sanduíche"/>
    </div>
</div>