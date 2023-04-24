package argprog.guia_4.ejercicios;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ejercicio_2 {

    /*
     * Haga una main donde por parámetro se le envíe la nombre_del_archivo de un
     * archivo. Ese
     * archivo debe contener números.
     * El programa deberá escribir por consola el resultado de la suma de esos
     * números.
     */
    public static void main(String[] args) {
        String rutaEjecucion = System.getProperty("user.dir");//Ruta desde la que se esta ejecutando el script
        Scanner sc = new Scanner(System.in);//Objeto de clase Scanner para leer datos desde la consola
        System.out.println("Ingrese la ruta del archivo que contiene los números...\n");

//        String ruta_principal = "D:\\Cursos\\Argentina Programa 4.0\\Introduccion - Desarrollador Java\\Ejercicios\\ejercicios_arg_prog\\src\\main\\java\\archivos\\";
        String carpeta_de_archivos = "\\src\\main\\java\\archivos\\";
        String nombre_del_archivo = sc.nextLine(); //Guardo la nombre_del_archivo del archivo a leer
        //El objeto Scanner ya lo puedo cerrar
        sc.close();

        String ruta_completa = rutaEjecucion + carpeta_de_archivos + nombre_del_archivo;

        System.out.println("Ruta leída:\n\t\t" + ruta_completa);
        File fileObj = new File(ruta_completa); //Creo un objeto de clase File con la nombre_del_archivo leida
        try {
            sc = new Scanner(fileObj);
            int resultado = 0;
            while (sc.hasNextLine()) {
                int numero_actual = Integer.parseInt(sc.nextLine());
                resultado += numero_actual;
            }
            sc.close();
            System.out.println("El resultado es: " + resultado);
        }
        catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        }

    }

}
