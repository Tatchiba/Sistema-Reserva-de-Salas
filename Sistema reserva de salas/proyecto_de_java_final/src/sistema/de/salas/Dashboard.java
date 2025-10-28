/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

import java.util.ArrayList;
import java.util.List;

/**
 * Dashboard: representa una vista o panel que agrupa recursos y reservas para
 * mostrar información (p. ej. en una interfaz). Contiene opciones de visualización.
 */
public class Dashboard {
    // Colección de recursos mostrados en el dashboard
    private List<Recursos> recursos;
    // Lista de reservas que se mostrarán
    private List<Reserva> reservas;
    // Tipo de visualización (valor numérico que puede mapearse a distintos modos)
    private int tipoVisualizacion;
    // Tamaño del dashboard o cantidad de items a mostrar
    private int tamaño;
    // Si el dashboard está visible o no
    private boolean visible;
    
    public Dashboard() {
        this.recursos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    
    /**
     * Constructor que permite configurar modo de visualización, tamaño y visibilidad.
     */
    public Dashboard(int tipoVisualizacion, int tamaño, boolean visible) {
        this();
        this.tipoVisualizacion = tipoVisualizacion;
        this.visible = visible;
        this.tamaño = tamaño;
    }
    
    // Getters y setters para manipular los datos del dashboard
    public List<Recursos> getRecursos() { return recursos; }
    public void setRecursos(List<Recursos> recursos) { this.recursos = recursos; }
    
    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
    
    public int getTipoVisualizacion() { return tipoVisualizacion; }
    public void setTipoVisualizacion(int tipoVisualizacion) { this.tipoVisualizacion = tipoVisualizacion; }
    
    public int getTamaño() { return tamaño; }
    public void setTamaño(int tamaño) { this.tamaño = tamaño; }
    
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
}


