package doceria.sacolacompras.modelo;

import doceria.produto.modelo.Produto;

/**
 *
 * @author uliss
 */
public class SacolaComprasItem {
    
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
