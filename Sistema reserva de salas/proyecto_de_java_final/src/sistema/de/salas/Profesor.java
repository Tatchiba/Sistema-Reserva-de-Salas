/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

/**
 * Representa a un profesor. Hereda campos comunes de Persona y añade la asignatura
 * que imparte.
 */
public class Profesor extends Persona{
    // Asignatura que imparte el profesor
    private String asignatura;

    public Profesor() {}

    /**
     * Constructor que inicializa la asignatura y campos heredados.
     */
    public Profesor(String asignatura, String nombre, boolean estado, int entrada, int salida) {
        this.asignatura = asignatura;
        this.nombre = nombre;
        this.estado = estado;
        this.entrada = entrada;
        this.salida = salida;
    }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    // Getters y setters heredados reutilizados para exponer comportamiento público
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public int getEntrada() { return entrada; }
    public void setEntrada(int entrada) { this.entrada = entrada; }

    public int getSalida() { return salida; }
    public void setSalida(int salida) { this.salida = salida; }
}


