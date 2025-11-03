/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import modelos.Reserva;
import java.io.IOException;
import java.util.List;

public interface IGestorReservas {
    void agregarReserva(Reserva r);
    void eliminarReserva(int indice);
    void mostrarReservas();
    void cargarDatos(String ruta) throws IOException;
    List<Reserva> getReservas();
}
