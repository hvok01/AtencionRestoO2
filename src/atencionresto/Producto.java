
package atencionresto;


public class Producto {
    private int id_producto;
    private double precio;
    private int codigo;
    private int cantidad;
    private String nombre_producto;
    
    public Producto(int id_producto, double precio, int codigo, int cantidad, String nombre_producto) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.nombre_producto = nombre_producto;
    }

    Producto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
     
}
