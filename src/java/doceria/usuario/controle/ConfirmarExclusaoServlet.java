package doceria.usuario.controle;

import doceria.usuario.modelo.Usuario;
import doceria.usuario.modelo.UsuarioDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author uliss
 */
public class ConfirmarExclusaoServlet extends HttpServlet {

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
            Usuario u = usuarioDAO.obter(login);
            try {
                usuarioDAO.remover(u.getId());
            } catch (SQLException ex) {
                Logger.getLogger(AtualizarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            /* Saída */
            request.setAttribute("mensagem2", "Cadastro excluído com sucesso");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Logout");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem2", "Login ou senha incorreta, entre novamente");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Logout");
            requestDispatcher.forward(request, response);
        }
    }
}
