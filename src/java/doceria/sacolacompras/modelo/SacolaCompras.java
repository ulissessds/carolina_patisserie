package doceria.sacolacompras.modelo;

import doceria.produto.modelo.Produto;
import doceria.produto.modelo.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author uliss
 */
public class SacolaCompras {
    
    public static final String SEPARADOR_PRODUTO = "&";
    public static final String SEPARADOR_CAMPO = ":";
    
    public static final Cookie obterCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("doceria.sacolacompras")) {
                c = cookies[i];
                break;
            }
        }
        return c;
    }
    
    public static final List<SacolaComprasItem> obterSacolaCompras(String valor) {
        List<SacolaComprasItem> sacolaCompras = new ArrayList<SacolaComprasItem>();
        if (valor == null || valor.trim().length() == 0 || !valor.contains(SEPARADOR_CAMPO)) {
            return sacolaCompras;
        }
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        if (valor.contains(SEPARADOR_PRODUTO)) {
            String[] produtos = valor.split(SEPARADOR_PRODUTO);
            for (int i = 0; produtos != null && i < produtos.length; i++) {
                String[] item = produtos[i].split(SEPARADOR_CAMPO);
                
                SacolaComprasItem sacolaComprasItem = new SacolaComprasItem();
                
                Produto produto = produtoDAO.obter(Integer.parseInt(item[0]));
                
                sacolaComprasItem.setProduto(produto);
                sacolaComprasItem.setQuantidade(Integer.parseInt(item[1]));
                
                sacolaCompras.add(sacolaComprasItem);
            }
        } else {
            String[] item = valor.split(SEPARADOR_CAMPO);

            SacolaComprasItem sacolaComprasItem = new SacolaComprasItem();

            Produto produto = produtoDAO.obter(Integer.parseInt(item[0]));

            sacolaComprasItem.setProduto(produto);
            sacolaComprasItem.setQuantidade(Integer.parseInt(item[1]));

            sacolaCompras.add(sacolaComprasItem);
        }
        
        return sacolaCompras;
    }
    
    public static final String adicionarItem (int produtoId, int quantidade, String valor) throws Exception {
        List<SacolaComprasItem> sacolaCompras = obterSacolaCompras(valor);
        
        if (sacolaCompras.isEmpty()) {
            return produtoId + SEPARADOR_CAMPO + quantidade;
        }
        
        boolean adicionou = false;
        String resultado = "";
        
        for (SacolaComprasItem item : sacolaCompras) {
            if (item.getProduto().getId() == produtoId) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                adicionou = true;
            }
            
            if (!resultado.isEmpty()) {
                resultado += SEPARADOR_PRODUTO;
            }
            
            resultado += item.getProduto().getId() + SEPARADOR_CAMPO + item.getQuantidade();
        }
        
        if (!adicionou) {
            resultado += SEPARADOR_PRODUTO + produtoId + SEPARADOR_CAMPO + quantidade;
        }
        
        return resultado;
    }
    
    public static final String removerItem(int produtoId, String valor) {
        List<SacolaComprasItem> sacolaCompras = obterSacolaCompras(valor);
        
        if (sacolaCompras.isEmpty()) {
            return "";
        }
        
        String resultado = "";
        
        for (SacolaComprasItem item : sacolaCompras) {
            if (item.getProduto().getId() == produtoId) {
                continue;
            }
            
            if (!resultado.isEmpty()) {
                resultado += SEPARADOR_PRODUTO;
            }
            
            resultado += item.getProduto().getId() + SEPARADOR_CAMPO + item.getQuantidade();
        }
        
        return resultado;
    }
}
