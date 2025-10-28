/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

/**
 * Representa una sala física donde se realizan actividades (clase, laboratorio, etc.).
 */
public class Sala {
    // Asignatura asociada a la sala (si aplica)
    private String asignatura;
    // Representa disponibilidad en un formato entero (ej. capacidad o franja)
    private int horarioDisponible;
    // Flag simple para indicar un tipo (en este diseño booleano, aunque podría ser enum)
    private boolean tipoSala;
    // Indica si la sala está actualmente reservada
    private boolean reserva;

    public Sala() {}

    public Sala(String asignatura, int horarioDisponible, boolean tipoSala, boolean reserva) {
        this.asignatura = asignatura;
        this.horarioDisponible = horarioDisponible;
        this.tipoSala = tipoSala;
        this.reserva = reserva;
    }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public int getHorarioDisponible() { return horarioDisponible; }
    public void setHorarioDisponible(int horarioDisponible) { this.horarioDisponible = horarioDisponible; }

    public boolean isTipoSala() { return tipoSala; }
    public void setTipoSala(boolean tipoSala) { this.tipoSala = tipoSala; }

    public boolean isReserva() { return reserva; }
    public void setReserva(boolean reserva) { this.reserva = reserva; }
}

