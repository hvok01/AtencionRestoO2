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
 * @author nn
 */
public class ReservaData {
    private Connection connection = null;
private Conexion conexion;
private MesaData mesa;

 
    public ReservaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
public void guardarReserva(Reserva reserva){
        try {
            
            String sql = "INSERT INTO reserva ( id_mesa, nombre_cliente, dni_cliente, fecha_hora, estado_vigente) VALUES ( ? , ? , ? , ? , ? );";

            try (PreparedStatement statment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statment.setInt(1, reserva.getIdMesa());
                statment.setString(2, reserva.getNombreCliente());
                statment.setInt(3, reserva.getDniCliente());
                statment.setDate(4, Date.valueOf(reserva.getFechaHora()));
                statment.setBoolean(5, reserva.getEstadoVigente());
                
  
 
                statment.executeUpdate();
                
                ResultSet rs = statment.getGeneratedKeys();//id's
                
                if (rs.next()) {
                    reserva.setIdReserva(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id luego de insertar una reserva");}
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }
    
        
    public List<Reserva> obtenerReservas() throws ClassNotFoundException {
        List<Reserva> reservas = new ArrayList<>();
            
        try {
            String sql = "SELECT * FROM reserva;";
            try (PreparedStatement statment = connection.prepareStatement(sql)) {
                ResultSet resultSet = statment.executeQuery();
                Reserva reserva;
                while(resultSet.next()){
                    reserva = new Reserva();
                    conexion=new Conexion();
                    conexion.getConexion();
                    reserva.setIdReserva(resultSet.getInt("id_reserva"));
                    reserva.setIdMesa(resultSet.getInt("id_mesa"));
                    reserva.setNombreCliente(resultSet.getString("nombre_cliente"));
                    reserva.setDniCliente(resultSet.getInt("dni_cliente"));
                    reserva.setFechaHora(resultSet.getDate("fecha_hora").toLocalDate());
                    reserva.setEstadoVigente(resultSet.getBoolean("estado_vigente"));
                    
  
              
                    reservas.add(reserva);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las reservas: " + ex.getMessage());
        }catch(NullPointerException e){
                System.out.println("Error3"+e.getLocalizedMessage());
        }
        
        return reservas;
    }
   
  
         
    public void actualizarReserva(Reserva reserva){
    
        try {
            
            String sql = "UPDATE reserva SET id_mesa = ?, nombre_cliente = ?, dni_cliente = ? , fecha_hora =? , estado_vigente , WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getIdMesa());
            statement.setString(2, reserva.getNombreCliente());
            statement.setInt(3, reserva.getDniCliente());
            statement.setDate(4,Date.valueOf(reserva.getFechaHora()));
            statement.setBoolean(5, reserva.getEstadoVigente());
            
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar la reserva: " + ex.getMessage());
        } 
    }
    
    
    
    public Reserva buscarReserva(int idReserva){
      Reserva reserva=null;
    try {
            
            String sql = "SELECT * FROM reserva WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idReserva);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("id_reserva"));
                reserva.setIdMesa(resultSet.getInt("idMesa"));
                reserva.setNombreCliente(resultSet.getString("nombre_cliente"));
                reserva.setDniCliente(resultSet.getInt("dni_cliente"));
                reserva.setFechaHora(resultSet.getDate("fecha_hora").toLocalDate());
                reserva.setEstadoVigente(resultSet.getBoolean("estado_vigente"));
               
            }      
            statement.close();
     
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar ls reserva: " + ex.getMessage());
        }
        
        return reserva;
    }

     public void borrarReserva(int idReserva) throws ClassNotFoundException{

        try {
            String sql = "DELETE reserva where id= ?;";
          try (PreparedStatement statment = connection.prepareStatement(sql)) {
              statment.setInt(1, idReserva);
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar la reserva: " + ex.getMessage());
        }
     }
    }

