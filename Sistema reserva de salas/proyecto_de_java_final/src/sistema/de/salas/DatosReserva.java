/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

import java.util.ArrayList;
import java.util.Date;

/**
 * Contiene los datos específicos de una reserva: quién la solicitó, estado,
 * fechas/hora asociadas, salas reservadas y la razón de la reserva.
 */
public class DatosReserva {
    private String nombreQuienReserva;
    private boolean estado;
    private Date hora;
    private Date dia;
    private ArrayList<Sala> salas;
    private String razon;
    
    public DatosReserva() {
        this.salas = new ArrayList<>();
    }
    
    public DatosReserva(String nombreQuienReserva, boolean estado, Date hora, Date dia, String razon) {
        this();
        this.nombreQuienReserva = nombreQuienReserva;
        this.estado = estado;
        this.hora = hora;
        this.dia = dia;
        this.razon = razon;
    }
    
    public String getNombreQuienReserva() { return nombreQuienReserva; }
    public void setNombreQuienReserva(String nombreQuienReserva) { this.nombreQuienReserva = nombreQuienReserva; }
    
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    
    public Date getHora() { return hora; }
    public void setHora(Date hora) { this.hora = hora; }
    
    public Date getDia() { return dia; }
    public void setDia(Date dia) { this.dia = dia; }
    
    public ArrayList<Sala> getSalas() { return salas; }
    public void setSalas(ArrayList<Sala> salas) { this.salas = salas; }
    
    public String getRazon() { return razon; }
    public void setRazon(String razon) { this.razon = razon; }
}

    
