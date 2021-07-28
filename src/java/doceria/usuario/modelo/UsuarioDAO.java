package doceria.usuario.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uliss
 */
public class UsuarioDAO {
    
    public Usuario obter(String login) {
        Usuario u = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT usuario_id, login, senha, nome, criado_em, modificado_em, administrador, email FROM usuario WHERE login = ?");
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                u = new Usuario(rs);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return u;
    }
    
    public void inserir(Usuario u) throws Exception {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario (login, senha, nome, criado_em, modificado_em, administrador, email) VALUES (?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, u.getLogin());
            preparedStatement.setString(2, u.getSenha());
            preparedStatement.setString(3, u.getNome());
            preparedStatement.setTimestamp(4, u.getCriado_em());
            preparedStatement.setTimestamp(5, u.getModificado_em());
            preparedStatement.setBoolean(6, u.isAdministrador());
            preparedStatement.setString(7, u.getEmail());
            sucesso = preparedStatement.executeUpdate() == 1;
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public boolean efetuarLogin(String login, String senha) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/carolinaPatisserie_bd", "postgres", "s4mcr0");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT usuario_id, login, senha, nome, criado_em, modificado_em, administrador, email FROM usuario WHERE login = ? AND senha = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                sucesso = true;
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return sucesso;
    }
    
}
