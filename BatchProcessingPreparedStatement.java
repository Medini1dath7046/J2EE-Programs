/**
 * 
 */
package com.bridgelabz.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created By:Medini P.D
 * Date:- 12/06/2018
 * Purpose:
 */
public class BatchProcessingPreparedStatement {

		public static void main(String args[]){  
		try{  
		  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medini?","root","root");  
		  
		PreparedStatement ps=con.prepareStatement("insert into Employees values(?,?,?,?)");  
		  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		while(true){  
		  
		System.out.println("enter id");  
		String s1=br.readLine();  
		int id=Integer.parseInt(s1);  
		 
		System.out.println("enter age");  
		String s3=br.readLine();  
		int age=Integer.parseInt(s3);  
		
		System.out.println("enter first name");  
		String first=br.readLine();  
		  
		System.out.println("enter last name");  
		String last=br.readLine();  
		  
		ps.setInt(1,id);  
		ps.setInt(2,age);  
		ps.setString(3,first);  
		  ps.setString(4, last);
		ps.addBatch();  
		System.out.println("Want to add more records y/n");  
		String ans=br.readLine();  
		if(ans.equals("n")){  
		break;  
		}  
		  
		}  
		ps.executeBatch();  
		  
		System.out.println("record successfully saved");  
		  
		con.close();  
		}catch(Exception e){System.out.println(e);}  
		  	}
		}  