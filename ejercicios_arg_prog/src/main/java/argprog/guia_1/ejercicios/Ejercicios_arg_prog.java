package argprog.guia_1.ejercicios;

import java.util.Scanner;
public class Ejercicios_arg_prog {
    public static void main(String[] args) {
        int contador = 0;
        Scanner sc = new Scanner( System.in );
        System.out.println("Ingrese una frase o una palabra y presione ENTER\n");
        String texto = sc.nextLine();
        System.out.println("Ingrese la letra que desea buscar y presione ENTER\n");
        String letra = sc.nextLine();
        sc.close();

        for (int i = 0; i < texto.length(); i ++) {
            if( (String.valueOf(texto.charAt(i))).equals(letra) ){
                contador++;
            }
        }
        System.out.println("La letra "+ letra +" aparece " + contador + " veces en el texto ingresado.");
    }
}
