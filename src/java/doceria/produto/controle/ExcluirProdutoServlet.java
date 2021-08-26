package doceria.produto.controle;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uliss
 */
public class ExcluirProdutoServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */        
        int id = Integer.parseInt(request.getParameter("id"));
        
        /* processamento */
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        try {
            produtoDAO.removerProduto(id);
            request.setAttribute("mensagem", "Produto removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensagem", "Erro, produto não foi removido");
        }
        
        List<Produto> produtosDisponiveis = produtoDAO.obterProdutosEmEstoque();
        request.setAttribute("produtosDisponiveis", produtosDisponiveis);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/consultar-produtos.jsp");
        requestDispatcher.forward(request, response);
    }
}
