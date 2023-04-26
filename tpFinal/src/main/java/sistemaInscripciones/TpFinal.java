package sistemaInscripciones;
import clases.Alumno;
import clases.Inscripcion;
import clases.Materia;
import interfazDeUsuario.Gui;
import database.Database;

public class TpFinal {
    public static void main(String[] args) {
        Gui screen = new Gui();
        screen.setVisible(true);
        screen.setTitle("Inscripción a materias");
        screen.setLocationRelativeTo(null);
    }
    public void agregarMateria(){
        //Agrega una materia a la base de datos de materias.
    }
    public void agregarAlumno(){
        //Agrega un Alumno a la base de datos de alumnos.
    }
}
