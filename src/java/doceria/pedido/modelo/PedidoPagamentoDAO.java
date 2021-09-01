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
public class PedidoPagamentoDAO {
    public List<PedidoPagamento> obterTodas() throws SQLException{
        List<PedidoPagamento> resultado = new ArrayList<PedidoPagamento>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pagamento_id, pedido_id FROM PedidoPagamento");
            while (resultSet.next()) {
                PedidoPagamento p = new PedidoPagamento();
                p.setPagamento_id(resultSet.getInt("pagamento_id"));
                p.setPedido_id(resultSet.getInt("pedido_id"));
                p.setPago(resultSet.getBoolean("pago"));
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
    
    public PedidoPagamento obter(int id) throws SQLException{
        PedidoPagamento p = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT pagamento_id, pedido_id, pago, criado_em FROM PedidoPagamento WHERE pagamento_id = ?, pedido_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new PedidoPagamento();
                p.setPagamento_id(resultSet.getInt("pagamento_id"));
                p.setPedido_id(resultSet.getInt("pedido_id"));
                p.setPago(resultSet.getBoolean("pago"));
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
    
    public void inserir(int pagamento_id, int pedido_id, double preco, Boolean pago, Timestamp criado_em, Timestamp modificado_em) throws SQLException {
        int resultado = 0;
        Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PedidoPagamento (pagamento_id, pedido_id, preco, pago, criado_em, modificado_em) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, pagamento_id);
            preparedStatement.setInt(2, pedido_id);
            preparedStatement.setDouble(3, preco);
            preparedStatement.setBoolean(4, pago);
            preparedStatement.setTimestamp(5, criado_em);
            preparedStatement.setTimestamp(6, modificado_em);
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
    
    public void atualizar(int pagamento_id, int pedido_id, Double preco, Boolean pago, Timestamp criado_em, Timestamp modificado_em) throws SQLException {
        int resultado = 0;
        Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PedidoPagamento SET preco = ?, pago = ? ,criado_em = ?, modificado_em = ? WHERE pagamento_id = ?, pedido_id = ?");
            preparedStatement.setInt(1, pagamento_id);
            preparedStatement.setInt(2, pedido_id);
            preparedStatement.setDouble(3, preco);
            preparedStatement.setBoolean(4, pago);
            preparedStatement.setTimestamp(5, criado_em);
            preparedStatement.setTimestamp(6, modificado_em);
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
    
    public void remover(int pagamento_id, int pedido_id) throws SQLException{
        int resultado = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PedidoPagamento WHERE pagamento_id = ?, pedido_id = ?");
            preparedStatement.setInt(1, pagamento_id);
            preparedStatement.setInt(2, pedido_id);
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
