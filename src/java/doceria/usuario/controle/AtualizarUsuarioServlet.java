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
public class AtualizarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */        
        String novoNome = request.getParameter("novoNome");
        String novoEmail = request.getParameter("novoEmail");
        String novoLogin = request.getParameter("novoLogin");
        String novaSenha = request.getParameter("novaSenha");
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        /* processamento */
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean loginValido = usuarioDAO.efetuarLogin(login, senha);
        if (loginValido) {
            Usuario u = usuarioDAO.obter(login);
            if (novoNome != null && novoNome.trim().length() > 0) {u.setNome(novoNome);}
            if (novoEmail != null && novoEmail.trim().length() > 0) {u.setEmail(novoEmail);}
            if (novoLogin != null && novoLogin.trim().length() > 0) {u.setLogin(novoLogin);}
            if (novaSenha != null && novaSenha.trim().length() > 0) {u.setSenha(novaSenha);}
            try {
                usuarioDAO.atualizar(u);
            } catch (SQLException ex) {
                Logger.getLogger(AtualizarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }            
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", u);
            /* Saída */
            request.setAttribute("mensagem2", "Usuário atualizado com sucesso, faça seu login novamente");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Logout");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem2", "Login ou senha incorreta");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Logout");
            requestDispatcher.forward(request, response);
        }
    }
}
