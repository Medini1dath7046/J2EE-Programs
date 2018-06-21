/**
 * 
 */
package com.bridgelabz.jdbc;

/**
 * Created By:Medini P.D
 * Date:- 12/06/2018
 * Purpose:
 */
import java.sql.*;  
class BatchProcessingUsingStatement{  
public static void main(String args[])throws Exception{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medini?useSSL=false",
		"root", "root");
con.setAutoCommit(false);  
  
Statement stmt=con.createStatement();  
stmt.addBatch("insert into Employees values(1593,23,'asr','asr')");  
stmt.addBatch("insert into Employees values(1594,28,'amar','asr')");  
stmt.executeBatch();//executing the batch  
  System.out.println("record inserted");
con.commit();  
con.close();  
}}  