package utilitybillsapplication;

/**
 * @author Chris Hauptli, David Ickert, Andrew Pohlman, Zack Urben
 */

import java.util.ArrayList;

public class UtilityBillsApplication {

    public static void main(String[] args) {
        
        //Create database connection object
        DatabaseConnection dbConnection = new DatabaseConnection();
       
        //Create database tables and seed with initial information
        initializeDatabase(dbConnection);
        
        //Create Model Controller
        ModelController modelController = new ModelController(dbConnection);
        
        //Create User Interface object, pass in model controller through constructor
        
    }
    
    public static boolean initializeDatabase(DatabaseConnection dbConnection){
        
        TableSchema schema = new TableSchema();
        
        boolean success = true;
        
        ArrayList tableList = schema.getTableList();
        
        //Drop tables
        for(int i = 0; i < tableList.size(); i++){
            if(!dbConnection.executeUpdate("DROP TABLE " + tableList.get(i)))
                success = false;
        }
        
        //Create tables

        return success;
        
    }
    

    
}
