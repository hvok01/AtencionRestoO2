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
            
            String sql = "INSERT INTO reserva (nombre_cliente, dni_cliente, fecha_hora, id_mesa, estado_vigente) VALUES ( ? , ? , ? , ? , ? );";

            try (PreparedStatement statment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statment.setString(1, reserva.getNombreCliente());
                statment.setInt(2, reserva.getDniCliente());
                statment.setDate(3, Date.valueOf(reserva.getFechaHora()));
                statment.setBoolean(4, reserva.getEstadoVigente());
                statment.setInt(5, reserva.getMesa().getIdMesa());
  
 
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
                    reserva.setIdReserva(resultSet.getInt(1));
                    reserva.setNombreCliente(resultSet.getString(2));
                    reserva.setDniCliente(resultSet.getInt(3));
                    reserva.setFechaHora(resultSet.getDate(4).toLocalDate());
                    reserva.setEstadoVigente(resultSet.getBoolean(5));
                    statment.setInt(5, reserva.getMesa().getIdMesa());
  
              
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
  
     
     public void borrarReserva(int idReserva) throws ClassNotFoundException{

        try {
            String sql = "DELETE FROM reserva where id= ?;";
          try (PreparedStatement statment = connection.prepareStatement(sql)) {
              statment.setInt(1, idReserva);
            }
        } catch (SQLException ex) {
            System.out.println("Error al borrar la reserva: " + ex.getMessage());
        }
    } 
    
     
    public void cancelarReserva(int idReserva) throws SQLException{
        
       try {
        String sql = "UPDATE FROM reserva SET estado_vigente=0 where id_reserva= ? ;";
       try (PreparedStatement statment = connection.prepareStatement(sql)) {
              statment.setInt(1, idReserva);
            }  
       } catch (SQLException ex) {
            System.out.println("Error al cancelar la reserva: " + ex.getMessage());
        }
    }
}

