
package atencionresto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PedidoDetalleData {
    private Connection connection = null;
    public PedidoDetalleData() {
    }
    
    public PedidoDetalleData (Conexion conexion) throws ClassNotFoundException {
        connection = conexion.getConexion();
    }
    
    public void guardarPedidoDetalle (PedidoDetalle pedidoDetalle) {
        
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("INSERT INTO pedido_detalle ( cantidad_pedidos )"
                    + " VALUES ( ? );");
            ps.setInt(1, pedidoDetalle.getCantidadPedidos());
            ps.executeUpdate();
            ps.close();
            System.out.println("el pedido fue agregado exitosamente.");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarPedido(PedidoDetalle pedidoDetalle){
         PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement("DELETE FROM pedido_detalle WHERE id_pedido_detalle = ( ? );");
            ps.setInt(1, pedidoDetalle.getIdPedidoDetalle());
            ps.executeUpdate();
            ps.close();
            System.out.println("El pedido " + pedidoDetalle.getIdPedidoDetalle() + " fue eliminado de la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(MeseroData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
