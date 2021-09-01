package doceria.produto.controle;

import doceria.categoria.modelo.Categoria;
import doceria.categoria.modelo.CategoriaDAO;
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
public class AtualizarProdutoServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */        
        int id = Integer.parseInt(request.getParameter("id"));
        String novaDescricao = request.getParameter("novaDescricao");
        Double novoPreco = -1.0; 
        int novaQuantidade = -1;
        String categoriaDescricao = request.getParameter("categoriaDescricao");
        
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
            produtoDAO.atualizarProduto(p, categoriaDescricao);
            request.setAttribute("mensagem", "Produto atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensagem", "Erro, produto não foi atualizado");
        }
        
        // mandar a lista de categorias
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        // mandar a lista de produtos
        List<Produto> produtosDisponiveis = produtoDAO.obterTodosProdutos();
        request.setAttribute("produtosDisponiveis", produtosDisponiveis);
        // caminha da página exclusiva de admin
        String path = "WEB-INF/jsp/conta-admin.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}    