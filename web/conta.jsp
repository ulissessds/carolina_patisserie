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
                        <%@ include file="parts/login-register-form.jsp" %>
                    </div>
                </div>
            </div>
        </div>
        
        <%@ include file="parts/footer.jsp" %>
    </body>
</html>
