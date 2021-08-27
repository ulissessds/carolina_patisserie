package doceria.categoria.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author holanda
 */
public class Categoria {
	
    private Integer categoria_id;
    private String descricao;

    public Categoria () {
    }
    
    public Categoria (ResultSet rs) throws SQLException {
        this.categoria_id = rs.getInt("categoria_id");
        this.descricao = rs.getString("descricao");
    }

    public Integer getId() {
        return categoria_id;
    }

    public void setId(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}