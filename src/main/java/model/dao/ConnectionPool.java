package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    //Url per la connessione al DataBase
    public static String url = "jdbc:mysql://localhost:3306/easyaid";
    //Istanza della connessione
    private static Connection conn =null;
    //Metodo che restituisci la connessione al Database
    public static Connection conn() throws ClassNotFoundException, SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(url, "root", "root");
      if (conn != null) {
        System.out.println("Connessione Stabilita.\n");
      }
        }
        catch(SQLException e){
                System.out.println("Connessione Fallita.\n");
            }

            return conn;
    }
}