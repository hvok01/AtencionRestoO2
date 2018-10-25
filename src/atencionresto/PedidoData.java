
package atencionresto;

import java.sql.Connection;


public class PedidoData {
        private Connection connection = null;
    public PedidoData() {
    }
    
    public PedidoData (Conexion conexion) throws ClassNotFoundException {
        connection = conexion.getConexion();
    }
}
