package doceria.usuario.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author uliss
 */
public class Usuario {
    
    private Integer id;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private Timestamp criado_em;
    private Timestamp modificado_em;
    private boolean administrador;

    public Usuario () {
        this.criado_em = Timestamp.from(Instant.now());
        this.modificado_em = this.criado_em;
    }
    
    public Usuario (ResultSet rs) throws SQLException {
        this.id = rs.getInt("usuario_id");
        this.login = rs.getString("login");
        this.senha = rs.getString("senha");
        this.nome = rs.getString("nome");
        this.email = rs.getString("email");
        this.criado_em = rs.getTimestamp("criado_em");
        this.modificado_em = rs.getTimestamp("modificado_em");
        this.administrador = rs.getBoolean("administrador");
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Timestamp criado_em) {
        this.criado_em = criado_em;
    }

    public Timestamp getModificado_em() {
        return modificado_em;
    }

    public void setModificado_em(Timestamp modificado_em) {
        this.modificado_em = modificado_em;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
            
}
