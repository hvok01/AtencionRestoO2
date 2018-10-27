
package atencionresto;


public class Mesero {
    private int id_mesero;
    private String nombre_mesero;
    private int dni_mesero;
    private boolean estado;
        
        
    public Mesero() {
           
    }
 public Mesero(String nombre_mesero, int dni_mesero, boolean estado) {
        this.nombre_mesero = nombre_mesero;
        this.dni_mesero = dni_mesero;
        this.estado = estado;
    }
    public Mesero(int id_mesero, String nombre_mesero, int dni_mesero, boolean estado) {
        this.id_mesero = 3;
        this.nombre_mesero = nombre_mesero;
        this.dni_mesero = dni_mesero;
        this.estado = estado;
    }


    public int getId_mesero() {
        return id_mesero;
    }

    public void setId_mesero(int id_mesero) {
        this.id_mesero = id_mesero;
    }

    public String getNombre_mesero() {
        return nombre_mesero;
    }

    public void setNombre_mesero(String nombre_mesero) {
        this.nombre_mesero = nombre_mesero;
    }

    public int getDni_mesero() {
        return dni_mesero;
    }

    public void setDni_mesero(int dni_mesero) {
        this.dni_mesero = dni_mesero;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
