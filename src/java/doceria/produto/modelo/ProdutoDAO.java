package doceria.produto.modelo;

import doceria.usuario.modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, foto FROM produto WHERE id = ?");
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
    
    public void inserir(Produto p) throws Exception {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (descricao, preco, quantidade) VALUES (?, ?, ?);");
            preparedStatement.setString(1, p.getDescricao());
            preparedStatement.setDouble(2, p.getPreco());
            preparedStatement.setInt(3, p.getQuantidade());
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, preco, quantidade, foto FROM produto WHERE quantidade > 0");
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
}
