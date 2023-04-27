package sistemaInscripciones;
import clases.Alumno;
import clases.Inscripcion;
import clases.Materia;
import com.fasterxml.jackson.databind.ObjectMapper;
//import interfazDeUsuario.Gui;
import database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Scanner;
public class TpFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        int eleccion;
        while(running){
            System.out.println("1 - Agregar materia a la base de datos\n2 - Agregar alumno a la base de datos\n3 - Ver todos los alumnos\n4 - Ver todas las materias\n5 - SALIR ");
            eleccion = sc.nextInt();
            switch(eleccion){
                case 1 :
                    System.out.println("Ingrese el nombre de la materia");
                    String nombre_materia = sc.next();
                    System.out.println("Posee correlativas?\n1 - Si\n2 - No");
                    int con_correlativas = sc.nextInt();
                    if(con_correlativas == 1){
                        System.out.println("Ingrese los nombres de las correlativas separados por una \",\"");
                        sc.reset();
                        String nombres_correlativas = sc.next();
                        System.out.println("Nombres correlativas: " + nombres_correlativas);
                        ArrayList<String> correlativas = new ArrayList();
                        for(String nombre_correlativa:nombres_correlativas.split(",")){
                            correlativas.add(nombre_correlativa);
                        }
                        agregarMateria(nombre_materia,correlativas);
                    }
                    else{
                        agregarMateria(nombre_materia);
                    }
                    
                    break;
                case 5:
                    running = false;
                    System.out.println("Gracias por usar nuestro software.\nQue tenga un buen día.");
                default :
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
    public static void agregarMateria(String nombre_materia){
        Database db = new Database();
        Materia materia_nueva = new Materia(nombre_materia);
        //
        String sql = String.format("INSERT INTO `%s`.materias(nombre,correlativas) VALUES (\"%s\",\"\")",db.getDBName(),nombre_materia);
        System.out.println("SQL: "+ sql);
        try{
            Statement stmt = db.conectar().createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException sqlExcept ){
            System.out.println("No se pudo crear el Statement");
            System.out.println(sqlExcept + "\nCódigo de error: " + sqlExcept.getErrorCode());
        }
        finally{
            db.desconectar();
        }
    }
    public static void agregarMateria(String nombre_materia, ArrayList<String> nombres_correlativas){
        //Agrega una materia a la base de datos de materias.
        Database db = new Database();
        Materia materia_nueva = new Materia(nombre_materia);
        for(String nombre_correlativa : nombres_correlativas){
            materia_nueva.agregarCorrelativa(nombre_correlativa);
        }
        //
        String sql = String.format("INSERT INTO `%s`.materias(nombre,correlativas) VALUES (\"%s\",\"%s\")",db.getDBName(),nombre_materia,materia_nueva.getStringCorrelativas());
        System.out.println("SQL: "+ sql);
        try{
            Statement stmt = db.conectar().createStatement();
            stmt.executeUpdate(sql);
            db.desconectar();
        }catch(SQLException sqlExcept ){
            System.out.println("No se pudo crear el Statment");
            System.out.println(sqlExcept);
        }
    }
    public void agregarAlumno(){
        //Agrega un Alumno a la base de datos de alumnos.
    }
}
