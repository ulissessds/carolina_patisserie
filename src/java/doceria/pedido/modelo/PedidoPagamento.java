package doceria.pedido.modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;


public class PedidoPagamento {
    private Integer pagamento_id;
    private Integer pedido_id;
    private Double preco;
    private Boolean pago;
    private Timestamp criado_em;
    private Timestamp modificado_em;
    
    public PedidoPagamento() {
        this.criado_em = Timestamp.from(Instant.now());
        this.modificado_em = this.criado_em;
    }
    
    public PedidoPagamento(ResultSet rs) throws SQLException {
        this.pagamento_id = rs.getInt("pagamento_id");
        this.pedido_id = rs.getInt("pedido_id");
        this.preco = rs.getDouble("preco");
        this.pago = rs.getBoolean("pago");
        this.criado_em = rs.getTimestamp("criado_em");
        this.modificado_em = rs.getTimestamp("modificado_em");
    }
    
   
    public Integer getPagamento_id() {
        return pagamento_id;
    }

    
    public void setPagamento_id(Integer pagamento_id) {
        this.pagamento_id = pagamento_id;
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

   
    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }
   
    
    public Double getPreco() {
        return preco;
    }

    
    public void setPreco(Double preco) {
        this.preco = preco;
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

    
    public Boolean getPago() {
        return pago;
    }
    
   
    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    
}
