package doceria.produto.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author uliss
 */
public class Produto {
    
    private Integer id;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String foto;

    public Produto () {
    }
    
    public Produto (ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.descricao = rs.getString("descricao");
        this.preco = rs.getDouble("preco");
        this.quantidade = rs.getInt("quantidade");
        this.foto = rs.getString("foto");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }    
}