package doceria.produto.controle;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class AtualizarProdutoServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */        
        int id = Integer.parseInt(request.getParameter("id"));
        String novaDescricao = request.getParameter("novaDescricao");
        Double novoPreco = -1.0; 
        int novaQuantidade = -1; 
        
        if (request.getParameter("novoPreco") != null && request.getParameter("novoPreco").trim().length() > 0) {
            novoPreco = Double.parseDouble(request.getParameter("novoPreco"));
        }
        if (request.getParameter("novaQuantidade") != null && request.getParameter("novaQuantidade").trim().length() > 0) {
            novaQuantidade = Integer.parseInt(request.getParameter("novaQuantidade"));
        }
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto p = produtoDAO.obter(id);
        if (novaDescricao != null && novaDescricao.trim().length() > 0) {p.setDescricao(novaDescricao);}
        if (novoPreco >= 0) {p.setPreco(novoPreco);}
        if (novaQuantidade >= 0) {p.setQuantidade(novaQuantidade);}
        try {
            produtoDAO.atualizarProduto(p);
            request.setAttribute("mensagem", "Produto atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensagem", "Erro, produto não foi atualizado");
        }
        
        if (p != null) {
            request.setAttribute("produto", p);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/alterar-produto.jsp");
        requestDispatcher.forward(request, response);
    }
}    