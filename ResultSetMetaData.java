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
public class ResultSetMetaData {
   
    public static void main(String args[]){  
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection(  
    		  "jdbc:mysql://localhost:3306/medini?useSSL=false","root","root");
    PreparedStatement ps=con.prepareStatement("select * from emp");  
    java.sql.ResultSet rs=ps.executeQuery();  
    java.sql.ResultSetMetaData rsmd=rs.getMetaData();  
      
    System.out.println("Total columns: "+rsmd.getColumnCount());  
    System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
    System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
      
    con.close();  
    }catch(Exception e){ System.out.println(e);}  
    }  
    
}
