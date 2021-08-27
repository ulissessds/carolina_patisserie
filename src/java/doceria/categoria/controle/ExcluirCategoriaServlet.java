package doceria.categoria.controle;

import doceria.categoria.modelo.Categoria;
import doceria.categoria.modelo.CategoriaDAO;
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
public class ExcluirCategoriaServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entradas */
        int id = Integer.parseInt(request.getParameter("select"));
        
        /* processamento */
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        
        // tentativa de remover
        try {
            categoriaDAO.removerCategoria(id);
            request.setAttribute("mensagem3", "Categoria excluída com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarCategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensagem3", "Erro, categoria não foi excluída");
        }
        
        // atualizar a nova lista de categorias
        List<Categoria> categorias = categoriaDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        
        // redirecionar pra mesma página
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/consultar-categorias.jsp");
        requestDispatcher.forward(request, response);
    }
}
