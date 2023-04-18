
package clases_para_ejercicios;
import lombok.Getter;
import lombok.Setter;
public class Persona {
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private String fechaNacimiento;
    public Persona(String nombre, String apellido, String fechaNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }
}
