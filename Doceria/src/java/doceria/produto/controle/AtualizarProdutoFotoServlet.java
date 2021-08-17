package doceria.produto.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarProdutoFotoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.obter(id);
        if (produto != null) {
            request.setAttribute("produto", produto);
        } else {
            request.setAttribute("mensagem", "Não foi possível encontrar este produto");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/uploadFotoProduto.jsp");
        requestDispatcher.forward(request, response);
    }

}
