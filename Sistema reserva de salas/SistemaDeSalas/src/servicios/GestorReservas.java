package servicios;

import interfaces.IGestorReservas;
import modelos.DatosStatic;
import modelos.Reserva;
import modelos.Persona;
import modelos.Alumno;
import modelos.Profesor;
import java.io.*;
import java.util.*;



public class GestorReservas implements IGestorReservas {
    private List<Reserva> reservas;
    private DatosStatic datos;

    public GestorReservas(DatosStatic datos) {
        this.datos = datos;
        this.reservas = new ArrayList<>();
    }

    @Override
    public void agregarReserva(Reserva r) {
        reservas.add(r);
        actualizarCSV();
        System.out.println("Reserva agregada correctamente.");
    }

    @Override
    public void eliminarReserva(int indice) {
        if(indice >= 0 && indice < reservas.size()) {
            reservas.remove(indice);
            actualizarCSV();
            System.out.println("Reserva eliminada correctamente.");
        } else {
            System.out.println("Indice invalido.");
        }
    }

    @Override
    public void mostrarReservas() {
        if(reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }
        for(int i=0;i<reservas.size();i++) {
            System.out.println(i + ". " + reservas.get(i));
        }
    }

    @Override
    public void cargarDatos(String ruta) throws IOException {
        reservas = LectorCSV.cargarReservas(ruta);
    }

    @Override
    public List<Reserva> getReservas() {
        return reservas;
    }

    private void actualizarCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Reservas.csv"))) {
            bw.write("TipoPersona,Nombre,RUT,Funcion,Edificio,Sala,Fecha,HoraInicio,HoraFin\n");
            for(Reserva r: reservas) {
                bw.write((r.getPersona() instanceof Alumno ? "Alumno" : "Profesor") + ","
                        + r.getPersona().getNombre() + ","
                        + r.getPersona().getRut() + ","
                        + r.getPersona().getFuncionOCarrera() + ","
                        + r.getEdificio() + ","
                        + r.getSala() + ","
                        + r.getFecha() + ","
                        + r.getHoraInicio() + ","
                        + r.getHoraFin() + "\n");
            }
        } catch(IOException e) {
            System.out.println("Error al actualizar Reservas.csv: " + e.getMessage());
        }
    }
}
