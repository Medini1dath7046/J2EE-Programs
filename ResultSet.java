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
public class ResultSet {
 
    private static int TYPE_SCROLL_SENSITIVE;

	public static void main(String args[])throws Exception{  
      
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medini?useSSL=false","root","root");
    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.TYPE_SCROLL_SENSITIVE);  
    java.sql.ResultSet rs=stmt.executeQuery("select * from Employees");  
      
    //getting the record of 3rd row  
    rs.absolute(32);  
    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));  
      
    con.close();  
    }}  

