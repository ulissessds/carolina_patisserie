package doceria.produto.controle;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

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
                factory.setRepository(new File(""/*localização dos temporarios EXE:/home/nomeusuario/doceria/temp*/));

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
                    foto.write(new File("/home/nomeusuario/doceria/produtos/" + id + foto.getName().substring(foto.getName().lastIndexOf("."))));
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.atualizarFoto(id, "/home/nomeusuario/doceria/produtos/" + id + foto.getName().substring(foto.getName().lastIndexOf(".")));
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
