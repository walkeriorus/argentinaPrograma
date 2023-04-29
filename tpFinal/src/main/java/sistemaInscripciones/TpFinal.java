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

import gui.FormAlumno;

public class TpFinal {

    public static void agregarMateria(String nombre_materia) {
        Database db = new Database();
        db.conectar();
        Materia materia_nueva = new Materia(nombre_materia);
        //
        String sql = String.format("INSERT INTO `%s`.materias(nombre,correlativas) VALUES (\"%s\",\"\")", db.getDBName(), nombre_materia);
        Statement stmt = db.getStatement();
        try {
            stmt.executeUpdate(sql);
        }
        catch (SQLException sqlExcept) {
            System.out.println("No se pudo ejecutar la sentencia:\n\t" + sql );
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
        try {
            stmt.executeUpdate(sql);
            db.desconectar();
        }
        catch (SQLException sqlExcept) {
            System.out.println("No se pudo la sentencia: \n\t" + sql );
            System.out.println(sqlExcept);
        }
    }

    public static ArrayList<String> obtenerArrayListSTR(String str) {
        ArrayList<String> arrList = new ArrayList();
        for (String subStr : str.split(",")) {
            arrList.add(subStr);
        }
        return arrList;
    }

    public static void verTodasLasMaterias() {
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT nombre,correlativas FROM `tp_final`.materias";
        System.out.println("---------- LISTADO DE MATERIAS ----------");
        try {
            ResultSet rs = stmt.executeQuery(sql);
//            System.out.println("Cantidad de resultados en la consulta de la tabla `materias`: "+ rs.getFetchSize());
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String correlativas = rs.getString("correlativas");
                System.out.println(String.format("Materia: %s\tCorrelativas: %s", nombre, correlativas));
                System.out.println("");
            }
            System.out.println("----------------------------------------");
            db.desconectar();
        }
        catch (SQLException sqlExcept) {
            System.out.println("No se pudieron obtener los resultados.");
            System.out.println("Consulta que se intentó realizar: " + sql);
            System.out.println(sqlExcept);
            System.out.println(sqlExcept.getCause());
        }

    }

