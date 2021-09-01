package doceria.pedido.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class PedidoProdutos {
    private Integer pedido_id;
    private Integer produto_id;
    private Integer quantidade;
    private Timestamp criado_em;
    private Timestamp modificado_em;

    
    public PedidoProdutos() {
        this.criado_em = Timestamp.from(Instant.now());
        this.modificado_em = this.criado_em;
    }
    
    public PedidoProdutos(ResultSet rs) throws SQLException {
        this.pedido_id = rs.getInt("pedido_id");
        this.produto_id = rs.getInt("produto_id");
        this.quantidade = rs.getInt("quantidade");
        this.criado_em = rs.getTimestamp("criado_em");
        this.modificado_em = rs.getTimestamp("modificado_em");
    }
    
    
    public Integer getPedido_id() {
        return pedido_id;
    }

    
    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    
    public Integer getProduto_id() {
        return produto_id;
    }

    
    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    
    public Integer getQuantidade() {
        return quantidade;
    }

    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

   
    public Timestamp getCriado_em() {
        return criado_em;
    }

    
    public void setCriado_em(Timestamp criado_em) {
        this.criado_em = criado_em;
    }

    
    public Timestamp getModificado_em() {
        return modificado_em;
    }

    
    public void setModificado_em(Timestamp modificado_em) {
        this.modificado_em = modificado_em;
    }
}
