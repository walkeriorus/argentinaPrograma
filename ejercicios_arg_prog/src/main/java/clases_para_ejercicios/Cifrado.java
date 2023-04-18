package clases_para_ejercicios;

/*
a  b  c  d  e  f  g  h  i  j  k  l  m  n  ñ  o  p  q  r  s  t  u  v  w  x  y  z
0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
*/
public class Cifrado {

    static final String ABCEDARIO = "abcdefghijklmnñopqrstuvwxyz";
    static final String[] ARRAY_ABECEDARIO = ABCEDARIO.split("");
    private final String msjOriginal;
    private final String msjCifrado;

    public Cifrado(String frase, int desplazamiento) {
        this.msjOriginal = frase;
        this.msjCifrado = this.codificar(frase, desplazamiento);
    }

    private String codificar(String frase, int desplazamiento) {
        String[] arrayFrase = frase.split("");
        String nuevoMsj = "";
        for (String letra : arrayFrase) {
            int nuevoIndice = Cifrado.ABCEDARIO.indexOf(letra) ;
            System.out.println("letra: "+letra+" nuevoIndice: "+nuevoIndice);
            if( nuevoIndice != -1 ){
                nuevoMsj += Cifrado.ARRAY_ABECEDARIO[nuevoIndice + desplazamiento];
            }
            else{
                nuevoMsj += "#";
            }
            
        }
        return nuevoMsj;
    }
    public void getMsj(){
        System.out.println(this.msjOriginal );
    }
    public void getMsjCifrado(){
        System.out.println(this.msjCifrado);
    }
}
