package kmk.gotraffic.model;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Victor on 19/03/2016.
 */
public class Anomalia {

    private int id;
    private String dataCriacao;
    private float lat;
    private float lng;
    private Usuario usuario;
    private TipoAnomalia tipoAnomalia;

    public Anomalia() {
        //this.dataCriacao = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        this.dataCriacao = DateFormat.getDateInstance().format(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoAnomalia getTipoAnomalia() {
        return tipoAnomalia;
    }

    public void setTipoAnomalia(TipoAnomalia tipoAnomalia) {
        this.tipoAnomalia = tipoAnomalia;
    }
}
