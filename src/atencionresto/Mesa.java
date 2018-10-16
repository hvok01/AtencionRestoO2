
package atencionresto;


public class Mesa {
    private int idMesa;
    private int numMesa;
    private int capacidad;
    private boolean estado;

    public Mesa(int idamesa, int numMesa, int capacidad, boolean estado) {
        this.idMesa = idamesa;
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa(int numMesa, int capacidad, boolean estado) {
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdamesa(int idamesa) {
        this.idMesa = idMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
