package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JDBC {

    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost:3306/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    private static String password = "root"; // Password CHANGE BEFORE SUBMITTING
    public static Connection connection;  // Connection Interface

    public static Connection openConnection()
    {
        try {
            Class.forName(driver); // Locate Driver
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("Connection successful!");
        }
        catch(SQLException e)
        {
            //System.out.println("Error:" + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection(){
        if(connection == null){
            openConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

}
