package doceria.categoria.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author holanda
 */
public class Categoria {
	
    private Integer id;
    private String descricao;

    public Categoria () {
    }
    
    public Categoria (ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.descricao = rs.getString("descricao");
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
}