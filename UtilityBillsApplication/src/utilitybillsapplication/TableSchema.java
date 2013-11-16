package utilitybillsapplication;

/**
 *
 * @author Chris Hauptli, David Ickert, Andrew Pohlman, Zack Urben
 */

import java.util.ArrayList;

public class TableSchema {
    
    public ArrayList tableList;
    
    public TableSchema(){
        
        tableList = new ArrayList();
        
        tableList.add("accounts");
        tableList.add("accounts");
        tableList.add("accounts");
        tableList.add("accountsToTaxes");
        tableList.add("bills");
        tableList.add("error");
        tableList.add("feesToAccounts");
        tableList.add("meterReadings");
        tableList.add("meters");
        tableList.add("payments");
        tableList.add("paymentsToBills");
        tableList.add("serviceFees");
        tableList.add("taxes");
        
    }
    
    public ArrayList getTableList(){
        
        return tableList;
        
    }
    
    public static String accountsSchema(){
        
        String schema = "CREATE TABLE accounts " +
                             "(id INTEGER not NULL PRIMARY KEY " +
                             "GENERATED ALWAYS AS IDENTITY " +
                             "(START WITH 1, INCREMENT BY 1)," +
                             " street VARCHAR(255), " + 
                             " city VARCHAR(255), " + 
                             " zip VARCHAR(255) " + 
                             " )";
        
        return schema;
        
    }
    
    public static String accountsToTaxesSchema(){
        
        String schema = "CREATE TABLE accountsToTaxes " +
                             "(id INTEGER not NULL PRIMARY KEY " +
                             "GENERATED ALWAYS AS IDENTITY " +
                             "(START WITH 1, INCREMENT BY 1)," +
                             " street VARCHAR(255), " + 
                             " city VARCHAR(255), " + 
                             " zip VARCHAR(255) " + 
                             " )";
        
        return schema;
        
    }
    
    public static String billsSchema(){
        
        String schema = "CREATE TABLE bills " +
                             "(id INTEGER not NULL PRIMARY KEY " +
                             "GENERATED ALWAYS AS IDENTITY " +
                             "(START WITH 1, INCREMENT BY 1)," +
                             " street VARCHAR(255), " + 
                             " city VARCHAR(255), " + 
                             " zip VARCHAR(255) " + 
                             " )";
        
        return schema;
        
    }
    
}
