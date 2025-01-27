/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlotaVehiculos;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Programa {

    public static int contCoches = 0;
    public static int contClientes = 0;
    public static final int MAX_VEHICULOS = 50;
    public static final int MAX_CLIENTES = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULOS];
        Cliente[] listaClientes = new Cliente[MAX_CLIENTES];

        int opt;

        do {
            System.out.println("""
                           1- Comprar vehículo
                           2- Matricular vehículo
                           3- Alquilar a un cliente
                           4- Obtener listados
                           5- Dar de baja
                           6- Salir
                           """);
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    seleccionVehiculo(sc, listaVehiculos);
                    break;
                case 2:
                    int id1;
                    String matricula;

                    for (Vehiculo v : listaVehiculos) {
                        System.out.printf("%s", Objects.isNull(v) ? "" : v + "\n");
                    }
                    System.out.println("Indica el ID de tu vehículo");
                    id1 = sc.nextInt();
                    sc.nextLine();

                    boolean encontrado1 = false;
                    int cont1 = 0;
                    while (!encontrado1 && cont1 < listaVehiculos.length) {
                        if (listaVehiculos[cont1].getId() == id1 && listaVehiculos[cont1].getMatricula() == null) {
                            encontrado1 = true;
                            System.out.println("Inserta la matrícula");
                            matricula = sc.nextLine();

                            listaVehiculos[cont1].setMatricula(matricula);
                        } else {
                            cont1++;
                        }
                    }

                    break;
                case 3:

                    int opt1;

                    System.out.println("""
                                       ¿Qué deseas?
                                       
                                       1- Agregar nuevo cliente
                                       2- Alquilar a cliente ya existente
                                       """);
                    opt1 = sc.nextInt();
                    sc.nextLine();

                    switch (opt1) {
                        case 1:
                            String nombre;
                            String apellido1;
                            String apellido2;
                            String dni;
                            System.out.println("Introduce el nombre: ");
                            nombre = sc.nextLine();
                            System.out.println("Introduce el primer apellido: ");
                            apellido1 = sc.nextLine();
                            System.out.println("Introduce el segundo apellido: ");
                            apellido2 = sc.nextLine();
                            System.out.println("Introduce el número de DNI: ");
                            dni = sc.nextLine();
                            listaClientes[contClientes] = new Cliente(nombre, apellido1, apellido2, dni);
                            contClientes++;
                            break;
                        case 2:
                            int dias;
                            int id;
                            String dni2;
                            System.out.println("Listado de clientes:");

                            mostrarClientes(listaClientes);

                            System.out.println("Indica el DNI del cliente el cual desea alquilar un vehículo");
                            dni2 = sc.nextLine();

                            boolean encontradoCli = false;
                            int contCli1 = 0;
                            while (!encontradoCli && contCli1 < listaClientes.length) {
                                if (!Objects.isNull(listaClientes[contCli1])) {
                                    if (listaClientes[contCli1].getDni().equals(dni2)) {
                                        encontradoCli = true;
                                    }
                                }
                                contCli1++;
                            }
                            System.out.println("Indica el vehiculo que quieres alquilar (indicar su ID)");
                            mostrarVehiculos(listaVehiculos);

                            id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Indica cantidad de días de alquiler");
                            dias = sc.nextInt();
                            sc.nextLine();
                            boolean encontrado2 = false;
                            int cont2 = 0;
                            while (!encontrado2 && cont2 < listaVehiculos.length) {
                                if (!Objects.isNull(listaVehiculos[cont2])) {
                                    if (listaVehiculos[cont2].getId() == id) {
                                        encontrado2 = true;
                                        listaClientes[contCli1 - 1].alquilarVehiculo(listaVehiculos[cont2], dias);
                                    }
                                }
                                cont2++;
                            }
                            break;
                        default:
                            System.out.println("Opción inválida, intenta de nuevo");
                            break;
                    }

                    break;

                case 4:
                    int opt2;

                    System.out.println("""
                                       Indica la opción que deseas elegir:
                                       
                                       1- Todos los vehículos (precio de alquiler/día incluído)
                                       2- Vehículos en alquiler
                                       3- Clientes y sus vehículos alquilados + coste total alquiler
                                       """);
                    opt2 = sc.nextInt();
                    sc.nextLine();

                    switch (opt2) {
                        case 1:
                            int cont3 = 0;
                            while (cont3 < listaVehiculos.length) {
                                if (!Objects.isNull(listaVehiculos[cont3])) {
                                    System.out.printf("%s | Alquiler/dia: %.2f\n", listaVehiculos[cont3], listaVehiculos[cont3].alquilerDia(1));
                                }
                                cont3++;
                            }
                            break;
                        case 2:
                            int cont4 = 0;
                            while (cont4 < listaVehiculos.length) {
                                if (!Objects.isNull(listaVehiculos[cont4])) {
                                    if (listaVehiculos[cont4].getAlquilador() != null) {
                                        System.out.println(listaVehiculos[cont4]);
                                    }
                                }
                                cont4++;
                            }
                            break;
                        case 3:
                            int cont5Cli = 0;
                            while (cont5Cli < listaClientes.length) {
                                if (!Objects.isNull(listaClientes[cont5Cli])) {
                                    float precioTotal = 0;
                                    System.out.printf("%s | Vehiculos alquilados: \n", listaClientes[cont5Cli]);
                                    int cont5 = 0;
                                    while (cont5 < listaVehiculos.length) {
                                        if (!Objects.isNull(listaVehiculos[cont5])) {
                                            if (listaVehiculos[cont5].getAlquilador().equals(listaClientes[cont5Cli])) {
                                                precioTotal += listaVehiculos[cont5].alquilerDia(1);
                                                System.out.printf("%s \n", listaVehiculos[cont5]);
                                            }
                                        }
                                        cont5++;
                                    }
                                    System.out.printf("\nPrecio total de alquiler por día: %.2f\n", precioTotal);
                                }
                                cont5Cli++;
                            }
                            break;
                        default:
                            System.out.println("Opción inválida, intenta de nuevo");
                    }
                    break;
                case 5:
                    String dniDel;

                    System.out.println("Listado de clientes:");
                    mostrarClientes(listaClientes);

                    System.out.println("Indica el DNI del cliente que deseas borrar");
                    dniDel = sc.nextLine();

                    boolean encontrado6 = false;
                    int cont6 = 0;
                    while (!encontrado6 && cont6 < listaClientes.length) {
                        if (!Objects.isNull(listaClientes[cont6])) {
                            if (listaClientes[cont6].getDni().equals(dniDel)) {
                                listaClientes[cont6] = null;
                                encontrado6 = true;
                            }
                        }
                        cont6++;
                    }

                    break;
                case 6:
                    break;
                default:
                    System.out.println("Carácter no válido, intenta de nuevo");
            }
        } while (opt != 6);

    }

    public static void seleccionVehiculo(Scanner sc, Vehiculo[] vehiculos) {
        int idCoche;
        String marca;
        String modelo;
        String bastidor;
        String color;
        int tipoVehiculo;

        System.out.println("ID del vehículo");
        idCoche = sc.nextInt();
        sc.nextLine();
        System.out.println("Marca del vehículo");
        marca = sc.nextLine();
        System.out.println("Modelo del vehículo");
        modelo = sc.nextLine();
        System.out.println("Bastidor del vehículo");
        bastidor = sc.nextLine();
        System.out.println("Color del vehículo");
        color = sc.nextLine();

        System.out.println("""
                                       Indica el tipo:
                                       
                                       1- Coche
                                       2- Furgoneta
                                       3- Camion
                                       """);
        tipoVehiculo = sc.nextInt();
        sc.nextLine();

        switch (tipoVehiculo) {
            case 1:
                int numPlazas1;
                String grupoAux;
                Grupo grupo = null;
                System.out.println("Indica el numero de plazas");
                numPlazas1 = sc.nextInt();
                sc.nextLine();

                System.out.println("Indica el grupo: (BASICO, BERLINA o LUJO)");
                grupoAux = sc.nextLine().toUpperCase().trim();

                switch (grupoAux) {
                    case "BASICO":
                        grupo = Grupo.BÁSICO;
                        break;
                    case "BERLINA":
                        grupo = Grupo.BERLINA;
                        break;
                    case "LUJO":
                        grupo = Grupo.LUJO;
                        break;
                    default:
                        System.out.println("Grupo incorrecto, intenta de nuevo");
                }

                vehiculos[contCoches] = new Coche(idCoche, numPlazas1, grupo, marca, modelo, bastidor, color);
                contCoches++;
                break;

            case 2:
                int capCarga2;
                int numPlazas2;
                System.out.println("Indica el numero de plazas");
                numPlazas2 = sc.nextInt();
                sc.nextLine();
                System.out.println("Indica la capacidad de carga");
                capCarga2 = sc.nextInt();
                sc.nextLine();

                vehiculos[contCoches] = new Furgoneta(idCoche, numPlazas2, capCarga2, marca, modelo, bastidor, color);
                contCoches++;
                break;
            case 3:
                int capCarga3;
                System.out.println("Indica la capacidad de carga");
                capCarga3 = sc.nextInt();
                sc.nextLine();

                vehiculos[contCoches] = new Camion(idCoche, capCarga3, marca, modelo, bastidor, color);
                contCoches++;
                break;
            default:
                System.out.println("Tipo no disponible");
        }
    }

    public static void mostrarClientes(Cliente[] listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.printf("%s", Objects.isNull(cliente) ? "" : cliente + "\n");
        }
    }

    public static void mostrarVehiculos(Vehiculo[] listaVehiculos) {
        for (Vehiculo v : listaVehiculos) {
            System.out.printf("%s", Objects.isNull(v) ? "" : v + "\n");
        }
    }
}
