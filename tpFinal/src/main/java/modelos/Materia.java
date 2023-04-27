package modelos;
import java.util.List;
import java.util.ArrayList;

public class Materia {
    private final String nombre;
    private List<Materia> correlativas = new ArrayList<>();

    public Materia(String nombreMateria){
        this.nombre = nombreMateria;
    }
    public Materia(String nombreMateria, ArrayList<Materia> correlativas){
        this.nombre = nombreMateria;
        this.correlativas = correlativas;
    }
    public void agregarCorrelativa(String nombreCorrelativa){
        Materia nuevaCorrelativa = new Materia(nombreCorrelativa);
        this.correlativas.add(nuevaCorrelativa);
    }
    public boolean puedeCursar(Alumno estudiante){
        //Un alumno puede cursar una materia si tiene las correlativas correspondientes
        //aprobadas
        int cantidadCorrelativas = this.correlativas.size();//Obtengo cuantas correlativas tiene esta materia
        int correlativasAprobadas = 0;//Aca cuento las correlativas aprobadas del alumno en cuestion
        //Creo un ArrayList con solo los nombres de las materia correlativas
        List<String> materiasCorrelativas = new ArrayList();
        for(Materia materia : this.correlativas ){
            materiasCorrelativas.add(materia.getNombreMateria());
        }
        //Creo un ArrayList con solo los nombres de las materias aprobadas del alumno
        List<String> materiasAprobadasAlumno = new ArrayList();
        for(Materia matAprobada : estudiante.getMateriasAprobadas() ){
            materiasAprobadasAlumno.add(matAprobada.getNombreMateria());
        }
        //Dentro del array con los nombres de las materias aprobadas por el alumno
        //busco si coincide la cantidad de correlativas aprobadas del alumno con
        //la cantidad de materias correlativas que tiene la materia a la que se
        //quiere anotar
        for(String materia : materiasCorrelativas ){
            if(materiasAprobadasAlumno.contains(materia)){
                correlativasAprobadas += 1;
            }
        }
        boolean conclusion = (correlativasAprobadas<cantidadCorrelativas);
        return conclusion ;
    }
    //GETTERS
    public String getNombreMateria(){
        return this.nombre;
    }
    public List<Materia> getCorrelativas(){
        return this.correlativas;
    }
    public String getStringCorrelativas(){
        //Devuelve la lista de correlativas como un único String
        String stringCorrelativas = "";
        List<String> correlativas = new ArrayList<String>();
        for(Materia correlativa : this.correlativas ){
            correlativas.add(correlativa.getNombreMateria());
        }
        //005B y 005D son los códigos unicode para los caracteres [ , ] respectivamente
        stringCorrelativas = correlativas.toString().replaceAll("\\u005B|\\u005D", "");
        correlativas = null;
        return stringCorrelativas;
    }
}