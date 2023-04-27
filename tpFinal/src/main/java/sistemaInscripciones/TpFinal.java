package sistemaInscripciones;

import modelos.Alumno;
import modelos.Inscripcion;
import modelos.Materia;
import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//IMPORTS SIN USAR
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.sql.Connection;
//import java.util.regex.Pattern;

public class TpFinal {
    public static void agregarMateria(String nombre_materia) {
        Database db = new Database();
        db.conectar();
        Materia materia_nueva = new Materia(nombre_materia);
        //
        String sql = String.format("INSERT INTO `%s`.materias(nombre,correlativas) VALUES (\"%s\",\"\")", db.getDBName(), nombre_materia);
        System.out.println("SQL: " + sql);
        Statement stmt = db.getStatement();
        try {
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlExcept) {
            System.out.println("No se pudo ejecutar el código sql.");
            System.out.println("Causa:\n\t" + sqlExcept);
        }

    }

    public static void agregarMateria(String nombre_materia, ArrayList<String> nombres_correlativas) {
        //Agrega una materia a la base de datos de materias.
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        Materia materia_nueva = new Materia(nombre_materia);
        for (String nombre_correlativa : nombres_correlativas) {
            materia_nueva.agregarCorrelativa(nombre_correlativa);
        }
        //
        String sql = String.format("INSERT INTO `%s`.materias(nombre,correlativas) VALUES (\"%s\",\"%s\")", db.getDBName(), nombre_materia, materia_nueva.getStringCorrelativas());
        System.out.println("SQL: " + sql);
        try {
            stmt.executeUpdate(sql);
            db.desconectar();
        }
        catch (SQLException sqlExcept) {
            System.out.println("No se pudo ejecutar el sql");
            System.out.println(sqlExcept);
        }
    }

    public static void agregarAlumno(String legajo, String nombre, String materias_aprobadas) {
        //Agrega un Alumno a la base de datos de alumnos.
        //Conexión a la bd
        //El String materias aprobadas sera un string de la forma: materia_1,materia_2
        if (validarLegajo(legajo)) {
            Database db = new Database();
            db.conectar();
            String sql = String.format("INSERT INTO alumnos VALUES (\"%s\",\"%s\",\"%s\")", legajo, nombre, materias_aprobadas);
            //
            boolean tiene_aprobadas = materias_aprobadas.length() > 0;
            if (tiene_aprobadas) {
                ArrayList<String> aprobadas = obtenerArrayListSTR(materias_aprobadas);
            }
            else {
                String aprobadas = "";
            }
            Statement stmt = db.getStatement();
            try {
                stmt.executeUpdate(sql);
                db.desconectar();
            }
            catch (SQLException sqlExcept) {
                System.out.println("No se pudo ejecutar el sql\nUsuario: " + nombre + " no creado.");
                System.out.println(sqlExcept);
            }
        }else{
            System.out.println("El legajo: `" + legajo + "` no es un nro de legajo válido.\nUsuario no creado");
        }

    }

    public static ArrayList<String> obtenerArrayListSTR(String str) {
        ArrayList<String> arrList = new ArrayList();
        for (String subStr : str.split(",")) {
            arrList.add(subStr);
        }
        return arrList;
    }

    public static void verTodasLasMaterias(){
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT nombre,correlativas FROM materias";
        try{
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Cantidad de resultados en la consulta de la tabla `materias`: "+ rs.getFetchSize());
            db.desconectar();
        }catch(SQLException sqlExcept){
            System.out.println("No se pudieron obtener los resultados.");
            System.out.println("Consulta que se intentó realizar: " + sql );
            System.out.println(sqlExcept);
            System.out.println(sqlExcept.getCause());
        }
        
    }

    public static void verTodosLosAlumnos(){
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT * FROM alumnos";
        try{
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs.getFetchSize());
            db.desconectar();
        }catch(SQLException sqlExcept){
            System.out.println("Error");
            System.out.println(sqlExcept);
        }

    }
    public static boolean validarLegajo(String legajo) {
        //Válida que el String legajo sea un número que contenga de 1 a 5 digítos.
        //Si el String pasa la validación retorna true, sino false.
        return legajo.matches("[0-9]{1,5}");
    }
    //
    //  MAIN
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        int eleccion;
        while (running) {
            System.out.println("1 - Agregar materia a la base de datos\n2 - Agregar alumno a la base de datos\n3 - Ver todos los alumnos\n4 - Ver todas las materias\n5 - SALIR ");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Ingrese el nombre de la materia");
                    String nombre_materia = sc.next();
                    System.out.println("Posee correlativas?\n1 - Si\n2 - No");
                    int con_correlativas = sc.nextInt();
                    if (con_correlativas == 1) {
                        System.out.println("Ingrese los nombres de las correlativas separados por una \",\"");
                        sc.reset();
                        String nombres_correlativas = sc.next();
                        System.out.println("Nombres correlativas: " + nombres_correlativas);
                        ArrayList<String> correlativas = obtenerArrayListSTR(nombres_correlativas);
                        agregarMateria(nombre_materia, correlativas);
                    }
                    else {
                        agregarMateria(nombre_materia);
                    }
                    sc.reset();
                    break;
                case 2:
                    System.out.println("Ingrese un legajo para el alumno. Números del 0-9, con un máximo de 5 digitos.");
                    String legajo = sc.next();
                    sc.reset();
                    System.out.println("Ingrese un nombre para el alumno");
                    String nombre = sc.next();
                    sc.reset();
                    System.out.println("Ingrese las materias aprobadas separadas por una \",\".\nSi no posee materias aprobadas solo pulse ENTER.");
                    String aprobadas = sc.next();
                    sc.reset();
                    agregarAlumno(legajo, nombre, aprobadas);
                    break;
                case 3:
                    verTodosLosAlumnos();
                    sc.reset();
                    break;
                case 4:
                    verTodasLasMaterias();
                    sc.reset();
                    break;
                case 5:
                    running = false;
                    sc.reset();
                    System.out.println("Gracias por usar nuestro software.\nQue tenga un buen día.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println(eleccion);
                    sc.reset();
                    break;
            }
        }
    }
}