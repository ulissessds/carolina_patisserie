//package doceria.pedido.modelo;
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
///**
// *
// * @author Tsurugo
// */
//public class PedidoDAO {
//    public List<Pedido> obterTodos() throws SQLException{
//        List<Pedido> resultado = new ArrayList<Pedido>();
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "s4mcr0");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT Pedido_id FROM Pedido");
//            while (resultSet.next()) {
//                Pedido p = new Pedido();
//                p.setPedido_id(resultSet.getInt("Pedido_id"));
//                p.setUsuario_id(resultSet.getInt("Usuario_id"));
//                resultado.add(p);
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//        return resultado;
//    }
//    
//    public Pedido obter(int id) throws SQLException{
//        Pedido p = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Pedido_id, Cliente_id, Criado_em FROM Pedido WHERE Pedido_id = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                p = new Pedido();
//                p.setPedido_id(resultSet.getInt("Pedido_id"));
//                p.setCliente_id(resultSet.getInt("Cliente_id"));
//                p.setCriado_em(resultSet.getDate("Criado_em"));
//            }
//            resultSet.close();
//            preparedStatement.close();
//            connection.close();
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//        if (p == null) {
//            throw new SQLException("Registro nao encontrado");
//        }
//        
//        return p;
//    }
//    
//    public void inserir(int Pedido_id, int Cliente_id, BigDecimal Total, Date Criado_em, Date Modificado_em) throws SQLException {
//        int resultado = 0;
//        Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pedido (Pedido_id, Cliente_id, Total, Criado_em, Modificado_em) VALUES (?, ?, ?, ?, ?)");
//            preparedStatement.setInt(1, Pedido_id);
//            preparedStatement.setInt(2, Cliente_id);
//            preparedStatement.setBigDecimal(3, Total);
//            preparedStatement.setDate(4, Criado_em);
//            preparedStatement.setDate(5, Modificado_em);
//            resultado = preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//        if (resultado == 0) {
//            throw new SQLException("Registro nao foi inserido com sucesso");
//        }
//    }
//    
//    public void atualizar(int Pedido_id, int Cliente_id, BigDecimal Total, Date Criado_em, Date Modificado_em) throws SQLException {
//        int resultado = 0;
//        Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
//            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Pedido SET Total = ?, Criado_em = ?, Modificado_em = ? WHERE Pedido_id = ?, Cliente_id = ?");
//            preparedStatement.setInt(1, Pedido_id);
//            preparedStatement.setInt(2, Cliente_id);
//            preparedStatement.setBigDecimal(3, Total);
//            preparedStatement.setDate(4, Criado_em);
//            preparedStatement.setDate(5, Modificado_em);
//            resultado = preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//        if (resultado == 0) {
//            throw new SQLException("Registro nao foi atualizado com sucesso");
//        }
//    }
//    
//    public void remover(int Pedido_id, int Cliente_id) throws SQLException{
//        int resultado = 0;
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolina_patisserie", "postgres", "hcvrdgfhi1");
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Pedido WHERE Pedido_id = ?, Cliente_id = ?");
//            preparedStatement.setInt(1, Pedido_id);
//            preparedStatement.setInt(2, Cliente_id);
//            resultado = preparedStatement.executeUpdate();
//            preparedStatement.close();
//            connection.close();
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//        if (resultado == 0) {
//            throw new SQLException("Registro nao foi removido com sucesso");
//        }
//    }
//}
