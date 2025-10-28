/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

import java.util.ArrayList;

/**
 * Representa la malla curricular: colección de asignaturas asociadas a una carrera.
 */
public class Malla {
    // Lista de asignaturas que componen la malla
    protected ArrayList<Asignatura> nombreAsignatura;

    public Malla() {
        this.nombreAsignatura = new ArrayList<>();
    }

    public ArrayList<Asignatura> getNombreAsignatura() { return nombreAsignatura; }
    public void setNombreAsignatura(ArrayList<Asignatura> nombreAsignatura) { this.nombreAsignatura = nombreAsignatura; }
    
}
