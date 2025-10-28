/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

/**
 * Clase base para personas en el sistema (profesores y estudiantes).
 * Define campos comunes que pueden usar las subclases.
 */
public class Persona {
    // Nombre de la persona
    protected String nombre; 
    // Estado booleano para indicar si actualmente tiene una reserva en el horario
    protected Boolean estado; // Si ya tiene reserva en el horario
    // Hora de entrada representada como entero (por ejemplo 8 para 8:00)
    protected int entrada;
    // Hora de salida representada como entero
    protected int salida;
    
}
