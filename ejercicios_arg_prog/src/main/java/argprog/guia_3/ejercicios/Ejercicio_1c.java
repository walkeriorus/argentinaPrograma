package argprog.guia_3.ejercicios;

import java.util.Scanner;

public class Ejercicio_1c {

    public static void main(String[] args) {
        // c. dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de números: ");
        int dimensionArray = sc.nextInt();
        int[] numeros = new int[dimensionArray];

        for(int pos = 0; pos<numeros.length; pos++){
            System.out.println("Ingrese un número: ");
            numeros[pos] = sc.nextInt();
        }
        

        System.out.println("Ingrese un número(se sumarán los nºs mayores al ingresado y se devolvera el resultado) ");
        int filtro = sc.nextInt();
        sc.close();

        int resultado = sumarMayores(numeros, filtro);
        System.out.println("El resultado es: " + resultado);
    }
    public static int sumarMayores(int[] numeros, int filtro ){
        int suma=0;
        for(int numero : numeros ){
            if(numero>filtro){
                suma += numero;
            }
        }
        return suma;
    }

}
