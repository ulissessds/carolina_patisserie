package doceria.produto.controle;

import doceria.produto.modelo.ProdutoDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author uliss
 */
public class UploadProdutoFotoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = -1;
        FileItem foto = null;

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            boolean sucesso = false;
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(new File("C:\\Users\\uliss\\OneDrive\\Documentos\\SMD\\Semestre_7\\Prog Web\\doceria\\temp"));

                ServletFileUpload upload = new ServletFileUpload(factory);

                List<FileItem> itens = upload.parseRequest(new ServletRequestContext(request));
                Iterator<FileItem> iter = itens.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    
                    if (!item.isFormField() && item.getFieldName().equals("foto")) {
                        foto = item;
                    }
                    
                    if (item.isFormField() && item.getFieldName().equals("id")) {
                        id = Integer.parseInt(item.getString());
                    }
                }
                
                if (id != -1 && foto != null) {
                    foto.write(
                            new File("C:\\Users\\uliss\\OneDrive\\Documentos\\SMD\\Semestre_7\\Prog Web\\doceria\\produtos\\"
                                    + id + foto.getName().substring(foto.getName().lastIndexOf(".")))
                    );
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.atualizarFoto(
                            id, "C:\\Users\\uliss\\OneDrive\\Documentos\\SMD\\Semestre_7\\Prog Web\\doceria\\produtos\\"
                                    + id + foto.getName().substring(foto.getName().lastIndexOf("."))
                    );
                    sucesso = true;
                }
                
                if (sucesso) {
                    request.setAttribute("mensagem", "Upload da foto deste produto foi efetuado com sucesso");
                } else {
                    request.setAttribute("mensagem", "Não foi possível processo o upload da foto deste produto");
                }
            } catch (Exception ex) {
                request.setAttribute("mensagem", "Não foi possível processo o upload da foto deste produto");
            }
        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AtualizarProdutoFoto?id=" + id);
        requestDispatcher.forward(request, response);
    }
}
