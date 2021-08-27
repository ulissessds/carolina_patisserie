package doceria.categoria.controle;

import doceria.categoria.modelo.Categoria;
import doceria.categoria.modelo.CategoriaDAO;
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
public class AdicionarCategoriaServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String descricao = request.getParameter("descricao");
        
        /* processamento */      
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        if (descricao!= null && descricao.trim().length() > 0) {
            Categoria c = new Categoria();
            c.setDescricao(descricao);
            try {
                categoriaDAO.inserir(descricao);
                request.setAttribute("mensagem2", "Nova Categoria cadastrada com sucesso");
            } catch (Exception ex) {
                request.setAttribute("mensagem2", "Não foi possível cadastrar a Categoria");
            }
        }
        
        // atualizar a nova lista de categorias
        List<Categoria> categorias = categoriaDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        
        // redirecionar pra mesma página
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/consultar-categorias.jsp");
        requestDispatcher.forward(request, response);
    }
}
