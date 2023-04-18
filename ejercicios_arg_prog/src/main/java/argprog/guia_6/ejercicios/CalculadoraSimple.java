package argprog.guia_6.ejercicios;

public class CalculadoraSimple {

    public static void main(String[] args) {
        System.out.println("1) 80 x 3 = " + multiplicar(80,3));
        System.out.println("2)(150 + 180)/3 = " +dividir(sumar(150,180),3) );
        System.out.println("3)(90-50) x 15 = " + multiplicar(restar(90,50),15));
        System.out.println("4)(70 + 40) x 25 = " + multiplicar(sumar(70,40),25));
    }
    public static double sumar(double x, double y){
        double result = x + y;
        return result;
    }
    public static double restar(double x, double y){
        double result = x - y;
        return result;
    }
    public static double multiplicar(double x, double y){
        double result = x * y;
        return result;
    }
    public static double dividir(double x, double y){
        double result = x / y;
        return result;
    }

}
