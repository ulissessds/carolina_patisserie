
package doceria.pedido.modelo;

import java.sql.Timestamp;

public class Pedido {

    private Integer pedido_id;
    private Integer usuario_id;
    private Double total;
    private Timestamp criado_em;
    private Timestamp modificado_em;
    
    // Construtor
    public Pedido() {
    }

    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
