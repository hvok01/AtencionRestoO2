
package atencionresto;


public class Pedido {
    private int id_pedido;
    private int id_mesa;
    private int id_mesero;
    
    public Pedido(int id_pedido,int id_mesa,int id_mesero) {
        this.id_pedido = id_pedido;
        this.id_mesa = id_mesa;
        this.id_mesero = id_mesero;
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
    
}
