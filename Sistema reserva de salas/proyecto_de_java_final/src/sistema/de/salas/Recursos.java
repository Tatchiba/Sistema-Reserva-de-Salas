/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

import java.util.ArrayList;

/**
 * Describe recursos disponibles en un edificio o sala: accesibilidad, baños,
 * cantidad de pizarras y si la sala está reservada solo para carreras específicas.
 */
public class Recursos {
    private boolean accesibleDiscapacitados;
    private boolean banos;
    private int cantidadPizarras;
    private boolean reservadaCarrerasEspecificas;
    private ArrayList<String> carrerasQuePuedenReservar;
    
    public Recursos() {
        this.carrerasQuePuedenReservar = new ArrayList<>();
    }
    
    public Recursos(boolean accesibleDiscapacitados, boolean banos, int cantidadPizarras,
                    boolean reservadaCarrerasEspecificas, ArrayList<String> carrerasQuePuedenReservar) {
        this.accesibleDiscapacitados = accesibleDiscapacitados;
        this.banos = banos;
        this.cantidadPizarras = cantidadPizarras;
        this.reservadaCarrerasEspecificas = reservadaCarrerasEspecificas;
        this.carrerasQuePuedenReservar = carrerasQuePuedenReservar;
    }
    
    public boolean isAccesibleDiscapacitados() { return accesibleDiscapacitados; }
    public void setAccesibleDiscapacitados(boolean accesibleDiscapacitados) { this.accesibleDiscapacitados = accesibleDiscapacitados; }
    
    public boolean isBanos() { return banos; }
    public void setBanos(boolean banos) { this.banos = banos; }
    
    public int getCantidadPizarras() { return cantidadPizarras; }
    public void setCantidadPizarras(int cantidadPizarras) { this.cantidadPizarras = cantidadPizarras; }
    
    public boolean isReservadaCarrerasEspecificas() { return reservadaCarrerasEspecificas; }
    public void setReservadaCarrerasEspecificas(boolean reservadaCarrerasEspecificas) { this.reservadaCarrerasEspecificas = reservadaCarrerasEspecificas; }
    
    public ArrayList<String> getCarrerasQuePuedenReservar() { return carrerasQuePuedenReservar; }
    public void setCarrerasQuePuedenReservar(ArrayList<String> carrerasQuePuedenReservar) { this.carrerasQuePuedenReservar = carrerasQuePuedenReservar; }
}


