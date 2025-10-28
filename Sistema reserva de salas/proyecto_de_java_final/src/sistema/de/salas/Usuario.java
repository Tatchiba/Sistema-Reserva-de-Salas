/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.salas;

/**
 * Clase que representa un usuario del sistema.
 * Contiene datos básicos de contacto e identificación.
 */
public class Usuario {
    // Nombre completo del usuario
    private String nombre;
    // Identificador nacional (RUT/DNI) del usuario
    private String rut;
    // Correo electrónico del usuario
    private String email;

    /**
     * Constructor principal.
     * @param nombre nombre del usuario
     * @param rut identificador (RUT/DNI)
     * @param email correo electrónico
     */
    public Usuario(String nombre, String rut, String email) {
        this.nombre = nombre;
        this.rut = rut;
        this.email = email;
    }

    // Getters y setters: permiten leer y modificar los campos del usuario
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

