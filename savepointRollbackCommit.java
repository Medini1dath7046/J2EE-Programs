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

public class savepointRollbackCommit {
   public static void main(String[] args) throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/medini?useSSL=false","root","root");
      
      Statement stmt = con.createStatement();
      String query1 = "insert into Employees values(384,67,'name','job')";
      String query2 = "select * from Employees";
      
      con.setAutoCommit(false);
      Savepoint spt1 = con.setSavepoint("svpt1");
      stmt.execute(query1);

      java.sql.ResultSet rs = stmt.executeQuery(query2);
   

      int no_of_rows = 0;
      
      while (rs.next()) {
         no_of_rows++;
        
      }
      System.out.println("rows before rollback statement = " + no_of_rows);
      con.rollback(spt1);

      no_of_rows = 0;
      rs = stmt.executeQuery(query2);


      while (rs.next()) {
         no_of_rows++;
      }  
      System.out.println("rows after rollback statement = " + no_of_rows);
   }
}
