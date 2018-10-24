/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atencionresto;

import java.time.LocalDate;

/**
 *
 * @author nn
 */
public class Reserva {
    
   private int idReserva;
    private int idMesa;
    private String nombreCliente;
    private int dniCliente;
    private LocalDate fechaHora;
    private boolean estadoVigente;

    public Reserva(int idReserva, int idMesa, String nombreCliente, int dniCliente, LocalDate fechaHora, boolean estadoVigente) {
        this.idReserva = idReserva;
        this.idMesa = idMesa;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaHora = fechaHora;
        this.estadoVigente = estadoVigente;
    }

    public Reserva(int idMesa, String nombreCliente, int dniCliente, LocalDate fechaHora, boolean estadoVigente) {
        this.idMesa = idMesa;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaHora = fechaHora;
        this.estadoVigente = estadoVigente;
    }

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean getEstadoVigente() {
        return estadoVigente;
    }

    public void setEstadoVigente(boolean estadoVigente) {
        this.estadoVigente = estadoVigente;
    }
      
}


