

package agenda;


public class Email {
    
    private int idEmail;
    private String emailPersonal;
    private String emailTrabajo;
    private String emailOtro;
    private int idContacto;

    public Email() {
    }

    public Email(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getEmailTrabajo() {
        return emailTrabajo;
    }

    public void setEmailTrabajo(String emailTrabajo) {
        this.emailTrabajo = emailTrabajo;
    }

    public String getEmailOtro() {
        return emailOtro;
    }

    public void setEmailOtro(String emailOtro) {
        this.emailOtro = emailOtro;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }
    
    
    
}
