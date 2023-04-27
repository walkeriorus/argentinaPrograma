package modelos;
import java.util.List;
import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas = new ArrayList<>();


    public Alumno(String nombre, String legajo){
        this.nombre = nombre;
        this.legajo = legajo;
    }
    public Alumno(String nombre, String legajo, ArrayList<Materia> materiasAprobadas){
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }
    public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas){
        this.materiasAprobadas = materiasAprobadas;
    }
    //GETTERS
    public String getLegajo(){
        return this.legajo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public List<Materia> getMateriasAprobadas(){
        return this.materiasAprobadas;
    }
    public String getStringAprobadas(){
        String stringMateriasAprobadas = "";
        List<String> aprobadas = new ArrayList<String>();
        for(Materia materia : this.materiasAprobadas ){
            aprobadas.add(materia.getNombreMateria());
        }
        //005B y 005D son los códigos unicode para los caracteres [ , ] respectivamente
        stringMateriasAprobadas = aprobadas.toString().replaceAll("\\u005B|\\u005D", "");
        aprobadas = null;
        return stringMateriasAprobadas;
    }
    //SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setLegajo(String legajo){
        this.legajo = legajo;
    }
}