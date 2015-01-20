package agenda;

import java.util.Date;


public class Contacto {
    private int idContacto;
    private String nombre;
    private String apellido;
    private Date cumpleano;
    private Telefono telefono;
    private Direccion direccion;
    private Email email;

    public Contacto(int idContacto, String nombre, String apellido, Date cumpleano, Telefono telefono, Direccion direccion, Email email) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cumpleano = cumpleano;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public Contacto() {
    }
    
    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getCumpleano() {
        return cumpleano;
    }

    public void setCumpleano(Date cumpleano) {
        this.cumpleano = cumpleano;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
 
    
    
}
