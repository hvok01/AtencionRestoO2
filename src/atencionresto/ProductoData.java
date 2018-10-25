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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natalia
 */
public class ProductoData {
     private Connection connection = null;
     private Conexion conexion;
    
    public ProductoData (Conexion conexion)  {
         try {
             this.conexion=conexion;
             connection = conexion.getConexion();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void guardarProducto (Producto producto) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("INSERT INTO producto (id_producto ,precio ,codigo, nombre_producto)"
                    + " VALUES ( ? , ? , ? , ? );");
            ps.setInt(1, producto.getId_producto());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCodigo());
            ps.setString(4, producto.getNombre_producto());
            ps.executeUpdate();
            ps.close();
            System.out.println("El producto fue agregado exitosamente.");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void borrarProducto (Producto producto) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("DELETE FROM producto WHERE nombre_producto = ( ? );");
            ps.setString(1, producto.getNombre_producto());
            ps.executeUpdate();
            ps.close();
            System.out.println("El producto " + producto.getNombre_producto() + " fue eliminado de la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarProducto (int id_producto, double precio, int codigo, int cantidad, String nombre_producto) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("UPDATE producto SET nombre_producto = ( ? ), precio = ( ? ),"
                    + " codigo = ( ? )"
                    + " WHERE id_producto = ( ? );");
            ps.setInt(1, id_producto);
            ps.setDouble(2, precio);
            ps.setInt(3, codigo);
            ps.setString (4, nombre_producto);
            ps.executeUpdate();
            ps.close();
            System.out.println("el producto " + nombre_producto + " fue actualizadoen la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void obtenerProducto (int id) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT * FROM `producto` WHERE id_producto = ( ? );");
            ps.setInt(1, id);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            Producto unProducto;
            while(resultSet.next()){
                unProducto = new Producto();
                unProducto.setNombre_producto(resultSet.getString("nombre_producto"));
                System.out.println("usted selecciono el id del producto: " + unProducto.getNombre_producto());
               
            } 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Producto> obtenerProductos () {
        List<Producto> productos = new ArrayList<Producto>();
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("SELECT nombre_producto , precio FROM `producto`;");
            
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            Producto nuevoProducto;
            while(resultSet.next()){
                nuevoProducto = new Producto();
                nuevoProducto.setNombre_producto(resultSet.getString("nombre_producto"));
                nuevoProducto.setPrecio(resultSet.getDouble("precio"));
                
                productos.add(nuevoProducto);
            } 
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println(productos);
        return productos;
    }
}
