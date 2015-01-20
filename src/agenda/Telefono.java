

package agenda;


public class Telefono {
    private int idTelefono;
    private String movil;
    private String casa;
    private String trabajo;
    private String faxCasa;
    private String faxTrabajo;
    private String otro;
    private int idContacto;

    public Telefono() {
    }

    public Telefono(String movil, String casa) {
        this.movil = movil;
        this.casa = casa;
    }

    public int getId() {
        return idTelefono;
    }

    public void setId(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getFaxCasa() {
        return faxCasa;
    }

    public void setFaxCasa(String faxCasa) {
        this.faxCasa = faxCasa;
    }

    public String getFaxTrabajo() {
        return faxTrabajo;
    }

    public void setFaxTrabajo(String faxTrabajo) {
        this.faxTrabajo = faxTrabajo;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }
    
    
    
    
}
