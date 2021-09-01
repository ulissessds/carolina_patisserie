package doceria.usuario.controle;

import doceria.categoria.modelo.Categoria;
import doceria.categoria.modelo.CategoriaDAO;
import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import doceria.sacolacompras.modelo.SacolaCompras;
import doceria.sacolacompras.modelo.SacolaComprasItem;
import doceria.usuario.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author uliss
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        /* processamento */
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean loginValido = usuarioDAO.efetuarLogin(login, senha);
        if (loginValido) {
            HttpSession session = request.getSession(true);
            Usuario usuario = usuarioDAO.obter(login);
            session.setAttribute("usuario", usuario);
            String path;
            
            // mandar a lista de produtos
            ProdutoDAO produtoDAO = new ProdutoDAO();
            // se for o admin logando, mostrar todos e não só os que tem em estoque
            if (usuario.isAdministrador()) {
                List<Produto> produtosDisponiveis = produtoDAO.obterTodosProdutos();
                request.setAttribute("produtosDisponiveis", produtosDisponiveis);
            } else {
                List<Produto> produtosDisponiveis = produtoDAO.obterProdutosEmEstoque();
                request.setAttribute("produtosDisponiveis", produtosDisponiveis);
            }
            
            // mandar a lista de categorias
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List<Categoria> categorias = categoriaDAO.listarCategorias();
            request.setAttribute("categorias", categorias);
            
            // pegar cookies
            Cookie[] cookies = request.getCookies();
            Cookie c = null;
            for (int i = 0; cookies != null && i < cookies.length; i++) {
                if (cookies[i].getName().equals("doceria.sacolacompras")) {
                    c = cookies[i];
                    break;
                }
            }
            if (c == null) {
                c = new Cookie("doceria.sacolacompras", "");
            }
            c.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(c);
            try {
                List<SacolaComprasItem> sacolaCompras = SacolaCompras.obterSacolaCompras(c.getValue());
                request.setAttribute("sacolaCompras", sacolaCompras);
            } catch (Exception ex) {

            }
            
            if (usuario.isAdministrador()) {
                // caminho da página exclusiva de admin
                path = "WEB-INF/jsp/conta-admin.jsp";
                
            } else {
                // caminho da página exclusiva do cliente
                path = "WEB-INF/jsp/conta-cliente.jsp";
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem", "Login ou senha incorreta");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
            requestDispatcher.forward(request, response);
        }
    }
    
}