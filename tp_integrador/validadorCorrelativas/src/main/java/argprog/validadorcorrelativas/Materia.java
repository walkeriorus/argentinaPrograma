package argprog.validadorcorrelativas;

import java.util.List;
import java.util.ArrayList;

public class Materia {
    private String nombre;
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
        
        for(String materia : materiasCorrelativas ){
            if(materiasAprobadasAlumno.contains(materia)){
                correlativasAprobadas += 1;
            }
        }
        boolean conclusion = (correlativasAprobadas<cantidadCorrelativas)? false : true;
        return conclusion ;
    }
    //GETTERS
    public String getNombreMateria(){
        return this.nombre;
    }
    public List<Materia> getCorrelativas(){
        return this.correlativas;
    }
}
