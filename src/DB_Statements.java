import java.sql.*;

public class DB_Statements {

    //Declare a statement
    private static Statement stat = null;
    // Declare a connection
    private static Connection con = Dbconnector.connect();
    // Declare a result set
    private static ResultSet rs = null;
    // Declare a prepared statement
    private static PreparedStatement pst = null;


    // Method to create a new database
    public void createNewDB() {
        // SQL Statement
        String query = "create database if not exists ThisDatabase";

        try {
            //connection
            stat = con.createStatement();
            //Execute statement
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            //Handle SQL exceptions
            System.out.println("\n--Statement did not execute.--");
            ex.printStackTrace();
        }
    }

    // method to use a datbase
    public void useDB(String dbName) {
        //statement
        String query = "use thisdatabase";
        try {
            //connection
            stat = con.createStatement();
            //execute query
            stat.executeUpdate(query);
            System.out.println("\n --- Using ThisDatabase ---");
        } catch (SQLException ex) {
            //Handle SQL exceptions
            System.out.println("\n ---Query didn't execute---");
            ex.printStackTrace();
        }
    }

    // Creates a table
    public void createTable(String tableName) {
        //SQL Statement
        String query = "create table if NOT EXISTS " + tableName +
                "(" +
                "id int not null auto_increment," +
                "myName varchar(28)," +
                "address varchar(28)," +
                "primary key (id)" +
                ")";
        try {
            //Connection
            stat = con.createStatement();
            //Execute the query
            stat.executeUpdate(query);
            System.out.println("\n--Table" + tableName + " created--");
        } catch (SQLException ex) {
            System.out.println("\n ---Query didn't execute---");
            ex.printStackTrace();
        }
    }

    //Method to insert data
    public void insertData(String tableName) {
        //SQL query
        String query = "insert into " + tableName + "(" +
                "MyName, address) " +
                "values ('Mikkel','My Address'), " +
                "('Bob ', 'His address'), " +
                "('John', 'Their address')";
        try {
            //Connect
            stat = con.createStatement();
            //Execute query
            stat.executeUpdate(query);
            System.out.println("\n --Data inserted into table " + tableName);
        } catch (SQLException ex) {
            //handle exceptions
            ex.printStackTrace();
        }
    }

    // Method to read data from table
    public void selectFromTable(String tableName) {
        // SQL Statement
        String query = "Select * from " + tableName;
        try {
            //Connection
            stat = con.createStatement();
            //Execute statement
            rs = stat.executeQuery(query);
            System.out.println("\nid\t\tMyName\t\taddress\n----------------------------------");

            //get data
            while (rs.next()) {
                int id = rs.getInt(1);  // Returns ID(column 1)
                String MyName = rs.getString("MyName"); // Returns MyName (column 2)
                String address = rs.getString("address"); // Returns address (column 3)
                System.out.println(id + "\t\t" + MyName + "\t\t" + address);
            }

        } catch (SQLException ex) {
            System.out.println("\n--Query didn't execute--");
            ex.printStackTrace();
        }

    }

    //Checking user credentials
    public Boolean checkLogin(String username, String password) {
        boolean check = false;      // Boolean til at checke om username/password er rigtige. False som default.

        String query = "select * from thisdatabase.user where username = (?) and password = (?)";

        try {
           // stat = con.createStatement();
            pst = con.prepareStatement(query);
           // rs = stat.executeQuery(query);
            while (rs.next()) {
                check = true;
                System.out.println("\n --wew lad u cunt! it works!--");
            }

        } catch (SQLException ex) {
            System.out.println("\n --Fukin hell boy you suck");
            ex.printStackTrace();
        }
        return check;
    }

}