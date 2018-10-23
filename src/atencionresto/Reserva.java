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
    private String nombreCliente;
    private int dniCliente;
    private LocalDate fechaHora;
    private boolean estadoVigente;
    private Mesa mesa;

    public Reserva(int idReserva, String nombreCliente, int dniCliente, LocalDate fechaHora, boolean estadoVigente, Mesa mesa) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaHora = fechaHora;
        this.estadoVigente = estadoVigente;
        this.mesa = mesa;
    }

    public Reserva(String nombreCliente, int dniCliente, LocalDate fechaHora, boolean estado, Mesa mesa) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.fechaHora = fechaHora;
        this.estadoVigente = estadoVigente;
        this.mesa = mesa;
    }

    public Reserva() {
    }
    

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
}
