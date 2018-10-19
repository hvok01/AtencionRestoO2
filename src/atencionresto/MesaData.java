/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atencionresto;

import java.sql.Connection;
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
 
    public MesaData() {
    }

   public MesaData (Conexion conexion) throws ClassNotFoundException {
        connection = conexion.getConexion();
    }
    
    public void guardarMesa (Mesa mesa) {       
       try {
            
            String sql = "INSERT INTO alumno (num_mesa, capacidad, activo) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, mesa.getNumMesa());
            statement.setInt(2, mesa.getCapacidad());
            statement.setBoolean(3, mesa.isEstado());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();//obtener el id del alumno

            if (rs.next()) {
                mesa.setIdamesa(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una mesa: " + ex.getMessage());
        }
    }}