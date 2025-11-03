import modelos.*;
import servicios.*;
import interfaces.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaDatosStatic = "../DatosStatic.csv";
        String rutaReservas = "../Reservas.csv";

        DatosStatic datosStatic = LectorCSV.cargarDatosStatic(rutaDatosStatic);
        IGestorReservas gestor = new GestorReservas(datosStatic);
        try {
            gestor.cargarDatos(rutaReservas);
        } catch (Exception e) {
            System.out.println("Error cargando reservas: " + e.getMessage());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while(true){
            System.out.println("\nMenu");
            System.out.println("1. Mostrar reservas");
            System.out.println("2. Crear nueva reserva");
            System.out.println("3. Eliminar reserva");
            System.out.println("4. Salir");
            System.out.print("Elige opcion: ");
            int op = sc.nextInt(); sc.nextLine();

            switch(op){
                case 1:
                    gestor.mostrarReservas();
                    break;
                case 2:
                    // Tipo persona
                    System.out.println("Tipo de persona:\n1. Alumno\n2. Profesor");
                    int tipo = sc.nextInt(); sc.nextLine();

                    // Nombre
                    String nombre = "";
                    while(nombre.isEmpty()){
                        System.out.print("Ingrese nombre: ");
                        nombre = sc.nextLine().trim();
                        if(!Validador.validarNombre(nombre)){ System.out.println("Nombre invalido."); nombre=""; }
                    }

                    // RUT
                    String rut = "";
                    while(rut.isEmpty()){
                        try{
                            System.out.print("Ingrese RUT (12345678-9): ");
                            rut = sc.nextLine().trim();
                            if(!Validador.validarRUT(rut)) throw new Exception("RUT invalido");
                        } catch(Exception e){ System.out.println("Error: "+e.getMessage()); rut=""; }
                    }

                    // Funcion o Carrera
                    String funcionOCarrera = "";
                    if(tipo==1){ // Alumno
                        List<String> carreras = datosStatic.getCarreras();
                        for(int i=0;i<carreras.size();i++) System.out.println(i + ". " + carreras.get(i));
                        int c=-1;
                        while(c<0 || c>=carreras.size()){ System.out.print("Elige carrera: "); c=sc.nextInt(); sc.nextLine(); }
                        funcionOCarrera = carreras.get(c);
                    } else { // Profesor
                        List<String> funciones = datosStatic.getFunciones();
                        for(int i=0;i<funciones.size();i++) System.out.println(i + ". " + funciones.get(i));
                        int f=-1;
                        while(f<0 || f>=funciones.size()){ System.out.print("Elige funcion: "); f=sc.nextInt(); sc.nextLine(); }
                        funcionOCarrera = funciones.get(f);
                    }

                    // Edificio
                    List<String> edificios = datosStatic.getEdificios();
                    for(int i=0;i<edificios.size();i++) System.out.println(i + ". " + edificios.get(i));
                    int e=-1;
                    while(e<0 || e>=edificios.size()){ System.out.print("Elige edificio: "); e=sc.nextInt(); sc.nextLine(); }
                    String edificioElegido = edificios.get(e);

                    // Sala
                    List<String> salas = datosStatic.getSalas();
                    for(int i=0;i<salas.size();i++) System.out.println(i + ". " + salas.get(i));
                    int s=-1;
                    while(s<0 || s>=salas.size()){ System.out.print("Elige sala: "); s=sc.nextInt(); sc.nextLine(); }
                    String salaElegida = salas.get(s);

                    // Fecha
                    Calendar hoy = Calendar.getInstance();
                    List<String> fechas = new ArrayList<>();
                    for(int i=0;i<7;i++){
                        Calendar cal = (Calendar)hoy.clone();
                        cal.add(Calendar.DAY_OF_MONTH, i);
                        fechas.add(sdf.format(cal.getTime()));
                        System.out.println(i + ". " + sdf.format(cal.getTime()));
                    }
                    int fIndex=-1;
                    while(fIndex<0 || fIndex>=fechas.size()){ System.out.print("Elige fecha: "); fIndex=sc.nextInt(); sc.nextLine(); }
                    String fechaElegida = fechas.get(fIndex);

                    // Hora
                    List<String> horasDisponibles = new ArrayList<>();
                    for(int h=8;h<20;h++){
                        boolean ocupada=false;
                        for(Reserva r: gestor.getReservas()){
                            if(r.getEdificio().equals(edificioElegido) &&
                               r.getSala().equals(salaElegida) &&
                               r.getFecha().equals(fechaElegida) &&
                               r.getHoraInicio().equals(h + ":00")){
                                ocupada=true; break;
                            }
                        }
                        if(!ocupada) horasDisponibles.add(h + ":00");
                    }

                    if(horasDisponibles.isEmpty())
                    { System.out.println("No hay horas disponibles para esta sala en esta fecha."); break; }

                    for(int i=0;i<horasDisponibles.size();i++) System.out.println(i + ". " + horasDisponibles.get(i));
                    int hIndex=-1;
                    while(hIndex<0 || hIndex>=horasDisponibles.size()){ System.out.print("Elige hora inicio: "); hIndex=sc.nextInt(); sc.nextLine(); }
                    String horaInicio = horasDisponibles.get(hIndex);
                    int hInicioInt = Integer.parseInt(horaInicio.split(":")[0]);
                    String horaFin = (hInicioInt+1)+":00";

                    Persona persona = (tipo==1) ? new Alumno(nombre,rut,funcionOCarrera) : new Profesor(nombre,rut,funcionOCarrera);
                    Reserva reserva = new Reserva(persona,edificioElegido,salaElegida,fechaElegida,horaInicio,horaFin);
                    gestor.agregarReserva(reserva);
                    break;

                case 3:
                    gestor.mostrarReservas();
                    System.out.print("Elige indice a eliminar: ");
                    int ind = sc.nextInt(); sc.nextLine();
                    gestor.eliminarReserva(ind);
                    break;

                case 4:
                    System.out.println("Fin");
                    return;
            }
        }
    }
}
