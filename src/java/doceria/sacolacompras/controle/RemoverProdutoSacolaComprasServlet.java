package doceria.sacolacompras.controle;

import doceria.sacolacompras.modelo.SacolaCompras;
import java.io.IOException;
import java.io.PrintWriter;
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
public class RemoverProdutoSacolaComprasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* entrada */
        String produtoId = request.getParameter("produtoId");

        /* processamento */
        Cookie c = SacolaCompras.obterCookie(request);
        try {
            String novoValor = SacolaCompras.removerItem(Integer.parseInt(produtoId), c.getValue());
            c.setValue(novoValor);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }

        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
        requestDispatcher.forward(request, response);
    }
}
