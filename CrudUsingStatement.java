
package com.bridgelabz.jdbc;

/*************************************************************************************************************
 *
 * purpose:
 *
 * @author Medini
 * @version 1.0
 * @since18 -05-17
 *
 * **************************************************************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;


public class CrudUsingStatement {
   // JDBC driver name and database URL
	static Scanner sc=new Scanner(System.in);
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/medini?useSSL=false";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";

   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
  
   try{  conn.setAutoCommit(false);
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
   
      stmt = conn.createStatement();
      int a=0;
      while(a<6)
      { 
		System.out.println("enter your chioice");

		System.out.println("enter 1. to perform create table operation");
		System.out.println("enter 2. to perform insert data to a table");
		System.out.println("enter 3. to perform update operation on the table");
		System.out.println("enter 4. to perform select operation on the table");
		System.out.println("enter 5. to perform delete operation on the table");
       
       
	     switch(sc.nextInt()) 
	     {
	 case 1:  
		 String sql = "create table harsh383(id int(10),firstName varchar(20),"
                 + "lastName varchar(20))";
	     stmt.executeUpdate(sql);
	     String tab=sc.nextLine();
	    	         break;
		
	     case 2:  String sql1= "INSERT INTO  Employees VALUES (213,4535,'medini','medh')";
	     stmt.executeUpdate(sql1);

  break;
	     case 3: String sql2= "UPDATE Employees " +
                 "SET age = 30 WHERE id in (100, 101)";
	     stmt.executeUpdate(sql2);
  conn.commit();
	     break;
	     case 4: String sql3=  "SELECT id,age,  first, last FROM Employees";
	      ResultSet rs1 = stmt.executeQuery(sql3);

	     while(rs1.next()){
	         //Retrieve by column name
	         int id  = rs1.getInt("id");
	         int age = rs1.getInt("age");
	         String first = rs1.getString("first");
	         String last = rs1.getString("last");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", Age: " + age);
	         System.out.print(", First: " + first);
	         System.out.println(", Last: " + last);
	      }

	     break;
	     case 5: String sql4= "DELETE FROM Employees WHERE id = 130";
	     stmt.executeUpdate(sql4);
	     }
      } System.out.println("your requested operation has done");
System.out.println();
   }
      
	     catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   }
}//end JDBCExample