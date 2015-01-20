//package DB;
//
//import java.awt.HeadlessException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.swing.JOptionPane;
//
//public class SQLQueryValidacion {
//
//    public boolean contactoExistente(String nombre, String apellido) {
//        Connection coneccion = null;
//        Statement consulta = null;
//        ResultSet tabla = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            coneccion = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "");
//            consulta = coneccion.createStatement();
//            tabla = consulta.executeQuery("SELECT nombre, apellido FROM contacto  WHERE nombre LIKE '%" + nombre + "%'  ");
//            if (tabla.next()) {
//                JOptionPane.showMessageDialog(null, "Este contacto ya existe !!!");
//                return true;
//
//            }
//            return false;
//        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
//        }
//        return false;
//    }
//
//}
