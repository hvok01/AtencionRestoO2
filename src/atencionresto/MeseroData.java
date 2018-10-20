
package atencionresto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MeseroData {
    private Connection connection = null;
    
    public MeseroData (Conexion conexion) throws ClassNotFoundException {
        connection = conexion.getConexion();
    }
    
    public void guardarMesero (Mesero mesero) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("INSERT INTO mesero (nombre_mesero, password, dni_mesero, estado)"
                    + " VALUES ( ? , ? , ? , 0 );");
            ps.setString(1, mesero.getNombre_mesero());
            ps.setString(2, mesero.getPassword());
            ps.setInt(3, mesero.getDni_mesero());
            ps.executeUpdate();
            ps.close();
            System.out.println("el mesero fue agregado exitosamente.");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void borrarMesero (Mesero mesero) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("DELETE FROM mesero WHERE nombre_mesero = ( ? );");
            ps.setString(1, mesero.getNombre_mesero());
            ps.executeUpdate();
            ps.close();
            System.out.println("El mesero " + mesero.getNombre_mesero() + " fue eliminado de la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarMesero (String nombre,int dni,boolean estado,int id_mesero) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("UPDATE mesero SET nombre_mesero = ( ? ), dni_mesero = ( ? ),"
                    + " estado = ( ? )"
                    + " WHERE id_mesero = ( ? );");
            ps.setString(1, nombre);
            ps.setInt(2, dni);
            ps.setBoolean(3, estado);
            ps.setInt(4, id_mesero);
            ps.executeUpdate();
            ps.close();
            System.out.println("el mesero " + nombre + " actualizo sus datos");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void logearMesero (String nombre,String contraseña) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT nombre_mesero FROM `mesero` "
                    + " WHERE nombre_mesero = ( ? ) AND password = ( ? );");
            
            ps.setString(1,nombre);
            ps.setString(2, contraseña);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
