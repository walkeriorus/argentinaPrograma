package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String urlServer;
    private String admin;
    private String adminPass;
    private String dbDriverName ;
    private String dbName ;
    private String urlDB ;
    private Connection conn = null;

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
    public Connection conectar(){
        try{
            System.out.println("URLDB: "+ this.urlDB);
            this.conn = DriverManager.getConnection(this.urlDB,this.admin,this.adminPass);
        }catch(SQLException sqlExcept ){
            System.out.println("Fallo la conexión.");
            System.out.println(sqlExcept );
        }
        return this.conn;
    }
    public void desconectar(){
        try{
            this.conn.close();
        }catch(SQLException sqlExcept ){
            System.out.println(sqlExcept);
        }
    }
    public String getDBName(){
        return this.dbName;
    }
}
