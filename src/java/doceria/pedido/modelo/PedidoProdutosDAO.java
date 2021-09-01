package doceria.pedido.modelo;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tsurugo
 */
public class PedidoProdutosDAO {
    public List<PedidoProdutos> obterTodas() throws SQLException{
        List<PedidoProdutos> resultado = new ArrayList<PedidoProdutos>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pedido_id, produto_id FROM PedidoProdutos");
            while (resultSet.next()) {
                PedidoProdutos p = new PedidoProdutos();
                p.setPedido_id(resultSet.getInt("pedido_id"));
                p.setProduto_id(resultSet.getInt("produto_id"));
                resultado.add(p);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        return resultado;
    }
    
    public PedidoProdutos obter(int id) throws SQLException{
        PedidoProdutos p = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT pedido_id, produto_id, quantidade, criado_em FROM PedidoPagamento WHERE pedido_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new PedidoProdutos();
                p.setPedido_id(resultSet.getInt("pedido_id"));
                p.setProduto_id(resultSet.getInt("produto_id"));
                p.setQuantidade(resultSet.getInt("quantidade"));
                p.setCriado_em(resultSet.getTimestamp("criado_em"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (p == null) {
            throw new SQLException("Registro nao encontrado");
        }
        
        return p;
    }
    
    public void inserir(int pedido_id, int produto_id, int quantidade, Timestamp criado_em, Timestamp modificado_em) throws SQLException {
        int resultado = 0;
        Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PedidoProdutos (pedido_id, produto_id, quantidade, criado_em, modificado_em) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, pedido_id);
            preparedStatement.setInt(2, produto_id);
            preparedStatement.setInt(3, quantidade);
            preparedStatement.setTimestamp(4, criado_em);
            preparedStatement.setTimestamp(5, modificado_em);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro nao foi inserido com sucesso");
        }
    }
    
    public void atualizar(int pedido_id, int produto_id, int quantidade, Timestamp criado_em, Timestamp modificado_em) throws SQLException {
        int resultado = 0;
        Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PedidoProdutos SET quantidade = ?, criado_em = ?, modificado_em = ? WHERE pedido_id = ?, produto_id");
            preparedStatement.setInt(1, pedido_id);
            preparedStatement.setInt(2, produto_id);
            preparedStatement.setInt(3, quantidade);
            preparedStatement.setTimestamp(4, criado_em);
            preparedStatement.setTimestamp(5, modificado_em);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro nao foi atualizado com sucesso");
        }
    }
    
    public void remover(int pedido_id, int produto_id) throws SQLException{
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PedidoProdutos WHERE pedido_id = ?, produto_id = ?");
            preparedStatement.setInt(1, pedido_id);
            preparedStatement.setInt(2, produto_id);
            resultado = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex.getMessage());
        }
        if (resultado == 0) {
            throw new SQLException("Registro nao foi removido com sucesso");
        }
    }
}
