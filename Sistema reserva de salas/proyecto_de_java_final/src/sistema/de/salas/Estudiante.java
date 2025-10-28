/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

/**
 * Representa a un estudiante en el sistema. Hereda de Persona.
 * Contiene información de disponibilidad (entrada/salida) y estado.
 */
public class Estudiante extends Persona {
    // Constructor vacío por defecto
    public Estudiante() {}

    /**
     * Constructor que inicializa campos heredados de Persona.
     * @param nombre nombre del estudiante
     * @param estado si está activo/en reserva
     * @param entrada hora de entrada (entero, p. ej. 8 para 8:00)
     * @param salida hora de salida
     * @param cantidad parámetro no usado en la clase actual (puede representar año/semestre)
     */
    public Estudiante(String nombre, boolean estado, int entrada, int salida, int cantidad) {
        this.nombre = nombre;
        this.estado = estado;
        this.entrada = entrada;
        this.salida = salida;
    }

    // Getters y setters que exponen los campos heredados de Persona
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public int getEntrada() { return entrada; }
    public void setEntrada(int entrada) { this.entrada = entrada; }

    public int getSalida() { return salida; }
    public void setSalida(int salida) { this.salida = salida; }
}


