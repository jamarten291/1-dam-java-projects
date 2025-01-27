package FlotaVehiculos;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Vehiculo {
    
    private int id;
    private String marca;
    private String modelo;
    private String bastidor;
    private String color;
    private Cliente alquilador;
    private String matricula = null;

    public Vehiculo(int id, String marca, String modelo, String bastidor, String color, Cliente alquilador) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.color = color;
        this.alquilador = alquilador;
    }

    public Vehiculo(int id, String marca, String modelo, String bastidor, String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.color = color;
        this.alquilador = null;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public String getColor() {
        return color;
    }

    public Cliente getAlquilador() {
        return alquilador;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        String formato = "\\d{4}[A-Z]{3}";
        Pattern p = Pattern.compile(formato);
        Matcher m = p.matcher(matricula);
        if (m.matches()){
            this.matricula = matricula;
        } else {
            System.out.println("Matrícula no válida");
        }
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setAlquilador(Cliente alquilador) {
        if (this.matricula == null){
            System.out.println("No se puede alquilar un vehículo que no está matriculado");
        } else {
            this.alquilador = alquilador;
            System.out.printf("Has alquilado exitosamente el vehículo %s %s\n",this.marca, this.modelo);
        }
    }

    @Override
    public String toString() {
        return id + " | " + marca + " " + modelo + " Bastidor " + bastidor + " de color " + color + " | Matricula: " + matricula + "   ";
    }
    
    public abstract double alquilerDia(int dias);
    
}
