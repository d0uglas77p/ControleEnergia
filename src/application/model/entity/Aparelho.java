package application.model.entity;

public class Aparelho {

    private int id;
    private int usuario_id;
    private String nomeAparelho;
    private String nomeFabricante;
    private String marca;
    private String modelo;
    private String volts;
    private String watts;
    private String tempo;
    private String kwh;

    public Aparelho() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    public String getNomeAparelho() {
        return nomeAparelho;
    }
    public void setNomeAparelho(String nomeAparelho) {
        this.nomeAparelho = nomeAparelho;
    }
    public String getNomeFabricante() {
        return nomeFabricante;
    }
    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getVolts() {
        return volts;
    }
    public void setVolts(String volts) {
        this.volts = volts;
    }
    public String getWatts() {
        return watts;
    }
    public void setWatts(String watts) {
        this.watts = watts;
    }
    public String getTempo() {
        return tempo;
    }
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getKwh() {
        return kwh;
    }
    public void setKwh(String kwh) {
        this.kwh = kwh;
    }


}
