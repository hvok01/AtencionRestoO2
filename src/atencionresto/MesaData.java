/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atencionresto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrador
 */
public class MesaData {
   private Connection connection = null;
     private Conexion conexion;
    public MesaData() {
    }

   public MesaData (Conexion conexion) throws ClassNotFoundException{
       this.conexion=conexion;
       connection = conexion.getConexion();
    }
    
    public void guardarMesa (Mesa mesa) {       
             try {
            
            String sql = "INSERT INTO cursada (idAlumno, idMateria, nota) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getIdMesa());
            statement.setInt(2, mesa.getNumMesa());
            statement.setInt(3, mesa.getCapacidad());
            statement.setBoolean(3, true);
            
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                mesa.setIdamesa(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una mesa");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
        }
    }
    
    public void borrarMesa(int id){
       try {
            
            String sql = "DELETE FROM mesa WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar mesa: " + ex.getMessage());
        }

    }
       public void actualizarMesa(Mesa mesa){
              try {
            
            String sql = "UPDATE alumno SET nombre = ?, fecNac = ? , activo =? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getIdMesa());
            statement.setInt(2, mesa.getNumMesa());
            statement.setInt(3, mesa.getCapacidad());
            statement.setBoolean(3, true);
            statement.executeUpdate();
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
       }
      public Mesa buscarMesa(int id){
    Mesa mesa=null;
    try {
            
            String sql = "SELECT * FROM mesa WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                mesa = new Mesa();
                mesa.setIdamesa(resultSet.getInt("id"));
                mesa.setNumMesa(resultSet.getInt("numero"));
                mesa.setCapacidad(resultSet.getInt("capacidad"));
                mesa.setEstado(resultSet.getBoolean("estado"));
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        return mesa;
       }
}