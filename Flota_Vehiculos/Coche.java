/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

/**
 *
 * @author Usuario
 */

public class Coche extends Vehiculo {
    
    private int numPlazas;
    private Grupo grupo;

    public Coche(int id, int numPlazas, Grupo grupo, String marca, String modelo, String bastidor, String color) {
        super(id, marca, modelo, bastidor, color);
        this.numPlazas = numPlazas;
        this.grupo = Grupo.BÁSICO;
    }
    
    public Coche(){
        super(1111, "Ford", "Focus", "", "Azul", null);
        this.numPlazas = 4;
        this.grupo = Grupo.BÁSICO;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    @Override
    public double alquilerDia(int dias){
        double precio = 50 + numPlazas * 5;
        double porcentaje = 1;
        
        if (this.grupo.equals(Grupo.BERLINA)){
            porcentaje += 0.15;
        } else if (this.grupo.equals(Grupo.LUJO)){
            porcentaje += 0.30;
        }
        
        return (precio * porcentaje) * dias;
    }

    @Override
    public String toString() {
        return super.toString() + "Coche{" + "numPlazas=" + numPlazas + ", grupo=" + grupo + '}';
    }
    
}
