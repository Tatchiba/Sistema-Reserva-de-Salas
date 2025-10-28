/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

public class Reserva {
    private String tipoPersona;
    private String nombre;
    private String rut;
    private String funcion;
    private String edificio;
    private String sala;
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public Reserva(String tipoPersona, String nombre, String rut, String funcion,String edificio, String sala, String fecha, String horaInicio, String horaFin) {
        this.tipoPersona = tipoPersona;
        this.nombre = nombre;
        this.rut = rut;
        this.funcion = funcion;
        this.edificio = edificio;
        this.sala = sala;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getTipoPersona() { return tipoPersona; }
    public void setTipoPersona(String tipoPersona) { this.tipoPersona = tipoPersona; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getFuncion() { return funcion; }
    public void setFuncionOCarrera(String funcion) { this.funcion = funcion; }

    public String getEdificio() { return edificio; }
    public void setEdificio(String edificio) { this.edificio = edificio; }

    public String getSala() { return sala; }
    public void setSala(String sala) { this.sala = sala; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHoraInicio() { return horaInicio; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

    public String getHoraFin() { return horaFin; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }

    // 
    public String toString() {
        return tipoPersona + " | " + nombre + " | " + rut + " | " + funcion + " | Edif. " + edificio + " Sala " + sala + " | " + fecha + " | " + horaInicio + " - " + horaFin;
    }
}