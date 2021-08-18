package doceria.produto.controle;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uliss
 */
public class AtualizarProdutoFotoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.obter(id);
        if (produto != null) {
            request.setAttribute("produto", produto);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/upload-foto-produto.jsp");
        requestDispatcher.forward(request, response);
    }
}
