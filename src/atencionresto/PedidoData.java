package atencionresto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PedidoData {

    private Connection connection = null;
    private Conexion conexion;

    public PedidoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarPedido(int idMesa, int idMesero, double dineroCobrado, LocalDateTime fechaHoraPedido, boolean estado) {

        try {
            String sql = "INSERT INTO pedido (id_mesa, id_mesero, dinero_cobrado, fechaHora_pedido, estado_pedido)"
                    + " VALUES ( ? , ? , ? , ? , ? );";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, idMesa);
                statement.setInt(2, idMesero);
                statement.setDouble(3, dineroCobrado);
                statement.setObject(4, fechaHoraPedido);
                statement.setBoolean(5, estado);

                statement.executeUpdate();

                ResultSet rs = statement.getGeneratedKeys();//id's

                System.out.println("El pedido se agregó exitosamente");

                if (rs.next()) {
                    //  reserva.setIdReserva(rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el id luego de insertar un pedido");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }

    public List<Pedido> obtenerPedidosPendientes() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("SELECT * FROM pedido WHERE estado_pedido = 0;");

            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();

            Pedido nuevoPedido;
            while (resultSet.next()) {
                nuevoPedido = new Pedido();
                nuevoPedido.setId_pedido(resultSet.getInt("id_pedido"));
                nuevoPedido.setId_mesa(resultSet.getInt("id_mesa"));
                nuevoPedido.setId_mesero(resultSet.getInt("id_mesero"));
                nuevoPedido.setDinero_cobrado(resultSet.getDouble("dinero_cobrado"));
                nuevoPedido.setEstado_pedido(resultSet.getBoolean("estado_pedido"));

                pedidos.add(nuevoPedido);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        // System.out.println(pedidos);
        return pedidos;
    }

    public void actualizarPedido(int idMesa) {

        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("UPDATE pedido SET estado_pedido = 1 WHERE id_mesa = ?");
            ps.setInt(1, idMesa);
            ps.executeUpdate();
            ps.close();
            System.out.println("el pedido fue actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pedido> obtenerPedidosEntreFechas(int idMesero, LocalDateTime fechaUno, LocalDateTime fechaDos) {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("SELECT id_pedido , fechaHora_pedido FROM pedido WHERE id_mesero = ? AND fechaHora_pedido "
                    + " BETWEEN ( ? ) AND ( ? ) AND estado_pedido = 1;");
            ps.setInt(1, idMesero);
            ps.setObject(2, fechaUno);
            ps.setObject(3, fechaDos);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();

            Pedido nuevoPedido;
            while (resultSet.next()) {
                nuevoPedido = new Pedido();
                nuevoPedido.setId_pedido(resultSet.getInt("id_pedido"));
                nuevoPedido.setFechaHora_pedido(resultSet.getTimestamp("fechaHora_pedido").toLocalDateTime());

                pedidos.add(nuevoPedido);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Realizado correctamente");
        return pedidos;
    }
    
    public List<Pedido> obtenerPedidosPorMesa (LocalDateTime fechaUno, LocalDateTime fechaDos, int idMesa) {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("SELECT id_pedido , fechaHora_pedido FROM pedido "
                    + " WHERE fechaHora_pedido  BETWEEN ( ? ) AND ( ? ) AND id_mesa = ( ? ) ;");
            ps.setObject(1, fechaUno);
            ps.setObject(2, fechaDos);
            ps.setInt(3, idMesa);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();

            Pedido nuevoPedido;
            while (resultSet.next()) {
                nuevoPedido = new Pedido();
                nuevoPedido.setId_pedido(resultSet.getInt("id_pedido"));
                nuevoPedido.setFechaHora_pedido(resultSet.getTimestamp("fechaHora_pedido").toLocalDateTime());

                pedidos.add(nuevoPedido);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Realizado correctamente");
        return pedidos;
    }

    public List<Pedido> mostrarTotal (LocalDateTime fechaUno, LocalDateTime fechaDos) {
        List<Pedido> total = new ArrayList<Pedido>();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement("SELECT SUM(dinero_cobrado)"
                    + " FROM pedido WHERE fechaHora_pedido BETWEEN ( ? ) AND ( ? );");
            ps.setObject(1, fechaUno);
            ps.setObject(2, fechaDos);
            ps.executeUpdate();
            ResultSet resultSet = ps.executeQuery();
            Pedido p;
            while (resultSet.next()) {
                p = new Pedido();
                p.setTotal(resultSet.getString("SUM(dinero_cobrado)"));
                String sum = resultSet.getString("SUM(dinero_cobrado)");

                total.add(p);
            }
            System.out.println("Realizado correctamente");
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
