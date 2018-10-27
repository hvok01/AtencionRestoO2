
package atencionresto;

import java.time.LocalDateTime;


public class Pedido {
    private int id_pedido;
    private int id_mesa;
    private int id_mesero;
    private double dinero_cobrado;
    private LocalDateTime fechaHora_pedido;
    private boolean estado_pedido;
    private String total;
    
    public Pedido() {
        
    }
    
    public Pedido(int id_pedido,int id_mesa,int id_mesero,double dinero_cobrado,LocalDateTime fechaHora_pedido,boolean estado_pedido) {
        this.id_pedido = id_pedido;
        this.id_mesa = id_mesa;
        this.id_mesero = id_mesero;
        this.dinero_cobrado = dinero_cobrado;
        this.fechaHora_pedido = fechaHora_pedido;
        this.estado_pedido = estado_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getId_mesero() {
        return id_mesero;
    }

    public void setId_mesero(int id_mesero) {
        this.id_mesero = id_mesero;
    }

    public double getDinero_cobrado() {
        return dinero_cobrado;
    }

    public void setDinero_cobrado(double dinero_cobrado) {
        this.dinero_cobrado = dinero_cobrado;
    }

    public LocalDateTime getFechaHora_pedido() {
        return fechaHora_pedido;
    }

    public void setFechaHora_pedido(LocalDateTime fechaHora_pedido) {
        this.fechaHora_pedido = fechaHora_pedido;
    }

    public boolean getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(boolean estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}
