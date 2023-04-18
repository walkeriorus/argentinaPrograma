package argprog.guia_3.ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_1b {
    public static void main(String[] args) {
        /*
        b. Dados 3 números y un orden (ascendente o descendente) que ordene los
mismos y los retorne en un vector de 3.
         */

        int num1;
        int num2;
        int num3;
        int eleccion;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número:");
        num1 = sc.nextInt();
        System.out.println("Ingrese un número:");
        num2 = sc.nextInt();
        System.out.println("Ingrese un número:");
        num3 = sc.nextInt();
        System.out.println("Seleccione una opción:\n1-Mostrar en orden decreciente\n2-Mostrar en orden creciente");
        eleccion = sc.nextInt();
        sc.close();

        int[] numeros = new int[3]; //Creo un array con tres espacios vacíos
        //Ingreso los números en el orden que ingresaron
        numeros[0] = num1;
        numeros[1] = num2;
        numeros[2] = num3;

        int aux;

        if (eleccion == 1) {
            //ordenamiento de mayor a menor(decreciente)
            //Asumimos que el valor mas grande esta en la posicion numeros[0]
            int max;
            max = numeros[0];
            for (int i = 0; i < numeros.length; i++) {
                for (int j = 0; j < numeros.length; j++) {
                    try {
                        if (numeros[j + 1] > numeros[j]) {
                            //Entonces cambio mi máximo
                            max = numeros[j + 1];
                            System.out.println("max: " + max);
                            //Guardo el valor anterior para no perderlo
                            aux = numeros[j];
                            //Cambio los valores dentro del array
                            numeros[j] = max;
                            numeros[j + 1] = aux;
                        }
                    } catch (Exception ArrayIndexOutOfBoundsException) {
//                        System.out.println("Error en iteracion: "+ "i: "+i+" j: "+j);
                    }
                }
            }
        } else if (eleccion == 2) {
            //ordenamiento de menor a mayor(creciente)
            //Asumimos que el valor mas pequeño esta en la posicion numeros[0]
            int min;
            min = numeros[0];
            for (int i = 0; i < numeros.length; i++) {
                for (int j = 0; j < numeros.length; j++) {
                    try {
                        System.out.println("j: " + j);
                        if (numeros[j + 1] < numeros[j]) {
                            //Entonces cambio mi máximo
                            min = numeros[j + 1];
                            //Guardo el valor anterior para no perderlo
                            aux = numeros[j];
                            //Cambio los valores dentro del array
                            numeros[j] = min;
                            numeros[j + 1] = aux;
                        }
                    } catch (Exception ArrayIndexOutOfBoundsException) {
                        //System.out.println("Error en iteracion: "+ "i: "+i+" j: "+j);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(numeros));
    }

}
