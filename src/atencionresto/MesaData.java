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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            
            String sql = "INSERT INTO mesa (id_mesa, numero_mesa, capacidad_mesa, estado) VALUES ( ? , ? , ?, ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getIdMesa());
            statement.setInt(2, mesa.getNumMesa());
            statement.setInt(3, mesa.getCapacidad());
            statement.setString(3, mesa.estado());
            
            
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
            
            String sql = "UPDATE mesa SET  numero_mesa = ? , capacidad_mesa =? , estado=? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getNumMesa());
            statement.setInt(2, mesa.getCapacidad());
            statement.setString(3, mesa.estado());
            statement.setInt(4, mesa.getIdMesa());
            statement.executeUpdate();
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un mesa: " + ex.getMessage());
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
                mesa.setestado(resultSet.getString("estado"));
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        return mesa;
       }
      
      public List<Mesa> obtenerMesas () {
        List<Mesa> mesas = new ArrayList<Mesa>();
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT num_mesa FROM `mesa`;");
            
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            Mesa nuevaMesa;
            while(resultSet.next()){
                nuevaMesa = new Mesa();
                nuevaMesa.setNumMesa(resultSet.getInt("num_mesa"));
                
                mesas.add(nuevaMesa);
            } 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println(mesas);
        return mesas;
    }
}