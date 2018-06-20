/**
 * 
 */
package com.bridgelabz.jdbc;
import java.sql.*; 
/**
 * Created By:Medini P.D
 * Date:- 12/06/2018
 * Purpose:
 */
public class DataBaseMetaData {
    
    public static void main(String args[]){  
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
      
    Connection con=DriverManager.getConnection(  
    		  "jdbc:mysql://localhost:3306/medini?useSSL=false","root","root");
    DatabaseMetaData dbmd=con.getMetaData();  
      
    System.out.println("Driver Name: "+dbmd.getDriverName());  
    System.out.println("Driver Version: "+dbmd.getDriverVersion());  
    System.out.println("UserName: "+dbmd.getUserName());  
    System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
    System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
      
    con.close();  
    }catch(Exception e){ System.out.println(e);}  
    }  
    }  