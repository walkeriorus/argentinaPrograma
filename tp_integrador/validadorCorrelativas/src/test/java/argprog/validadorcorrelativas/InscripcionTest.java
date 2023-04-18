package argprog.validadorcorrelativas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class InscripcionTest {

    public InscripcionTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
    @Test
    public void testAprobada() {
        System.out.println("aprobada");
        

        Alumno nuevoAlumno = new Alumno("Facundo Quiroga","8899");
        ArrayList<Materia> aprobadasNuevoAlumno = new ArrayList();
        aprobadasNuevoAlumno.add(new Materia("Matematica I"));
        nuevoAlumno.setMateriasAprobadas(aprobadasNuevoAlumno);
        
        Materia mate_2 = new Materia("Matematica II");
        mate_2.agregarCorrelativa("Matematica I");
        
        Inscripcion instance = new Inscripcion(nuevoAlumno,mate_2 );
        
        
        boolean expResult = true;
        boolean result = instance.aprobada();
        
        assertEquals(expResult, result);
    }
    @Test
    public void testGetMateria() {
        System.out.println("getMateria");
        Inscripcion instance = new Inscripcion(new Alumno("Facundo Quiroga","8899"),new Materia("Matematica I"));
        String materia = "Matematica I";
        String result = instance.getMateria().getNombreMateria();
        assertEquals(materia, result);
    }
    @Test
    public void testGetAlumno() {
        System.out.println("getAlumno");
        Inscripcion instance = new Inscripcion(new Alumno("Facundo Quiroga","8899"),new Materia("Matematica I"));
        String expResult = "Facundo Quiroga";
        String result = instance.getAlumno().getNombreAlumno();
        assertEquals(expResult, result);
    }

}
