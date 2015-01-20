package DB;

import agenda.Contacto;
import agenda.Direccion;
import agenda.Email;
import agenda.Telefono;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public final class DBManager {

    String url = null;
    String user = "root";
    String pass = "";
    String db = "Agenda";
    String host = "localhost";
    Connection conn = null;
    Statement stmnt = null;
    PreparedStatement pstmnt = null;
    ResultSet rs = null;

    public DBManager() {
        cargarDriver();
        conectar();
    }

    private void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("mysql Driver loaded" + " - " + Calendar.getInstance().getTime());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("There is some trouble loading mysql Driver" + " - " + Calendar.getInstance().getTime());
        }
    }

    public void conectar() {
        url = "jdbc:mysql://" + host + "/" + db + "?user=" + user
                + "&password=" + pass;
        try {
            conn = DriverManager.getConnection(url);
            stmnt = conn.createStatement();
            System.out.println("Connected to the database" + " - " + Calendar.getInstance().getTime());
        } catch (SQLException ex) {
            System.out.println("Connection to the Database unsuccessfully" + " - " + Calendar.getInstance().getTime());
        }
    }

    public void guardarContacto(Contacto c) {
        try {
            int contactoId = 0;
            String sql = "INSERT INTO contacto (Nombre, Apellido, Cumpleano) VALUES (?,?,?)";

            pstmnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmnt.setString(1, c.getNombre());
            pstmnt.setString(2, c.getApellido());
            pstmnt.setDate(3, new java.sql.Date(c.getCumpleano().getTime()));
            pstmnt.executeUpdate();
            ResultSet rs = pstmnt.getGeneratedKeys();

            if (rs.next()) {
                contactoId = rs.getInt(1);
            }

            //Preparamos el telefono
            String sqlT = "INSERT INTO telefono (casa, movil, Contacto_idContacto) VALUES"
                    + "(?, ?, ?)";
            pstmnt = conn.prepareStatement(sqlT, Statement.RETURN_GENERATED_KEYS);
            pstmnt.setString(1, c.getTelefono().getCasa());
            pstmnt.setString(2, c.getTelefono().getMovil());
            pstmnt.setInt(3, contactoId);
            pstmnt.executeUpdate();

            //Email
            String sqlE = "INSERT INTO email (emailPersonal , Contacto_idContacto) VALUES"
                    + "(?, ?)";
            pstmnt = conn.prepareStatement(sqlE, Statement.RETURN_GENERATED_KEYS);
            pstmnt.setString(1, c.getEmail().getEmailPersonal());
            pstmnt.setInt(2, contactoId);
            pstmnt.executeUpdate();

            //Direccion
            String sqlD = "INSERT INTO direccion (casa , Contacto_idContacto) VALUES"
                    + "(?, ?)";
            pstmnt = conn.prepareStatement(sqlD, Statement.RETURN_GENERATED_KEYS);
            pstmnt.setString(1, c.getDireccion().getCasa());
            pstmnt.setInt(2, contactoId);
            pstmnt.executeUpdate();

            System.out.println("Contact saved" + " - " + Calendar.getInstance().getTime());
        } catch (SQLException ex) {
            System.out.println("Contact no saved" + " - " + Calendar.getInstance().getTime());
        }
    }

    public void borrarContacto(Contacto c) {
        try {

            int contactoId = c.getIdContacto();

            //Borrar telefono 
            String sqlT = "DELETE FROM telefono WHERE Contacto_idContacto = ?";
            pstmnt = conn.prepareStatement(sqlT);
            pstmnt.setInt(1, contactoId);
            pstmnt.executeUpdate();

            //Borrar Email
            String sqlE = "DELETE FROM email WHERE Contacto_idContacto = ?";
            pstmnt = conn.prepareStatement(sqlE);

            pstmnt.setInt(1, contactoId);
            pstmnt.executeUpdate();

            //Borrar Direccion
            String sqlD = "DELETE FROM direccion WHERE Contacto_idContacto = ?";
            pstmnt = conn.prepareStatement(sqlD);

            pstmnt.setInt(1, contactoId);
            pstmnt.executeUpdate();

            //Borrar Contacto
            String sql = "DELETE FROM contacto WHERE idContacto = ?";
            pstmnt = conn.prepareStatement(sql);

            pstmnt.setInt(1, contactoId);
            pstmnt.executeUpdate();

            System.out.println("Contact deleted" + " - " + Calendar.getInstance().getTime());

        } catch (SQLException ex) {
            System.out.println("Contact no deleted" + " - " + Calendar.getInstance().getTime());
        }
    }

    public List<Contacto> getContactos(String nombre, String apellido) {
        ArrayList<Contacto> contacto = new ArrayList<>();

        try {
            String like = "c.Nombre like '%" + nombre + "%' OR  c.Apellido like '%" + apellido + "%'";
            if (nombre.isEmpty()) {
                like = "1=1";
            }
            String sql2 = "SELECT  c.idContacto as ID, c.Nombre, c.Apellido, c.Cumpleano,  d.casa as Direccion , e.emailPersonal as Email , t.casa as Tcasa , t.movil as Celular FROM contacto as c, direccion as d, email as e, telefono as t\n"
                    + "WHERE " + like + " AND c.idContacto = d.Contacto_idContacto AND c.idContacto = e.Contacto_idContacto AND c.idContacto = t.Contacto_idContacto GROUP BY c.idContacto ORDER BY C.Nombre ";

            rs = stmnt.executeQuery(sql2);

            while (rs.next()) {
                Contacto c = new Contacto();
                c.setIdContacto(Integer.parseInt(rs.getString("ID")));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setCumpleano(rs.getDate("Cumpleano"));
                c.setDireccion(new Direccion(rs.getString("Direccion")));
                c.setTelefono(new Telefono(rs.getString("Tcasa"), rs.getString("Celular")));
                c.setEmail(new Email(rs.getString("Email")));
                contacto.add(c);

            }
            System.out.println("Contacts loaded" + " - " + Calendar.getInstance().getTime());
        } catch (SQLException ex) {
            System.out.println("Contacts no loaded" + " - " + Calendar.getInstance().getTime());
        }

        return contacto;
    }

    public Contacto selectContact(String contactSelected) {
        Contacto c = new Contacto();
        try {
            String sql3 = "SELECT  c.idContacto as ID, c.Nombre, c.Apellido, c.Cumpleano, d.casa as Direccion , e.emailPersonal as Email , t.casa as Tcasa , t.movil as Celular FROM contacto as c, direccion as d, email as e, telefono as t\n"
                    + "WHERE  c.idContacto = " + contactSelected + " AND c.idContacto = d.Contacto_idContacto AND c.idContacto = e.Contacto_idContacto AND c.idContacto = t.Contacto_idContacto GROUP BY c.idContacto ORDER BY C.Nombre ";

            rs = stmnt.executeQuery(sql3);
            rs.next();
            c.setIdContacto(Integer.parseInt(rs.getString("ID")));
            c.setNombre(rs.getString("Nombre"));
            c.setApellido(rs.getString("Apellido"));
            c.setCumpleano(rs.getDate("Cumpleano"));
            c.setDireccion(new Direccion(rs.getString("Direccion")));
            c.setTelefono(new Telefono(rs.getString("Tcasa"), rs.getString("Celular")));
            c.setEmail(new Email(rs.getString("Email")));
            
            System.out.println("Editing contact" + " - " + Calendar.getInstance().getTime());
        } catch (SQLException ex) {
            System.out.println("Contact no selected" + " - " + Calendar.getInstance().getTime());
        }

        return c;
    }

    public boolean actualizarContacto(Contacto c) {
        try {
            String sql4 = "UPDATE contacto as c , direccion as d , email as e, telefono as t "
                    + "SET c.Nombre = ? , c.Apellido = ? , c.Cumpleano = ?, d.casa = ? , e.emailPersonal = ? , t.movil = ?, t.casa = ? "
                    + "WHERE c.idContacto = ? AND c.idContacto = d.Contacto_idContacto AND c.idContacto = e.Contacto_idContacto AND c.idContacto = t.Contacto_idContacto";

            pstmnt = conn.prepareStatement(sql4);
            pstmnt.setString(1, c.getNombre());
            pstmnt.setString(2, c.getApellido());
            pstmnt.setDate(3, new Date(c.getCumpleano().getTime()));
            pstmnt.setString(4, c.getDireccion().getCasa());
            pstmnt.setString(5, c.getEmail().getEmailPersonal());
            pstmnt.setString(6, c.getTelefono().getMovil());
            pstmnt.setString(7, c.getTelefono().getCasa());
            pstmnt.setInt(8, c.getIdContacto());
            System.out.println("Contact updated" + " - " + Calendar.getInstance().getTime());
            if (pstmnt.executeUpdate() > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println("Contact no updated" + " - " + Calendar.getInstance().getTime());
        }

        return false;

    }

    public void desconectar() {
        if (conn != null) {
            try {
                conn.close();
                stmnt = null;
                pstmnt = null;
                rs = null;
                System.out.println("Disconnected from the database" + " - " + Calendar.getInstance().getTime());
            } catch (SQLException ex) {
                System.out.println("Disconnection from the database unsuccessfuly" + " - " + Calendar.getInstance().getTime());
            }
        }
    }

}
