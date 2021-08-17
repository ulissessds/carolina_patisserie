/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doceria.carrinhocompra.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivo
 */
public class RemoverProdutoCarrinhoCompraServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String produtoId = request.getParameter("produtoId");

        /* processamento */
        Cookie cookie = CarrinhoCompra.obterCookie(request);
        try {
            String novoValor = CarrinhoCompra.removerItem(Integer.parseInt(produtoId), cookie.getValue());
            cookie.setValue(novoValor);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }

        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
        requestDispatcher.forward(request, response);
    }

}
