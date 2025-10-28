/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

import java.util.ArrayList;

/**
 * Representa un edificio que contiene salas. Guarda información como número de salas,
 * nombre(s) del edificio, piso y accesibilidad.
 */
public class Edificio {
    private int salas;
    // Lista con nombres o identificadores del edificio (puede contener múltiples entradas)
    private ArrayList<String> nombreEdificio;
    private int piso;
    private boolean accesibilidad;
    // Tipo de sala predominante en el edificio (cadena simple)
    private String tipoSala;

    public Edificio() {
        this.nombreEdificio = new ArrayList<>();
    }

    public Edificio(int salas, ArrayList<String> nombreEdificio, int piso, boolean accesibilidad, String tipoSala) {
        this.salas = salas;
        this.nombreEdificio = nombreEdificio;
        this.piso = piso;
        this.accesibilidad = accesibilidad;
        this.tipoSala = tipoSala;
    }

    public int getSalas() { return salas; }
    public void setSalas(int salas) { this.salas = salas; }

    public ArrayList<String> getNombreEdificio() { return nombreEdificio; }
    public void setNombreEdificio(ArrayList<String> nombreEdificio) { this.nombreEdificio = nombreEdificio; }

    public int getPiso() { return piso; }
    public void setPiso(int piso) { this.piso = piso; }

    public boolean isAccesibilidad() { return accesibilidad; }
    public void setAccesibilidad(boolean accesibilidad) { this.accesibilidad = accesibilidad; }

    public String getTipoSala() { return tipoSala; }
    public void setTipoSala(String tipoSala) { this.tipoSala = tipoSala; }
}

