/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Vehiculo v1 = new Coche();
        Cliente juan = new Cliente();
        Cliente jose = new Cliente();
        Empresa e1 = new Empresa();
        
        System.out.println(v1.alquilerDia(4));
        juan.alquilarVehiculo(v1, 4);
        e1.matricularVehiculo(v1, 1452);
        juan.alquilarVehiculo(v1, 4);
        jose.alquilarVehiculo(v1, 43);
        juan.darBaja(v1);
    }
}
