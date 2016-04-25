package kmk.gotraffic.model;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Victor on 21/03/2016.
 */
public class UsuarioAnomalia {

    private Usuario usuario;
    private Anomalia anomalia;
    private int avaliacao;
    private String dataAvaliacao;

    public UsuarioAnomalia() {
        this.dataAvaliacao = DateFormat.getDateInstance().format(new Date());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Anomalia getAnomalia() {
        return anomalia;
    }

    public void setAnomalia(Anomalia anomalia) {
        this.anomalia = anomalia;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
