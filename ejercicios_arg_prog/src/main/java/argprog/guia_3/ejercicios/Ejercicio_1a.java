package argprog.guia_3.ejercicios;

import java.util.Scanner;

/*
1. Utilizando solo tipos primitivos, String (solo usar método length), vectores,
iteraciones simples y condicionales, genere una clase por ejercicio que posea los
siguientes métodos:
a. Dado un String y una letra, que cuente la cantidad de apariciones de la letra en
el String
b. Dados 3 números y un orden (ascendente o decreciente) que ordene los
mismos y los retorne en un vector de 3
c. dado un vector de números, y un número X, que sume todos los números > X y
retorne el resultado
 */
public class Ejercicio_1a {
    public static void main(String[] args) {
        /*
    a. Dado un String y una letra, que cuente la cantidad de apariciones de la letra en
el String
         */
        int contador = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase o una palabra y presione ENTER\n");
        String texto = sc.nextLine();
        System.out.println("Ingrese la letra que desea buscar y presione ENTER\n");
        String letra = sc.nextLine();
        sc.close();

        for (int i = 0; i < texto.length(); i++) {
            if ((String.valueOf(texto.charAt(i))).equals(letra)) {
                contador++;
            }
        }
        System.out.println("La letra " + letra + " aparece " + contador + " veces en el texto ingresado.");
    }

}
