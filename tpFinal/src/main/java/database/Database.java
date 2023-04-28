package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private String urlServer;
    private String admin;
    private String adminPass;
    private String dbDriverName ;
    private String dbName ;
    private String urlDB ;
    private Connection conn = null;
    private Statement stmt = null;

    public Database() {
        this.urlServer = "jdbc:mysql://127.0.0.1:3312/";
        this.admin = "root";
        this.adminPass = "624531";
        this.dbDriverName = "com.mysql.cj.jdbc.Driver";
        this.dbName = "tp_final";
        this.urlDB = this.urlServer + this.dbName;
    }
    //Constructores
    public Database( String dbName ) {
        this.urlServer = "jdbc:mysql://127.0.0.1:3312/";
        this.admin = "root";
        this.adminPass = "624531";
        this.dbDriverName = "com.mysql.cj.jdbc.Driver";
        this.dbName = dbName;
        this.urlDB = this.urlServer + this.dbName;
    }
    public Database(String urlSrvr, String admin, String adminPass,String dbDriver, String dbName) {
        this.urlServer = "jdbc:mysql://" + urlSrvr +"/";
        this.admin = admin;
        this.adminPass = adminPass;
        this.dbDriverName = dbDriver;
        this.dbName = dbName;
        this.urlDB = this.urlServer + this.dbName;
    }
    //Métodos
    public void conectar(){
        try{
            this.conn = DriverManager.getConnection(this.urlDB,this.admin,this.adminPass);
            //Crea un Statement automaticamente al llamar al método conectar;
            this.createStatement();
        }catch(SQLException sqlExcept ){
            System.out.println("Fallo la conexión.");
            System.out.println(sqlExcept );
        }
    }
    public void desconectar(){
        try{
            this.conn.close();
        }catch(SQLException sqlExcept ){
            System.out.println(sqlExcept);
        }
    }
    private void createStatement(){
        try{
            this.stmt = this.conn.createStatement();
        }catch(SQLException sqlExcept){
            System.out.println("No se creo el Statement.");
            System.out.println(sqlExcept + "\nCódigo de error: "+sqlExcept.getErrorCode());
        }
    }
    //GETTERS
    public Connection getDBConn(){
        return this.conn;
    }
    public String getDBName(){
        return this.dbName;
    }
    public Statement getStatement(){
        return this.stmt;
    }
}
