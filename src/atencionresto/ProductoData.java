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
    
    
    public ProductoData (Conexion conexion) throws ClassNotFoundException {
        connection = conexion.getConexion();
    }
    
    public void guardarProducto (Producto producto) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("INSERT INTO producto (id_producto ,precio ,codigo, cantidad, nombre_producto)"
                    + " VALUES ( ? , ? , ? , ? );");
            ps.setInt(1, producto.getId_producto());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCodigo());
            ps.setInt(4, producto.getCantidad());
            ps.setString(5, producto.getNombre_producto());
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
                    + " cantidad = ( ? )"
                    + " WHERE id_producto = ( ? );");
            ps.setInt(1, id_producto);
            ps.setDouble(2, precio);
            ps.setInt(3, codigo);
            ps.setInt(4, cantidad);
            ps.setString (5, nombre_producto);
            ps.executeUpdate();
            ps.close();
            System.out.println("el producto " + nombre_producto + " fue actualizadoen la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public List<Producto> obtenerProductos(){
        List<Producto> productos = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM producto;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Producto producto;
            while(resultSet.next()){
                producto = new Producto();
                producto.setId_producto(resultSet.getInt("id"));
                producto.setPrecio(resultSet.getDouble("precio"));
                producto.setCodigo(resultSet.getInt("codigo"));
                producto.setCantidad(resultSet.getInt("cantidad"));
                producto.setNombre_producto(resultSet.getString("nombre_producto"));

                productos.add(producto);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los productos: " + ex.getMessage());
        }
        
        
        return productos;
    }
        
    
}
