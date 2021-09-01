package doceria.produto.controle;

import doceria.categoria.modelo.Categoria;
import doceria.categoria.modelo.CategoriaDAO;
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
public class AdicionarProdutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String descricao = request.getParameter("descricao");
        Double preco = Double.parseDouble(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int categoria_id_fk = Integer.parseInt(request.getParameter("categoria_id_fk"));
            
        /* processamento */
        Produto p = new Produto();
        p.setDescricao(descricao);
        p.setPreco(preco);
        p.setQuantidade(quantidade);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria c = categoriaDAO.obter(categoria_id_fk);
        
        try {
            produtoDAO.inserir(p, c.getDescricao());
            request.setAttribute("mensagem", "Produto cadastrado com sucesso");
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Não foi possível cadastrar o Produto");
        }
        
        // mandar a lista de categorias
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
