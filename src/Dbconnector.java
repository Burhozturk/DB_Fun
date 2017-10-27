import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnector {
    // Declare a connection
    private static Connection con = null;
    //  JDBC driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //  URL = jdbc:dbms//host name:port#/db name
    private static String url = "jdbc:mysql://localhost:3306/";
    // username
    private static String usrnm = "root";
    // password
    private static String pswrd = "Password0551";

    public static Connection connect() {
        System.out.println("\n--Connecting to MySQL JDBC--");
        // Locate MySQL JDBC Driver
        try {
            Class.forName(DRIVER);
        }
        // Catch exceptions if BDC is not found
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("\n--JDBC driver is missing--");
        }
        System.out.println("\n--MySQL JDBC driver registered--");

        try {
            con = DriverManager.getConnection(url, usrnm, pswrd);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("\n--Did not connect, try again--");
        }
        // if connection is successful
        if (con != null) {
            System.out.println("\n-- Connection was successful!");
        } else {
            System.out.println("Failed to connect");
        }
        return con;

    }
    }




    // Connect to MySQL DB = URL, usrName, pswrd

    // Catch exceptions on connection error



