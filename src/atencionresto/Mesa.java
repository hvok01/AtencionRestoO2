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
public class Mesa {
    private int idMesa;
    private int numMesa;
    private int capacidad;
    private int estadoMesa;

    public Mesa(int idMesa, int numMesa, int capacidad, int estadoMesa) {
        this.idMesa = idMesa;
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estadoMesa = estadoMesa;
    }

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
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

    public int getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(int estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    
}