    public static void verTodosLosAlumnos() {
        Database db = new Database();
        db.conectar();
        Statement stmt = db.getStatement();
        String sql = "SELECT * FROM `tp_final`.alumnos";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("---------- LISTADO DE ALUMNOS ----------");
            while (rs.next()) {
                String legajo = rs.getString("legajo");
                String nombre = rs.getString("nombre");
                String materias_aprobadas = rs.getString("materias_aprobadas");
                System.out.println(String.format("Alumno: %s\tLegajo: %s\nMaterias aprobadas: %s", nombre,legajo, materias_aprobadas));
                System.out.println("");
            }
            System.out.println("----------------------------------------");
            db.desconectar();
        }
        catch (SQLException sqlExcept) {
            System.out.println("Error");
            System.out.println(sqlExcept);
        }

    }

    public static String inscripcionAMateria(String nombre_alumno,String nombre_materia){
        //MENSAJE
        String msj = null;
        //Obtengo los datos del alumno
        ArrayList<String> datos_alumno = buscarAlumnoPorNombre(nombre_alumno);
        ArrayList<String> datos_materia = buscarMateria(nombre_materia);
        //CREACION DEL ALUMNO COMO OBJETO
        ArrayList<Materia> materias_alumno = new ArrayList();
        for(String nombre : datos_alumno.get(2).split(",")){
            materias_alumno.add(new Materia(nombre));
        }
        Alumno alumno = new Alumno(datos_alumno.get(0),datos_alumno.get(1),materias_alumno);
        //CREACION DE LA MATERIA COMO OBJETO
        ArrayList<Materia> correlativas_materia = new ArrayList();
        for(String nombre : datos_materia.get(1).split(",")){
            correlativas_materia.add(new Materia(nombre));
        }
        Materia materia = new Materia(datos_materia.get(0),correlativas_materia);
        //CREO UNA INSCRIPCION
        Inscripcion inscripcion = new Inscripcion(alumno,materia);
        if(inscripcion.aprobada()){
            msj = "\nInscripción aceptada\n";
        }else{
            msj = "\nInscripción rechazada\n";
        }
        return msj;
    }
    public static ArrayList<String> buscarAlumnoPorNombre(String nombre_alumno){
        //Si se encuentra el alumno se retornan sus datos en un ArrayList de Strings
        //En el indice 0 el legajo, en el 1 el nombre, en el 2 sus materias aprobadas
        //Si no se encuentra se retorna una ArrayList vacío

        ArrayList<String> datos = new ArrayList();
        Database db  = new Database();
        db.conectar();
        String sql = String.format("SELECT * FROM `tp_final`.alumnos WHERE nombre = \"%s\"", nombre_alumno);
        try{
            ResultSet rs = db.getStatement().executeQuery(sql);
            if(rs.next()){
                String legajo = rs.getString("legajo");
                String nombre = rs.getString("nombre");
                String materias = rs.getString("materias_aprobadas");
                datos.add(legajo);
                datos.add(nombre);
                datos.add(materias);
            }else{
            }
        }catch(SQLException sqlExc){}
        db.desconectar();
        return datos;
    }
    public static ArrayList<String> buscarMateria(String nombre_materia ){
        ArrayList<String> datos = new ArrayList();
        Database db  = new Database();
        db.conectar();
        String sql = String.format("SELECT * FROM `tp_final`.materias WHERE nombre = \"%s\"", nombre_materia);
        try{
            ResultSet rs = db.getStatement().executeQuery(sql);
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String correlativas = rs.getString("correlativas");
                datos.add(nombre);
                datos.add(correlativas);
            }else{
            }
        }catch(SQLException sqlExc){}
        db.desconectar();
        return datos;
    }
    //
    //  MAIN
    //
    public static void main(String[] args) {
        Scanner scEleccion = new Scanner(System.in);
        Scanner scDatos = new Scanner(System.in);
        boolean running = true;
        int eleccion;
        while (running) {
            System.out.println("1 - Agregar materia a la base de datos\n2 - Agregar alumno a la base de datos\n3 - Ver todos los alumnos\n4 - Ver todas las materias\n5 - Inscripción a materia \n6 - SALIR ");
            eleccion = scEleccion.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Ingrese el nombre de la materia");
                    String nombre_materia = scDatos.nextLine();
                    System.out.println("Posee correlativas?\n1 - Si\n2 - No");
                    int con_correlativas = scEleccion.nextInt();
                    if (con_correlativas == 1) {
                        System.out.println("Ingrese los nombres de las correlativas separados por una \",\"");
                        String nombres_correlativas = scDatos.nextLine();
                        System.out.println("Nombres correlativas: " + nombres_correlativas);
                        ArrayList<String> correlativas = obtenerArrayListSTR(nombres_correlativas);
                        agregarMateria(nombre_materia, correlativas);
                    }
                    else {
                        agregarMateria(nombre_materia);
                    }
                    scDatos.reset();
                    break;
                case 2:
//                    System.out.println("Ingrese un legajo para el alumno. Números del 0-9, con un máximo de 5 digitos.");
//                    String legajo = scDatos.nextLine();
//                    System.out.println("Ingrese un nombre para el alumno");
//                    String nombre = scDatos.nextLine();
//                    System.out.println("-------------------------------------------------");
//                    System.out.println("Nombre capturado por el Scanner: " + nombre );
//                    System.out.println("-------------------------------------------------");
//                    System.out.println("Ingrese las materias aprobadas separadas por una \",\".\nSi no posee materias aprobadas solo pulse ENTER.");
//                    String aprobadas = scDatos.nextLine();
//                    agregarAlumno(legajo, nombre, aprobadas);
                    FormAlumno formAlumno = new FormAlumno();
                    formAlumno.setVisible(true);
                    formAlumno.setTitle("Carga de datos");
                    break;
                case 3:
                    verTodosLosAlumnos();
                    scDatos.reset();
                    break;
                case 4:
                    verTodasLasMaterias();
                    break;
                case 5:
                    System.out.println("Ingrese su nombre: ");
                    String nombre_alumno = scDatos.nextLine();
                    scDatos.reset();
                    System.out.println("Ingrese el nombre de la materia: ");
                    String materia = scDatos.nextLine();
                    String respuestaInscripcion = inscripcionAMateria(nombre_alumno, materia);
                    System.out.println(respuestaInscripcion);
                    break;
                case 6:
                    running = false;
                    System.out.println("Gracias por usar nuestro software.\nQue tenga un buen día.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println(eleccion);
                    break;
            }
        }
    }
}
