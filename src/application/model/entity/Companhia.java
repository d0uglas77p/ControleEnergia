package application.model.entity;

public class Companhia {

    private int id;
    private int usuarioId;
    private String nomeCompanhia;
    private String cnpj;
    private String telefoneCompanhia;
    private String tipoFornecimento;
    private String medidor;
    private String tarifa;

    public Companhia() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNomeCompanhia() {
        return nomeCompanhia;
    }
    public void setNomeCompanhia(String nomeCompanhia) {
        this.nomeCompanhia = nomeCompanhia;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getTelefoneCompanhia() {
        return telefoneCompanhia;
    }
    public void setTelefoneCompanhia(String telefoneCompanhia) {
        this.telefoneCompanhia = telefoneCompanhia;
    }
    public String getTipoFornecimento() {
        return tipoFornecimento;
    }
    public void setTipoFornecimento(String tipoFornecimento) {
        this.tipoFornecimento = tipoFornecimento;
    }
    public String getMedidor() {
        return medidor;
    }
    public void setMedidor(String medidor) {
        this.medidor = medidor;
    }
    public String getTarifa() {
        return tarifa;
    }
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
}
