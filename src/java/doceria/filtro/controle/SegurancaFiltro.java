//package doceria.filtro.controle;
//
//import doceria.usuario.modelo.Usuario;
//import java.io.IOException;
//import java.util.Arrays;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author uliss
// */
//public class SegurancaFiltro implements Filter {
//
//    //Colocar aqui novas páginas e servlets públicas que forem adicionadas
//    private static final String[] RECURSOS_PUBLICOS = {
//        "/Doceria/",
//        "/Doceria/AdicionarProdutoSacolaCompras",
//        "/Doceria/RemoverProdutoSacolaCompras",
//        "/Doceria/CadastrarUsuario",
//        "/Doceria/Login",
//        "/Doceria/Logout",
//        "/Doceria/Inicio",
//        "/Doceria/DownloadProdutoFoto",
//        "/Doceria/MostrarProdutoFoto",
//        "/Doceria/index.jsp",
//        "/Doceria/conta.jsp",
//        "/Doceria/AtualizarUsuario",
//        "/Doceria/scripts.js",
//        "/Doceria/style.css",
//        "/Doceria/reset.css"
//    };
//    
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        
//        String requestURI = req.getRequestURI();
//        
//        if (Arrays.stream(RECURSOS_PUBLICOS).anyMatch(requestURI::equals)) {
//            chain.doFilter(request, response);
//        } else {
//            HttpSession sessao = req.getSession();
//            
//            if (sessao == null || sessao.getAttribute("usuario") == null) {
//                req.setAttribute("mensagem", "Você não tem uma sessão válida de usuário");
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Inicio");
//                requestDispatcher.forward(req, resp);
//            } else {
//                if (sessao.getAttribute("usuario") instanceof Usuario) {
//                    chain.doFilter(request, response);
//                } else {
//                    req.setAttribute("mensagem", "Você não tem permissão para acessar o recurso");
//                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("Inicio");
//                    requestDispatcher.forward(req, resp);
//                }
//            }
//        }
//    }
//    
//}
