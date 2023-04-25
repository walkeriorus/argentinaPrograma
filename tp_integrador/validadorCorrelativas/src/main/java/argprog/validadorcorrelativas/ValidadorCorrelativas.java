package argprog.validadorcorrelativas;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Para operaciones con archivos
public class ValidadorCorrelativas {

    public static void main(String[] args) throws IOException {
        List<Materia> materias = new ArrayList<>();
        List<Alumno> alumnos = new ArrayList<>();
        //CREACION DE MATERIAS Y CORRELATIVAS
        Materia fisica = new Materia("Física");
        fisica.agregarCorrelativa("Matematica I");
        fisica.agregarCorrelativa("Matematica II");

        Materia programacion = new Materia("Programación I");
        programacion.agregarCorrelativa("Fundamentos de programación");
        programacion.agregarCorrelativa("Matematica I");

        Materia calculo_3 = new Materia("Calculo III");
        calculo_3.agregarCorrelativa("Calculo I");
        calculo_3.agregarCorrelativa("Calculo II");
        
        Materia calculo_2 = new Materia("Calculo II");
        calculo_2.agregarCorrelativa("Calculo I");

        //
        Materia mateII = new Materia("Matematica II");
        mateII.agregarCorrelativa("Matematica I");

        Materia calculo_1 = new Materia("Calculo I");
        calculo_1.agregarCorrelativa("Matematica I");
        //Materia sin correlativas
        Materia pensamiento = new Materia("Introducción al pensamiento cientifico");
        Materia ingles = new Materia("Ingles");
        //Lista de Materias
        materias.add(fisica);
        materias.add(programacion);
        materias.add(pensamiento);
        materias.add(mateII);
        

        //CREACION ALUMNOS
        Alumno walterPerez = new Alumno("Walter Perez", "7726");
        ArrayList<Materia> aprobadasWalterPerez = new ArrayList<>();
        aprobadasWalterPerez.add(new Materia("Matematica I"));
        aprobadasWalterPerez.add(new Materia("Matematica II"));
        walterPerez.setMateriasAprobadas(aprobadasWalterPerez);
        //
        Alumno gustavoAcuna = new Alumno("Gustavo Acuña", "7727");
        ArrayList<Materia> aprobadasGustavoAcuna = new ArrayList();
        aprobadasGustavoAcuna.add(new Materia("Matematica I"));
        aprobadasGustavoAcuna.add(new Materia("Introducción al pensamiento cientifico"));
        gustavoAcuna.setMateriasAprobadas(aprobadasGustavoAcuna);
        //OTRO ALUMNO - Sin materias aprobadas
        Alumno pedroCuello = new Alumno("Pedro Cuello", "7728");
        //LISTA DE ALUMNOS
        alumnos.add(walterPerez);
        alumnos.add(gustavoAcuna);
        alumnos.add(pedroCuello);

        //CREACION DE INSCRIPCION
        Inscripcion inscripcionWalterPerez = new Inscripcion(walterPerez, fisica);
        Inscripcion inscripcionGustavoAcuna = new Inscripcion(gustavoAcuna, mateII);
        Inscripcion inscripcionPedroCuello = new Inscripcion(pedroCuello, mateII);

        List<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(inscripcionWalterPerez);
        inscripciones.add(inscripcionPedroCuello);
        inscripciones.add(inscripcionGustavoAcuna);

        //
        List<String[]> filasArchivo = new ArrayList<>();
        filasArchivo.add("Alumno,Materia,Estado de solicitud,Fecha".split(","));
        for (Inscripcion inscripcion : inscripciones) {
            //
            String nombreAlumno = inscripcion.getAlumno().getNombreAlumno();
            String materia = inscripcion.getMateria().getNombreMateria();
            String estadoSolicitud;
            if (inscripcion.getMateria().puedeCursar(inscripcion.getAlumno())) {
                estadoSolicitud = "aceptada.";
            }
            else {
                estadoSolicitud = "rechazada.";
            }
              String[] fila =  String.format("%s,%s,%s,%s", nombreAlumno, materia, estadoSolicitud,inscripcion.getFecha()).split(",");
              filasArchivo.add(fila);
        }
        CSVWriter writer = new CSVWriter(new FileWriter("D:\\inscripciones.csv"));
        writer.writeAll(filasArchivo);
        writer.close();

    }
}
