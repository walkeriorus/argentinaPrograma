package modelos;
import java.time.LocalDate;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private LocalDate fecha;

    public Inscripcion(Alumno alumno, Materia materia){
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = LocalDate.now();
    }
    public Inscripcion(Alumno alumno, Materia materia,int[] fecha ){
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = LocalDate.of(fecha[0],fecha[1],fecha[2]);//of(year, month, day)
    }

    public boolean aprobada(){
        //Devuelve true si la inscripcion fue aprobada, sino devuelve false
        if(this.materia.puedeCursar(this.alumno)){
            return true;
        }else{return false;}

    }
    //GETTERS
    public Materia getMateria(){
        return this.materia;
    }
    public String getFecha(){
        return this.fecha.toString();
    }
    public Alumno getAlumno(){
        return this.alumno;
    }
}