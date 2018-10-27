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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 0
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

    public void guardarReserva(int idMesa, String nombreCliente, int dni, LocalDateTime fechaHora, boolean estado) {
        try {
            String sql = "INSERT INTO reserva ( id_mesa, nombre_cliente, dni_cliente, fechaHora, estado_vigente)"
                    + " VALUES ( ? , ? , ? , ? , ? );";

            try (PreparedStatement statment = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statment.setInt(1, idMesa);
                statment.setString(2, nombreCliente);
                statment.setInt(3, dni);
                statment.setObject(4, fechaHora);
                statment.setBoolean(5, estado);

                statment.executeUpdate();

                ResultSet rs = statment.getGeneratedKeys();//id's

                if (rs.next()) {
                    //  reserva.setIdReserva(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id luego de insertar una reserva");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }

    public List<Reserva> obtenerReservas () {
        List<Reserva> reservas = new ArrayList<Reserva>();
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT id_reserva, nombre_cliente, fechaHora FROM `reserva`;");
            
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            Reserva nuevaReserva;
            while(resultSet.next()){
                nuevaReserva = new Reserva();
                nuevaReserva.setIdReserva(resultSet.getInt("id_reserva"));
                nuevaReserva.setNombreCliente(resultSet.getString("nombre_cliente"));
                nuevaReserva.setFechaHora(resultSet.getTimestamp("fechaHora").toLocalDateTime());
              //nuevaReserva.setEstadoVigente(resultSet.getBoolean("estado_vigente"));
                
                reservas.add(nuevaReserva);
            } 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println(productos);
        return reservas;
    }

    public void actualizarReserva(Reserva reserva) {

        try {

            String sql = "UPDATE reserva SET id_mesa = ?, nombre_cliente = ?, dni_cliente = ? , fecha_hora =? , estado_vigente , WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getIdMesa());
            statement.setString(2, reserva.getNombreCliente());
            statement.setInt(3, reserva.getDniCliente());
            statement.setObject(4, reserva.getFechaHora());
            statement.setBoolean(5, reserva.getEstadoVigente());

            statement.executeUpdate();

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar la reserva: " + ex.getMessage());
        }
    }

    public Reserva buscarReserva(int idReserva) {
        Reserva reserva = null;
        try {

            String sql = "SELECT * FROM reserva WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idReserva);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("id_reserva"));
                reserva.setIdMesa(resultSet.getInt("idMesa"));
                reserva.setNombreCliente(resultSet.getString("nombre_cliente"));
                reserva.setDniCliente(resultSet.getInt("dni_cliente"));
                reserva.setFechaHora(resultSet.getTimestamp("fechaHora").toLocalDateTime());
                reserva.setEstadoVigente(resultSet.getBoolean("estado_vigente"));

            }
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar ls reserva: " + ex.getMessage());
        }

        return reserva;
    }

    public void borrarReserva(int idReserva) {

        try {

            String sql = "DELETE FROM reserva WHERE id_reserva = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idReserva);

            statement.executeUpdate();

            statement.close();
            
            System.out.println("Reserva anulada correctamente.");
            
        } catch (SQLException ex) {
            System.out.println("Error al borrar una reserva: " + ex.getMessage());
        }
    }

    public Mesa buscarMesa(int numero) {
        Mesa mesa = null;
        try {

            String sql = "SELECT * FROM mesa WHERE id =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, numero);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                mesa = new Mesa();
                mesa.setIdamesa(resultSet.getInt("id"));
                mesa.setNumMesa(resultSet.getInt("numero"));
                mesa.setCapacidad(resultSet.getInt("capacidad"));
                mesa.setEstado(resultSet.getString("estado"));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar un mesa: " + ex.getMessage());
        }
        return mesa;
    }
}
