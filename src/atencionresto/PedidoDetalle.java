/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atencionresto;

/**
 *
 * @author Administrador
 */
public class PedidoDetalle {
    private int idPedidoDetalle;
    private int cantidadPedidos;

    public PedidoDetalle(int idPedidoDetalle, int cantidadPedidos) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.cantidadPedidos = cantidadPedidos;
    }

    public PedidoDetalle() {
    }

    public int getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(int idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public int getCantidadPedidos() {
        return cantidadPedidos;
    }

    public void setCantidadPedidos(int cantidadPedidos) {
        this.cantidadPedidos = cantidadPedidos;
    }
    
}
