/**
 * 
 */
package com.bridgelabz.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;  
  
public class RowSet {  
        public static void main(String[] args) throws Exception {  
                 Class.forName("com.mysql.jdbc.Driver");  
      
    //Creating and Executing RowSet  
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
        rowSet.setUrl("jdbc:mysql://localhost:3306/medini?");  
        rowSet.setUsername("root");  
        rowSet.setPassword("root");  
                   
        rowSet.setCommand("select * from Employees");  
        rowSet.execute();  
                   
    while (rowSet.next()) {  
                        // Generating cursor Moved event  
                        System.out.println("Id: " + rowSet.getString(1));  
                        System.out.println("age: " + rowSet.getString(2));  
                        System.out.println("first: " + rowSet.getString(3));  
                        System.out.println("last: " + rowSet.getString(4));  
                       System.out.println();
                }  
                 
        }  
}  