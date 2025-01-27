/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

/**
 *
 * @author Usuario
 */
public class Furgoneta extends Vehiculo {

    private int numPlazas;
    private double capCarga;

    public Furgoneta(int id, int numPlazas, double capCarga, String marca, String modelo, String bastidor, String color) {
        super(id, marca, modelo, bastidor, color);
        this.numPlazas = 5;
        this.capCarga = 500;
    }

    public Furgoneta(int id, String marca, String modelo, String bastidor, String color, String matricula, Cliente alquilador) {
        super(id, marca, modelo, bastidor, color, alquilador);
    }

    public Furgoneta() {
        super(1111, "Renault", "Trafic", "", "Blanco", null);
        this.numPlazas = 5;
        this.capCarga = 500;
    }

    @Override
    public double alquilerDia(int dias) {
        double precio = 60 + numPlazas * 3;
        double suma = 0;

        if (this.capCarga > 0) {
            if (this.capCarga <= 500) {
                suma = 20;
            } else if (this.capCarga <= 1000) {
                suma = 50;
            } else {
                suma = 60;
            }
        } else {
            System.out.println("Capacidad de carga no válida");
        }

        return (precio + suma) * dias;
    }

    @Override
    public String toString() {
        return super.toString() + "Furgoneta{" + "numPlazas=" + numPlazas + ", capCarga=" + capCarga + '}';
    }

    
    
}
