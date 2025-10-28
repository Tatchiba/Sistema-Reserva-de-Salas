#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    srand(time(NULL));

    int opcion = 0;
    int cantidadReservas = 0;

    do {
        printf("\nGENERADOR DE DATOS DE RESERVAS:\n");
        printf("1. Ingresar cantidad de reservas a generar\n");
        printf("2. Generar archivo datos.csv\n");
        printf("3. Salir\n");
        printf("Eleccion: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1: {
                printf("Ingresa la cantidad de reservas a generar<: ");
                scanf("%d", &cantidadReservas);
                break;
            }

            case 2: {
                if (cantidadReservas <= 0) {
                    printf("Primero ingresa una cantidad valida de reservas (opcion 1)\n");
                    break;
                }

                FILE *archivo = fopen("datos.csv", "w");
                if (archivo == NULL) {
                    printf("Error al crear archivo\n");
                    break;
                }

                // Columnas del CSV
                fprintf(archivo, "tipo_persona,nombre,rut,funcion_o_carrera,edificio,sala,fecha,hora_inicio,hora_fin\n");
                printf("\nGenerando y guardando en archivo 'datos.csv'\n");

                // Datos predefinidos (Despues variar mas,  si se añaden mas se debe cambiar la cantidad por elegir en codigo principal)
                char *nombres[] = {"Juan", "Camila", "Andres", "Valentina", "Matias", "Fernanda", "Sofia", "Felipe"};
                char *apellidos[] = {"Perez", "Soto", "Lopez", "Diaz", "Gomez", "Rojas", "Silva", "Torres"};
                char *funciones[] = {"Docente", "Investigador", "Jefe de carrera"};
                char *carreras[] = {"Arquitectura", "Bachillerato en Derecho: Ciencias Sociales y Humanidades", "Bachillerato en Diseño", "Bachillerato en Enfermería", "Bachillerato en Ingeniería Comercial", "Bachillerato en Psicología", "Ciencia Política y Políticas Públicas", "Cine y Comunicación Audiovisual", "Derecho", "Diseño", "Enfermería", "Geología", "Global Business Administration", "Ingeniería Civil en BioMedicina", "Ingeniería Civil en Informática e Innovación Tecnológica", "Ingeniería Civil en Informática e Inteligencia Artificial", "Ingeniería Civil en Minería", "Ingeniería Civil en Obras Civiles", "Ingeniería Civil Industrial Doble Titulación", "Ingeniería Civil Plan Común", "Ingeniería Comercial", "Kinesiología", "Medicina", "Negocios y Ciencia de Datos", "Nutrición y Dietética", "Obstetricia", "Odontología", "Pedagogía en Educación Básica con Menciones: Inglés y Educación Especial e Inclusión", "Pedagogía en Educación de Párvulos con Menciones: Inglés y Aprendizaje al Aire Libre", "Periodismo y Comunicación Doble Titulación", "Psicología", "Publicidad y Marketing", "Química y Farmacia", "Tecnología Médica", "Terapia Ocupacional"};
                char *edificios[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};

                for (int i = 0; i < cantidadReservas; i++) {
                    // 0=profesor, 1=alumno
                    int tipo = rand() % 2;

                    // Nombre completo
                    char nombreCompleto[40];
                    sprintf(nombreCompleto, "%s %s", nombres[rand() % 8], apellidos[rand() % 8]);

                    // RUT
                    char rut[12];
                    int numeros = 10000000 + (rand() % 90000000); // número de 8 dígitos
                    int digito = rand() % 10;                    // dígito verificador
                    sprintf(rut, "%d-%d", numeros, digito);

                    // Edificio y sala
                    char *edificio = edificios[rand() % 13];
                    int sala = 20 + (rand() % 50); // entre 20 y 50

                    // Fecha
                    int dia = 1 + (rand() % 28);
                    int mes = 10;
                    int anio = 2025;

                    // Horario
                    int horaInicio = 8 +(rand() % 10); // entre 8 y 19 horas
                    int duracion = 1 + (rand() % 3);   // duración 1-3 horas
                    int horaFin = horaInicio + duracion;

                    // Escribir en CSV
                    // Profesor
                    if (tipo == 0) { 
                        char *funcion = funciones[rand() % 3];
                        fprintf(archivo, "Profesor,%s,%s,%s,%s,%d,%d-%02d-%02d,%02d:00,%0d:00\n",
                                nombreCompleto, rut, funcion, edificio, sala, anio, mes, dia, horaInicio, horaFin);
                    }   
                    // Alumno
                    else { 
                        char *carrera = carreras[rand() % 35];
                        fprintf(archivo, "Alumno,%s,%s,%s,%s,%d,%d-%0d-%0d,%0d:00,%0d:00\n",
                                nombreCompleto, rut, carrera, edificio, sala, anio, mes, dia, horaInicio, horaFin);
                    }
                }   
                fclose(archivo);
                printf("Archivo datos.csv generado correctamente con %d reservas.\n", cantidadReservas);
                break;
            }
            case 3: {
                printf("Saliendo...\n");
                break;
            }
            default: {
                printf("Opcion no valida. Intenta de nuevo.\n");
            }
        }
    } while (opcion != 3);
    return 0;
}