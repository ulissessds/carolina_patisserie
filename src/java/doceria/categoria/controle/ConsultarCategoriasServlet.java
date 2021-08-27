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
public class ConsultarCategoriasServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* processamento */
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/consultar-categorias.jsp");
        requestDispatcher.forward(request, response);
    }
}
