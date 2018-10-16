/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atencionresto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("INSERT INTO mesero (id_mesa ,num_mesa ,capacidad ,estado)"
                    + " VALUES ( ? , ? , ? , ? );");
            ps.setInt(1, mesa.getIdMesa());
            ps.setInt(2, mesa.getNumMesa());
            ps.setInt(3, mesa.getCapacidad());
             ps.setBoolean(4, mesa.isEstado());
            ps.executeUpdate();
            ps.close();
            System.out.println("la mesa fue agregada exitosamente.");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
