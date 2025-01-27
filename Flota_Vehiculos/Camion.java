/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

/**
 *
 * @author Usuario
 */
public class Camion extends Vehiculo {

    private double capCarga;

    public Camion(int id, double capCarga, String marca, String modelo, String bastidor, String color) {
        super(id, marca, modelo, bastidor, color);
        this.capCarga = 100.00;
    }
    
    public Camion(int id, String marca, String modelo, String bastidor, String color, String matricula, Cliente alquilador) {
        super(id, marca, modelo, bastidor, color, alquilador);
    }
    
    public Camion(){
        super(1111 ,"Pegaso", "Turbo", "", "Gris", new Cliente());
        this.capCarga = 100.00;
    }
    
    @Override
    public double alquilerDia(int dias) {
        double suma = 0;

        if (this.capCarga > 0) {
            if (this.capCarga <= 1000) {
                suma = 60;
            } else if (this.capCarga <= 2500) {
                suma = 70;
            } else {
                suma = 80;
            }
        } else {
            System.out.println("Capacidad de carga no válida");
        }

        return (60 + suma) * dias;
    }

    @Override
    public String toString() {
        return super.toString() + "Camion{" + "capCarga=" + capCarga + '}';
    }
    
    
    
}
