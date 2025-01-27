/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

/**
 *
 * @author Usuario
 */
public class Empresa {
    
    private Vehiculo[] listaVehiculos;
    private Vehiculo[] alquilerV;
    private int contVehiculos = 0;

    public Empresa() {
        this.listaVehiculos = new Vehiculo[10];
        this.alquilerV = new Vehiculo[10];
    }
    
    public void comprarVehiculo(Vehiculo vehiculo){
        listaVehiculos[contVehiculos] = vehiculo;
    }
    
    public void matricularVehiculo(Vehiculo vehiculo, int nuevoID){
        if (vehiculo.getId() == 0){
            vehiculo.setId(nuevoID);
            System.out.printf("La matrícula del vehículo %s %s es: %d",vehiculo.getMarca(), vehiculo.getModelo(),vehiculo.getId());
        } else {
            System.out.println("Este vehículo ya está matriculado");
        }
    }
    
    private void rellenarAlquilerV(){
        int indexAlq = 0;
        
        for (int i = 0; i < alquilerV.length; i++) {
            if (listaVehiculos[i].getId() != 0){
                alquilerV[indexAlq] = listaVehiculos[i];
                indexAlq++;        
            }
        }
        
        alquilerV = new Vehiculo[10];
    }
    
    public void alquilarVehiculo(Vehiculo vehiculo, Cliente alquilador){
        System.out.println("Lista de vehiculos por alquilar: ");
        
        rellenarAlquilerV();
        
        for (Vehiculo va : alquilerV) {
            System.out.println(va);
        }
        
    }
    
}
