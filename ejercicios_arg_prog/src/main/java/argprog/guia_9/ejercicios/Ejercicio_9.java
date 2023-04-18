package argprog.guia_9.ejercicios;

import clases_para_ejercicios.Persona;

import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio_9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre, apellido, fechaNacimiento;
        System.out.println("¿ Cuantas persona desea crear ?");
        int cantidadPersonas = sc.nextInt();
        ArrayList<Persona> personas = new ArrayList<>();
        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese el nombre de la persona");
            nombre = sc.next();
            System.out.println("Ingrese el apellido de la persona");
            apellido = sc.next();
            System.out.println("Ingrese la fecha de nacimiento de la persona(el formato es DD-MM-AAAA)");
            fechaNacimiento = sc.next();

            personas.add(new Persona(nombre, apellido, fechaNacimiento));
        }

        listarPersonas(personas);
    }

    public static void listarPersonas(ArrayList<Persona> listaPersonas) {
        for (Persona persona : listaPersonas) {
            System.out.println(String.format("Nombre: %s Apellido: %s Fecha de nacimiento: %s", persona.getNombre(), persona.getApellido(), persona.getFechaNacimiento()));
        }
    }

}
