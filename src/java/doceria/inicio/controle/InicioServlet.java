package doceria.inicio.controle;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import doceria.sacolacompras.modelo.SacolaCompras;
import doceria.sacolacompras.modelo.SacolaComprasItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uliss
 */
public class InicioServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* processamento */
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtosDisponiveis = produtoDAO.obterProdutosEmEstoque();
        request.setAttribute("produtosDisponiveis", produtosDisponiveis);
        
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

        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp"); /*nos servlets login e logout, mudar o requestDispatcher("index.jsp") para ("inicio")*/
        requestDispatcher.forward(request, response);
    }
}
