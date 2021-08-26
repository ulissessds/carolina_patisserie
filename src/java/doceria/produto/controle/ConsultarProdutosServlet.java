package doceria.produto.controle;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uliss
 */
public class ConsultarProdutosServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* processamento */
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtosDisponiveis = produtoDAO.obterProdutosEmEstoque();
        request.setAttribute("produtosDisponiveis", produtosDisponiveis);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/consultar-produtos.jsp");
        requestDispatcher.forward(request, response);
    }
}
