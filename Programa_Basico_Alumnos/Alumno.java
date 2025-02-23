package Programa_Basico_Alumnos;

import java.util.Arrays;

public class Alumno {
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private double promedio;
    private double[] notas;
    
    public Alumno(String nombre, String apellido, String direccion, int telefono, double[] notas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.notas = notas;
    }

    public Alumno(String nombre, String apellido, String direccion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.notas = new double[4];
        Arrays.fill(notas, -1);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double[] getNotas() {
        return this.notas;
    }
    
    public double getNota(int index) throws IllegalArgumentException{
        if (index > notas.length || index < 0){
            throw new IllegalArgumentException("El indice esta fuera del rango de notas");
        } else {
            return this.notas[index] == -1 ? 0 : this.notas[index];
        }
    }

    public void setNotas(int index, double nota) throws IllegalArgumentException {
        if (index > notas.length || index < 0){
            throw new IllegalArgumentException("El indice esta fuera del rango de notas");
        } else {
            this.notas[index] = nota;
        }
    }
    
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double getPromedio() {
        return promedio;
    }

    public void calcularPromedio(double[] notas) {
        this.promedio = Arrays.stream(notas).filter(nota -> nota > -1).average().orElse(0);
    }
    
    @Override
    public String toString() {
        String resultado = "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono + '}' + '\n';
        
        for (double nota : notas) {
            resultado += nota == -1 ? "NE " : Double.toString(nota) + ' ';
        }
        
        return resultado;
    }
}
