package Programa_Basico_Alumnos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static final int MAX_ALUMNOS = 5;

    public static void main(String[] args) {
        List<Alumno> listaAlumnos = new ArrayList<>();

        int opt;

        do {
            System.out.println("""
                1.- Introducir un alumno con su nombre, edad y nota.
                2.- Mostrar informacion del alumno.
                3.- Poner nota a un alumno.
                4.- Promedio de alumno.
                5.- Promedio asignatura.
                6.- Salir
                """);
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    if (listaAlumnos.size() >= MAX_ALUMNOS) {
                        System.out.println("No se admiten más alumnos");
                    } else {
                        String nombre;
                        String apellido;
                        String direccion;
                        int telefono;

                        System.out.println("Nombre: ");
                        nombre = sc.nextLine();
                        System.out.println("Apellido: ");
                        apellido = sc.nextLine();
                        System.out.println("Direccion: ");
                        direccion = sc.nextLine();
                        System.out.println("Telefono: ");
                        telefono = sc.nextInt();
                        sc.nextLine();

                        listaAlumnos.add(new Alumno(nombre, apellido, direccion, telefono));
                    }
                    break;
                case 2:
                    for (Alumno a : listaAlumnos) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    String nombreAlumno,
                     apellidoAlumno;

                    System.out.println("Nombre: ");
                    nombreAlumno = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellidoAlumno = sc.nextLine();

                    Alumno alumnoBuscado = buscarAlumno(listaAlumnos, nombreAlumno, apellidoAlumno);

                    if (alumnoBuscado == null) {
                        System.out.println("El alumno no fue encontrado");
                    } else {
                        int asignatura;
                        double nota;

                        System.out.println("""
                                       1.- Java
                                       2.- C++
                                       3.- Python
                                       4.- C#
                                       """);

                        System.out.println("Asignatura: ");
                        asignatura = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Nota: ");
                        nota = sc.nextDouble();
                        sc.nextLine();

                        try {
                            alumnoBuscado.setNotas(asignatura - 1, nota);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4:
                    for (Alumno a : listaAlumnos) {
                        double media = Arrays.stream(a.getNotas()).filter(nota -> nota > -1).average().orElse(-1);

                        System.out.println(a.getNombre() + " " + a.getApellido() + " " + (media == -1 ? "NE " : media));
                    }
                    break;
                case 5:
                    double notaJava = 0;
                    int contJava = 0;

                    double notaCPlus = 0;
                    int contCPlus = 0;

                    double notaPython = 0;
                    int contPython = 0;

                    double notaCSharp = 0;
                    int contCSharp = 0;

                    for (Alumno a : listaAlumnos) {
                        for (int i = 0; i < a.getNotas().length; i++) {
                            try {
                                double nota = a.getNota(i);

                                if (nota > -1) {
                                    switch (i) {
                                        case 0:
                                            notaJava += nota;
                                            contJava++;
                                            break;
                                        case 1:
                                            notaCPlus += a.getNota(i);
                                            contCPlus++;
                                            break;
                                        case 2:
                                            notaPython += a.getNota(i);
                                            contPython++;
                                            break;
                                        case 3:
                                            notaCSharp += a.getNota(i);
                                            contCSharp++;
                                            break;
                                    }
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }

                        }
                    }

                    double mediaJava = notaJava / contJava;
                    double mediaCPlus = notaCPlus / contCPlus;
                    double mediaPython = notaPython / contPython;
                    double mediaCSharp = notaCSharp / contCSharp;

                    System.out.println(String.format("""
                                                 1.- Java : %.2f
                                                 2.- C++ : %.2f
                                                 3.- Python : %.2f
                                                 4.- C# : %.2f
                                                 """, mediaJava, mediaCPlus, mediaPython, mediaCSharp));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error: Opción no válida");
                    break;
            }
        } while (opt != 6);

    }

    static Alumno buscarAlumno(List<Alumno> listaAlumno, String nombre, String apellido) {
        for (Alumno a : listaAlumno) {
            if (a.getNombre().equals(nombre) && a.getApellido().equals(apellido)) {
                return a;
            }
        }

        return null;
    }
}
