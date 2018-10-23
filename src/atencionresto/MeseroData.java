
package atencionresto;

import home.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MeseroData {
    private Connection connection = null;
    
    public MeseroData (Conexion conexion) throws ClassNotFoundException {
        connection = conexion.getConexion();
    }
    
    public void guardarMesero (Mesero mesero) {
             
        try {
            
            String sql = "INSERT INTO mesero (nombre_mesero, dni_mesero, estado)"
                    + " VALUES ( ? , ? , ? );";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         
            ps.setString(1, mesero.getNombre_mesero());
            ps.setInt(2, mesero.getDni_mesero());
            ps.setBoolean(3, mesero.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                mesero.setId_mesero(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar el mesero: " + ex.getMessage());
        }
       
    }
   
    public void borrarMesero (Mesero mesero) {
      
        try {
            String sql = "DELETE FROM mesero WHERE nombre_mesero = ( ? );";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mesero.getNombre_mesero());
            ps.executeUpdate();
            ps.close();
            System.out.println("El mesero " + mesero.getNombre_mesero() + " fue eliminado de la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void actualizarMesero (Mesero mesero) { 
        try {
            String sql = "UPDATE mesero SET nombre_mesero = ( ? ), dni_mesero = ( ? ),"
                    + " estado = ( ? )"
                    + " WHERE id_mesero = ( ? );";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, mesero.getNombre_mesero());
            statement.setInt(2, mesero.getDni_mesero());
            statement.setBoolean(3, mesero.getEstado());
            statement.setInt(4, mesero.getId_mesero());
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el mesero: " + ex.getMessage());
        }

    }
    
        public List<Mesero> obtenerAlumnos(){
        List<Mesero> meseros = new ArrayList<Mesero>();
            

        try {
            String sql = "SELECT * FROM mesero;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Mesero mesero;
            while(resultSet.next()){
                mesero= new Mesero();
                mesero.setId_mesero(resultSet.getInt("id"));
                mesero.setNombre_mesero(resultSet.getString("nombre"));
              mesero.setDni_mesero(resultSet.getInt("dni"));
              mesero.setEstado(resultSet.getBoolean(0));

                meseros.add(mesero);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lo mesero: " + ex.getMessage());
        }
  
        return meseros;
    }
    
    public void logearMesero (String nombre,int dni) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT nombre_mesero FROM `mesero` "
                    + " WHERE nombre_mesero = ( ? ) AND dni_mesero = ( ? );");
            
            ps.setString(1,nombre);
            ps.setInt(2, dni);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                JOptionPane .showMessageDialog(null,"Bienvenido/a " + nombre);
                Main m = new Main();
                m.setVisible(true);
            } else {
                JOptionPane .showMessageDialog(null,"Nombre de usuario o contraseña incorrectos");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
