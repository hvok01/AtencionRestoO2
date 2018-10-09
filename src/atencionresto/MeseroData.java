
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
    
    public MeseroData (Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarMesero (Mesero mesero) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("INSERT INTO mesero (id_mesero ,nombre_mesero ,dni_mesero ,estado)"
                    + " VALUES ( ? , ? , ? , ? );");
            ps.setInt(1, mesero.getId_mesero());
            ps.setString(2, mesero.getNombre_mesero());
            ps.setInt(3, mesero.getDni_mesero());
            ps.setBoolean(4, mesero.getEstado());
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
    
    public void buscarMesero (int id) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT * FROM `mesero` WHERE id_mesero = ( ? );");
           // ps.setString(0, id_materia);
            ps.setInt(1, id);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            Mesero nm;
            while(resultSet.next()){
                nm = new Mesero();
                nm.setNombre_mesero(resultSet.getString("nombre_mesero"));
                System.out.println("usted seleccion por el id el mesero " + nm.getNombre_mesero());
               // JOptionPane .showMessageDialog(null, "el alumno es: " + nm.getNombre_mesero());
            } 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
