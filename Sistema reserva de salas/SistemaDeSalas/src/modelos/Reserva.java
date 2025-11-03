package modelos;

public class Reserva {
    private Persona persona;
    private String edificio;
    private String sala;
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public Reserva(Persona persona, String edificio, String sala, String fecha, String horaInicio, String horaFin) {
        this.persona = persona;
        this.edificio = edificio;
        this.sala = sala;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Persona getPersona() { return persona; }
    public String getEdificio() { return edificio; }
    public String getSala() { return sala; }
    public String getFecha() { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }

    @Override
    public String toString() {
        return persona.getNombre() + " | " + persona.getFuncionOCarrera() + " | Edificio " + edificio + " | Sala " + sala + " | " + fecha + " " + horaInicio + "-" + horaFin;
    }
}
