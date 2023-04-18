package argprog.guia_1.ejercicios;
/*
 * 1.Vamos a practicar operaciones básicas con números a. Utilizando la
 * sentencia while, imprima todos los números entre 2 variables “a” y “b”. Su
 * código puede arrancar (por ejemplo): int numeroInicio = 5; int numeroFin =
 * 14; Se deberían mostrar los números: 5,6,7,8,9,10,11,12,13,14 b) A lo
 * anterior, solo muestre los números pares c) A lo anterior, con una variable
 * extra, elija si se deben mostrar los números pares o impares d) Utilizando la
 * sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden * *
 */
import java.util.Scanner;

public class Ejercicio_1 {
//    public static void main(String[] args) {
//        //1.a)
//        int inicio;
//        int fin;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("En qué número desea iniciar?");
//        inicio = sc.nextInt();
//        System.out.println("");
//        System.out.println("En qué número desea parar?");
//        fin = sc.nextInt();
//        System.out.println("");
//        sc.close();
//
//        while( inicio <= fin ){
//            System.out.println("Número: ".concat(String.valueOf(inicio)));
//            inicio++ ;
//        }
//    }
//    public static void main(String[] args) {
//        //Ejercicio 1.b:
//        /*
//        b) A lo anterior, que solo muestre los números pares
//         */
//        int inicio;
//        int fin;
//        boolean paridad;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("En qué número desea iniciar?");
//        inicio = sc.nextInt();
//        System.out.println("");
//        System.out.println("En qué número desea parar?");
//        fin = sc.nextInt();
//        System.out.println("");
//        sc.close();
//
//        while (inicio <= fin) {
//            paridad = inicio % 2 == 0;
//            if (paridad) {
//                System.out.println("Número: ".concat(String.valueOf(inicio)));
//            }
//
//            inicio++;
//        }
//    }
//    public static void main(String[] args) {
//        //c) A lo anterior, con una variable extra, elija si se deben mostrar los números pares o impares
//        int inicio;
//        int fin;
//        boolean paridad;
//        int eleccion;
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("En qué número desea iniciar?");
//        inicio = sc.nextInt();
//        System.out.println("");
//        System.out.println("En qué número desea parar?");
//        fin = sc.nextInt();
//        System.out.println("");
//        System.out.println("A continuación elija una opción:\n1-Mostrar solo número pares\n2-Mostrar solo números impares");
//        eleccion = sc.nextInt();
//        sc.close();
//        //
//        while( inicio <= fin ){
//
//            paridad = inicio % 2 == 0;
//            switch( eleccion ){
//                case 1 :
//
//                    if( paridad ){
//                        System.out.println("Número" + " " + inicio );
//                    }
//                    break;
//                case 2:
//                    if( !paridad ){
//                        System.out.println("Número" +" " + inicio );
//                    }
//                    break;
//                default:
//                    System.out.println("Opción inválida.");
//                    break;
//            }
//            inicio++;
//        }
//
//    }
    public static void main(String[] args) {
        //1.d) Utilizando la sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden
        int inicio;
        int fin;
        boolean paridad;
        Scanner sc = new Scanner(System.in);
        System.out.println("En qué número desea iniciar?");
        inicio = sc.nextInt();
        System.out.println("");
        System.out.println("En qué número desea parar?");
        fin = sc.nextInt();
        System.out.println("");
        sc.close();

        for(int i = fin; i >= inicio; i--){
            paridad = i % 2 == 0;
            if (paridad) {
                System.out.println("Número: ".concat(String.valueOf(i)));
            }
        }
    }
}
