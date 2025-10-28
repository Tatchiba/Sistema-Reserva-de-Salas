/*
 * Plantilla generada por NetBeans (encabezado de licencia/template).
 * Mantengo este bloque tal cual; debajo añadiré comentarios explicativos
 * en cada línea del método main para entender el flujo del programa.
 */
package sistema.de.salas;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 *
 * @author Tatchiba
 */

public class SistemaDeSalas {
    
    
    static Scanner entrada = new Scanner(System.in); // System.in es el equivalente a input() de python
                                                     // Scanner viene del paquete Java.util
    static List<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        
        File archivo = new File("../datos.csv");
System.out.println("Cargando CSV desde: " + archivo.getAbsolutePath());

        
        do {
            System.out.println("\nSistema Reserva de Salas");
            System.out.println("1. Cargar datos desde archivo CSV");
            System.out.println("2. Ver reservas");
            System.out.println("3. Eliminar reserva");
            System.out.println("4. Reservar");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            
            try {
            System.out.print("Elija una opcion: ");
                opcion = Integer.parseInt(entrada.nextLine());  // intenta convertir a número
            } 
            catch (Exception e) {
            System.out.println("Error: Debe ingresar solo números enteros.");
            opcion = -1;  // valor inválido para repetir el menú
}

            // Inicialemnte se estaba usando nextInt pero debido a su estructura genera un cambio de linea que no se limpia generando errores despues. 
            // Para solucionar esto se realiza una limpieza con nextLine. Proveniente de Scanner de Java.util


            switch (opcion) {
                case 1:
                    cargarDatos();
                    break;
                case 2:
                    verReservas();
                    break;
                case 3:
                    eliminarReserva();
                    break;
                case 4:
                    añadirReserva();
                    break;    
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente otra vez.");
            }
        } while (opcion != 5);
    }

    static void cargarDatos() {
        File archivo = new File("../datos.csv");

        // Usamos try / catch debido que se solicita para poder leer el archivo un manejo de errores IOException
        // BufferedReader se encarga de cargar los datos de lectura en la memoria en vez de leer por cada caracter
        // Proviene del paquete de Java.io
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            
            reservas.clear(); // Limpiar reservas anteriores
            
            // readLine es un metodo de BufferedReader que devuelve cada linea como un str y sin salto de linea.
            // cuando llega a la ultima linea devuelve un null
            lector.readLine(); // Saltar encabezado. Como es un .CSV, la primera fila corresponde al titulo de las columnas y no debe ser importado como dato
            String linea;
            
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 9) {
                    // Aqui asignamos cada columna a su dato correspondiente en la clase reserva para poder almacenarlo en la lista reservas
                    Reserva r = new Reserva(datos[0], datos[1], datos[2], datos[3],datos[4], datos[5], datos[6], datos[7], datos[8]);
                    reservas.add(r);
                }
            }

            System.out.println("Datos cargados correctamente. Total de reservas: " + reservas.size());

        } catch (IOException e) {
            System.out.println("No se pudo abrir o leer el archivo datos.csv");
        }
    }


    static void verReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas cargadas.");
            return;
        }

        System.out.println("\nLista de reservas");
        for (int i = 0; i < reservas.size(); i++) { // i++: Paso: 1 (i=i+1)
            System.out.println((i + 1) + ". " + reservas.get(i));
        }
    }

    static void eliminarReserva() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas para eliminar.");
            return;
        }

        verReservas();
        System.out.print("Ingrese el numero de reserva a eliminar: ");
        int num = entrada.nextInt();  // lee el número
        entrada.nextLine();           // Limpia

        if (num < 1 || num > reservas.size()) { // ||: significa "or", java no permite usar "or" como operador logico
            System.out.println("Numero inválido.");
        } else {
            reservas.remove(num - 1);
            System.out.println("Reserva eliminada.");
            guardarDatos();
        }
    }
    static void añadirReserva() {
        System.out.println("\nNueva reserva: ");

           String tipoPersona = "";
            while (tipoPersona.isEmpty()) {
                try {
                    System.out.print("Ingrese tipo de persona (Estudiante/Profesor/Otro): ");
                    // .trim() se encarga de eliminar espacios al inicio y final del string
                    tipoPersona = entrada.nextLine().trim();
                    // Esta validacion solo permite caracteres que se encuentran dentro de los corchetes
                    // La forma de leerlo es, de la a hasta la z, de la A hasta la Z. Es decir el abecederio en mayuscula y minuscula
                    // el signo + afuera del corchete indica que debe tener almenos uno o mas de los caracteres
                    // el signo de exclamacion en !tipopersona.matches() es el simbolo de negacion, busca si hay algun carcater que no cumpla el criterio,
                    // si no lo cumple, entonces lo marcara como false, al tener ! pasa a ser true y entra en el bloque del if.
                        if (!tipoPersona.matches("[a-zA-Z ]+")) {
                            // Cuando entra en el if crea un error controlado que nosotros definimos
                            throw new Exception("Debe ingresar solo letras.");
            }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    tipoPersona = "";
        }
    }

        String nombre = "";
        while (nombre.isEmpty()) {
            try {
                System.out.print("Ingrese nombre: ");
                nombre = entrada.nextLine().trim();
                    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        throw new Exception("Debe ingresar solo letras.");
                    }
            } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            nombre = "";
        }
    }

        String rut = "";
        while (rut.isEmpty()) {
            try {
                System.out.print("Ingrese RUT (formato 12345678-9): ");
                rut = entrada.nextLine().trim();
                    if (!rut.matches("\\d{7,8}-[\\dkK]")) {
                        throw new Exception("Formato de RUT invalido. Ejemplo válido: 12345678-9");
                    }
            } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            rut = "";
        }
    }

        String funcion = "";
        while (funcion.isEmpty()) {
            try {
                System.out.print("Ingrese función o carrera: ");
                funcion = entrada.nextLine().trim();
                    if (!funcion.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        throw new Exception("Formato de RUT invalido. Ejemplo válido: 12345678-9");
                    }
            } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            funcion = "";
        }
    }

        String edificio = "";
        while (edificio.isEmpty()) {
            try {
                System.out.print("Ingrese edificio: ");
                edificio = entrada.nextLine().trim();
                    if (!edificio.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
                        throw new Exception("El nombre del edificio solo puede contener letras y numeros.");
                    }
            } catch (Exception e) {
              System.out.println("Error: " + e.getMessage());
              edificio = "";
        }
    }
        String sala = "";
        while (sala.isEmpty()) {
            try {
                System.out.print("Ingrese sala: ");
                sala = entrada.nextLine().trim();
                if (!sala.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ -]+")) {
                    throw new Exception("La sala solo puede contener letras, numeros y guiones.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sala = "";
            }
        }

        String fecha = "";
        while (fecha.isEmpty()) {
            try {
                System.out.print("Ingrese fecha (Anio-Mes-Dia): ");
                fecha = entrada.nextLine().trim();
                if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    throw new Exception("Formato de fecha invalido. Ejemplo: 2025-10-28");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                fecha = "";
            }
        }

        String horaInicio = "";
        while (horaInicio.isEmpty()) {
            try {
                System.out.print("Ingrese hora de inicio (Hora:Minuto): ");
                horaInicio = entrada.nextLine().trim();
                if (!horaInicio.matches("([01]?\\d|2[0-3]):[0-5]\\d")) {
                    throw new Exception("Formato de hora invalido. Ejemplo: 14:30");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                horaInicio = "";
            }
        }
        
        String horaFin = "";
        while (horaFin.isEmpty()) {
            try {
                System.out.print("Ingrese hora de fin (Hora:Minuto): ");
                horaFin = entrada.nextLine().trim();
                if (!horaFin.matches("([01]?\\d|2[0-3]):[0-5]\\d")) {
                    throw new Exception("Formato de hora invalido. Ejemplo: 14:30");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                horaFin = "";
            }
        }

        Reserva nueva = new Reserva(tipoPersona, nombre, rut, funcion, edificio, sala, fecha, horaInicio, horaFin);
        reservas.add(nueva);

        System.out.println("Reserva añadida correctamente. Total de reservas: " + reservas.size());
        guardarDatos();
    }
    
    static void guardarDatos() {
        File archivo = new File("../datos.csv");

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            // Encabezado del CSV
            escritor.write("TipoPersona,Nombre,RUT,Funcion,Edificio,Sala,Fecha,HoraInicio,HoraFin");
            escritor.newLine();

            // Escribir cada reserva
            for (Reserva r : reservas) {
                escritor.write(String.join(",", r.getTipoPersona(), r.getNombre(), r.getRut(),
                                           r.getFuncion(), r.getEdificio(), r.getSala(),
                                           r.getFecha(), r.getHoraInicio(), r.getHoraFin()));
                escritor.newLine();
            }

            System.out.println("Archivo CSV actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo CSV.");
        }
    }
}
    
