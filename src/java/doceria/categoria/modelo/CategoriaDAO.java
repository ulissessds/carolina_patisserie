package doceria.categoria.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author holanda
 */
public class CategoriaDAO {
    
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT categoria_id, descricao FROM categoria;");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Categoria c = new Categoria(rs);
                categorias.add(c);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return categorias;
    }
    
    public void inserir(String descricao) throws Exception {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categoria (descricao) VALUES (?);");
            preparedStatement.setString(1, descricao);
            sucesso = preparedStatement.executeUpdate() == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public void atualizarCategoria(Categoria c) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categoria SET descricao = ? WHERE categoria_id = ?");
            preparedStatement.setString(1, c.getDescricao());
            preparedStatement.setInt(2, c.getId());
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Categoria não foi atualizada com sucesso");
        }
    }
    
    //Só pode remover um categoria se não existirem produtos associados a ela?
    public void removerCategoria (int id) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria WHERE categoria_id = ?;");
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Categoria não foi removida com sucesso. Verifique se todos os produtos dessa categoria foram removidos.");
        }
    }
    
    public Categoria obter(Integer id) {
        Categoria c = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT categoria_id, descricao FROM categoria WHERE categoria_id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                c = new Categoria(rs);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return c;
    }
}
