package kmk.gotraffic.model;

/**
 * Created by Victor on 19/03/2016.
 */
public class Usuario {

    private long id;
    private String email;
    private String senha;
    private int exp;
    private int level;

    public Usuario() {
        this.exp = 0;
        this.level = 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
