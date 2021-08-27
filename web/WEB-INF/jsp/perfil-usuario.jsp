<%-- 
    Document   : perfil-cliente
    Created on : 28/07/2021, 07:53:09
    Author     : uliss
--%>

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
        
        <jsp:useBean id="usuario" class="doceria.usuario.modelo.Usuario" scope="session" />
        
        <div class="account-page">
            <div class="container">
                <div class="row">
                    
                    <div class="col-2">
                        <h2>Dados de Usuário</h2>
                        <table>
                            <tr>
                                <td>Nome:</td>
                                <td><jsp:getProperty name="usuario" property="nome" /></td>
                            </tr>
                            <br/>
                            <tr>
                                <td>E-mail:</td>
                                <td><jsp:getProperty name="usuario" property="email" /></td>
                            </tr>
                            <br/>
                            <tr>
                                <td>Login:</td>
                                <td><jsp:getProperty name="usuario" property="login" /></td>
                            </tr>
                            <br/>
                            <tr>
                                <td>Usuario criado em:</td>
                                <td><jsp:getProperty name="usuario" property="criado_em" /></td>
                            </tr>
                            <br/>
                        </table>
                    </div>
                            
                    <div class="col-2">
                        <h2>Atualizar Meus Dados</h2>
                        <form action="AtualizarUsuario" method="post">
                            <input type="text" name="novoNome" placeholder="Inserir novo Nome"/>
                            <input type="email" name="novoEmail" placeholder="Inserir novo Email"/>
                            <input type="text" name="novoLogin" placeholder="Inserir novo Login"/>
                            <input type="password" name="novaSenha" placeholder="Inserir nova Senha"/>
                            <h3>Insira Login e Senha Atuais para confirmar atualização</h3>
                            <input type="text" name="login" placeholder="Login" required />
                            <input type="password" name="senha" placeholder="Senha" required/>
                            <button type="submit" class="btn">Atualizar Meus Dados</button>
                        </form>
                    </div>
                            
                </div>
            </div>
        </div>
                        
        <%@ include file="../../parts/footer.jsp" %>
    </body>
</html>