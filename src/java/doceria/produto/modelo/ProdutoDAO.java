package doceria.produto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uliss
 */
public class ProdutoDAO {
    
    public Produto obter(Integer id) {
        Produto p = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, foto, categoria_id_fk FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                p = new Produto(rs);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return p;
    }
    
    public void inserir(Produto p, String c_descricao) throws Exception {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO produto (descricao, preco, quantidade, categoria_id_fk) "
                            + "VALUES (?, ?, ?, "
                            + "(SELECT categoria_id FROM categoria WHERE descricao = ?));");
            preparedStatement.setString(1, p.getDescricao());
            preparedStatement.setDouble(2, p.getPreco());
            preparedStatement.setInt(3, p.getQuantidade());
            preparedStatement.setString(4, c_descricao);
            sucesso = preparedStatement.executeUpdate() == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public List<Produto> obterProdutosEmEstoque() {
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, foto, categoria_id_fk FROM produto WHERE quantidade > 0;");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs);
                produtos.add(p);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return produtos;
    }
    
    public void atualizarFoto(int id, String fotoPath) throws Exception {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET foto = ? WHERE id = ?");
            preparedStatement.setString(1, fotoPath);
            preparedStatement.setInt(2, id);
            sucesso = preparedStatement.executeUpdate() == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public void atualizarProduto(Produto p, String c_descricao) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE produto SET descricao = ?, preco = ?, quantidade = ?, "
                        + "categoria_id_fk = (SELECT categoria_id FROM categoria WHERE descricao = ?) WHERE id = ?");
            preparedStatement.setString(1, p.getDescricao());
            preparedStatement.setDouble(2, p.getPreco());
            preparedStatement.setInt(3, p.getQuantidade());
            preparedStatement.setString(4, c_descricao);
            preparedStatement.setInt(5, p.getId());
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro não foi atualizado com sucesso");
        }
    }

    public void removerProduto(int id) throws SQLException {
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro não foi removido com sucesso");
        }
    }
    
}
