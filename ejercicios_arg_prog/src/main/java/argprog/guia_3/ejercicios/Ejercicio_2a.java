
package argprog.guia_3.ejercicios;

import clases_para_ejercicios.Cifrado;

public class Ejercicio_2a {

    public static void main(String[] args) {
        // TODO code application logic here
        /*
        2. Genere una clase que tenga los métodos para realizar la codificación y decodificación
        de un string, dado un número de desplazamiento.
        ● Por ejemplo, con desplazo de 1:
        “hola que tal” -> “ipmbarvfaubm”
        h -> i
        o -> p
        ● con desplazo de 2
        “hola que tal” -> “jqncbswgbvcn”
        h -> j
        o -> q
        En el ejemplo estoy usando este abecedario: "abcdefghijklmnñopqrstuvwxyz "
        Para este ejercicio puede usar todos los métodos de String, tanto de instancia (por
        ejemplo length) como de clase, por ejemplo String.valueOf(arr) # donde
        arr es un char[]. Tenga a mano los javadocs del mismo
     */
        Cifrado msjSecreto = new Cifrado("hola que tal",2);
        msjSecreto.getMsjCifrado();
        msjSecreto.getMsj();
    }
}
