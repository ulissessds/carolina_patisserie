package doceria.usuario.controle;

import doceria.usuario.modelo.Usuario;
import doceria.usuario.modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uliss
 */
public class CadastrarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        /* processamento */
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setLogin(login);
        u.setSenha(senha);
        u.setAdministrador(false);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.inserir(u);
            request.setAttribute("mensagem", "Usuário cadastrado com sucesso");
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Não foi possível cadastrar o usuário");
        }
        /* Saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("conta.jsp");
        requestDispatcher.forward(request, response);
    }
}
