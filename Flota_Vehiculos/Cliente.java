/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

/**
 *
 * @author Usuario
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Cliente {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;

    public Cliente(String nombre, String apellido1, String apellido2, String dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        setDni(dni);
    }

    public Cliente() {
        this("Juan", "Rivera", "Ortiz", "11111111A");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        String formato = "\\d{8}[A-Z]{1}";
        Pattern p = Pattern.compile(formato);
        Matcher m = p.matcher(dni);
        
        if (m.matches()){
            this.dni = dni;
        } else {
            System.out.println("DNI no válido");
            this.dni = "11111111A";
        }
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellido1 + " " + apellido2 + " | DNI: " + dni;
    }

    public void alquilarVehiculo(Vehiculo vehiculo, int dias) {
        if (vehiculo.getAlquilador() == null) {
            vehiculo.setAlquilador(this);
        } else {
            System.out.println("Este vehículo ya está alquilado");
        }

    }

    public void darBaja(Vehiculo vehiculo) {
        
    }
    
    

}
