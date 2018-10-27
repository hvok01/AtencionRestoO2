
package atencionresto;


public class Producto {
    private int id_producto;
    private double precio;
    private int codigo;
    private String nombre_producto;
    
    public Producto(int id_producto, double precio, int codigo, String nombre_producto) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.codigo = codigo;
        this.nombre_producto = nombre_producto;
    }

    public Producto() {
        
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

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
     
    
}
