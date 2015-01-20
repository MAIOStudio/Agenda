
package agenda;


public class Direccion {
    private int idDireccion;
    private String casa;
    private String trabajo;
    private String otra;
    private int idContacto;
    private int idCiudad;

    public Direccion() {
    }

    public Direccion(String casa) {
        this.casa = casa;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
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

    public String getOtra() {
        return otra;
    }

    public void setOtra(String otra) {
        this.otra = otra;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    
}
