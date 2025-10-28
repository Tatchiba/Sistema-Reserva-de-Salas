/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

/**
 * Representa una asignatura con nombre y código identificador.
 */
public class Asignatura {
    // Nombre de la asignatura
    private String nombre;
    // Código único de la asignatura (ej. TA-01)
    private String codigo;
    
    /**
     * Constructor con nombre y código
     */
    public Asignatura(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

