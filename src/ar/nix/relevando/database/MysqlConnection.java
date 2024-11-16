package ar.nix.relevando.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

	private static Connection connection;
    private static String host;
    private static String user;
    private static String pass;
    private static String database;

	 public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            reconnect();
	    }
	    return connection;
	 }
	 
	 public static void initialize(String host, String user, String pass, String database) {
        MysqlConnection.host = host;
        MysqlConnection.user = user;
        MysqlConnection.pass = pass;
        MysqlConnection.database = database;
	        
        try {
            String dbUrl = "jdbc:mysql://" + host + "/" + database;
            connection = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("Base de datos conectada con éxito.");
        } catch (SQLException e) {
            System.out.println("!! Error al conectar a la base de datos.  "+e.getMessage());
           // e.printStackTrace();
        }
    }
	 
    private static void reconnect() throws SQLException {
        if (host == null || user == null || pass == null || database == null) {
            throw new IllegalStateException("La conexión no se puede inicializar porque no se configuraron los parámetros.");
        }
        String dbUrl = "jdbc:mysql://" + host + "/" + database;
        connection = DriverManager.getConnection(dbUrl, user, pass);
    }
    
   
}
