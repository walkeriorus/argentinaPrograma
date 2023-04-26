package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {

    private String urlServer;
    private String admin;
    private String adminPass;
    private String dbDriverName ;
    private String urlDbName ;
    private String urlDB ;

    public Database() {
        this.urlServer = "jdbc:mysql://127.0.0.1:3312/";
        this.admin = "root";
        this.adminPass = "624531";
        this.dbDriverName = "com.mysql.cj.jdbc.Driver";
        this.urlDbName = "prueba";
        this.urlDB = this.urlServer + this.urlDbName;
    }
    public Database(String urlSrvr, String admin, String adminPass,String dbDriver, String dbName) {
        this.urlServer = "jdbc:mysql://" + urlSrvr +"/";
        this.admin = admin;
        this.adminPass = adminPass;
        this.dbDriverName = dbDriver;
        this.urlDbName = dbName;
        this.urlDB = this.urlServer + this.urlDbName;
    }

    public Connection conectar(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(this.urlDB);
        }catch(SQLException sqlExcept ){}
        return conn;
    }
}
