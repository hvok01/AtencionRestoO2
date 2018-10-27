
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atencionresto;


public class Mesa {
    private int idMesa;
    private int numMesa;
    private int capacidad;
    private String estado;

    public Mesa(int idMesa, int numMesa, int capacidad, String estado) {
        this.idMesa = idMesa;
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa(int numMesa, int capacidad, String estado) {
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdamesa(int idMesa) {
        this.idMesa= idMesa;
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

    public String estado() {
        return estado;
    }

    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "" + numMesa ;
    }

    
}

