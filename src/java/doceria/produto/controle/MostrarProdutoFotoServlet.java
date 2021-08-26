package doceria.produto.controle;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uliss
 */
public class MostrarProdutoFotoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String foto = null;
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = produtoDAO.obter(id);
        //Checar se existe o registro no BD (pois pode vir nulo)
        if (produto.getFoto() != null && produto.getFoto().trim().length() > 0) {
            foto = produto.getFoto();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        File arquivoFoto = new File(foto);
        //Checar se existe a foto fisicamente
        if (!arquivoFoto.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        ServletContext context = this.getServletContext();
        String mimeType = context.getMimeType(foto);
        //Por segurança se o mimeType for desconhecido
        if (mimeType == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        response.setContentLength((int) arquivoFoto.length());
        response.setContentType(mimeType);
        
        FileInputStream in = new FileInputStream(arquivoFoto);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
    }
}
