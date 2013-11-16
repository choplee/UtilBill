package utilitybillsapplication;

/**
 *
 * @author Chris Hauptli, David Ickert, Andrew Pohlman, Zack Urben
 */

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private boolean active;
    private String userName;
    private String password;
    private String dbms;
    private String dbName;
    private Connection conn;
    private Statement sqlExecutor;
    private ResultSet error;
    
    public DatabaseConnection(){
        
        userName = "utilMeters";
        password = "utilMeters";
        dbms = "derby";
        dbName = "utilMeters";
        
        //Attempt to create connection, statement, and error Result Set.  On failure, set active to false
        try{
            conn=DriverManager.getConnection("jdbc:" + dbms + ":" + dbName + ";create=true", userName, password);
            sqlExecutor = conn.createStatement();
            error = sqlExecutor.executeQuery("SELECT id FROM error");
            active = true;
        }
        catch (SQLException e){
            e.printStackTrace();
            active = false;
        }
        
    }

    //Executes a query on the database and returns a result set
    public ResultSet executeQuery(String sql){
        
        ResultSet results = error;
        
        try{
            results = sqlExecutor.executeQuery(sql);
        }
        catch(SQLException e){
            results = error;
            e.printStackTrace();
        }

        return results;
        
    }
    
    //Executes an update to the database.  Returns true on success, false on failure.
    public boolean executeUpdate(String sql){
        
        boolean success = true;
        
        try{
            sqlExecutor.executeUpdate(sql);
        }
        catch(SQLException e){
            success = false;
            e.printStackTrace();
        }
        
        return success;
        
    }
    
    //Attempts to re-establish the database connection
    //Returns state of the active variable
    public boolean reconnect(){
        
        //Attempt to create connection.  On failure, set active to false
        try{
            conn=DriverManager.getConnection("jdbc:" + dbms + ":" + dbName + ";create=true", userName, password);
            sqlExecutor = conn.createStatement();
            active = true;
        }
        catch (SQLException e){
            active = false;
        } 
        
        return active;
        
    }
    
    //Returns the state of the database connection - active (true) or inactive (false)
    public boolean isActive(){
        
        return active;
        
    }
    
}
