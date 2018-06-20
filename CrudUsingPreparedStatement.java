/**
 * 
 */
package com.bridgelabz.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Created By:Medini P.D Date:- 12/06/2018 Purpose:
 */
public class CrudUsingPreparedStatement {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medini?useSSL=false",
					"root", "root");
			int a = 0;
			while (a < 6) {
				System.out.println("enter your chioice");

				System.out.println("enter 1. to perform create table operation");
				System.out.println("enter 2. to perform insert data to a table");
				System.out.println("enter 3. to perform update operation on the table");
				System.out.println("enter 4. to perform select operation on the table");
				System.out.println("enter 5. to perform delete operation on the table");

				switch (sc.nextInt()) {
				case 1:
					java.sql.PreparedStatement pstmt1 = con
							.prepareStatement("create table emp1(id int,name varchar(50))");
					pstmt1.executeUpdate();
					System.out.println("table created ");
					System.out.println();
					break;

				case 2:
					java.sql.PreparedStatement pstmt21 = con.prepareStatement("insert into emp values(?,?)");
					pstmt21.setInt(1, 101);// 1 specifies the first parameter in the query
					pstmt21.setString(2, "Ratan");
					int i2 = pstmt21.executeUpdate();
					System.out.println(" records inserted");

					break;
				case 3:
					java.sql.PreparedStatement pstmt3 = con.prepareStatement("update emp set name=? where id=?");
					pstmt3.setString(1, "Sonoo");// 1 specifies the first parameter in the query i.e. name
					pstmt3.setInt(2, 101);

					int i3 = pstmt3.executeUpdate();
					System.out.println(" records updated");

					break;

				case 4:
					java.sql.PreparedStatement pstmt4 = con.prepareStatement("select * from emp");
					ResultSet rs = pstmt4.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " " + rs.getString(2));
					}

					break;

				case 5:
					java.sql.PreparedStatement pstmt5 = con.prepareStatement("delete from emp where id=?");
					pstmt5.setInt(1, 101);

					int i5 = pstmt5.executeUpdate();
					System.out.println(" records deleted");
					break;
				}
			}

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null)
					con.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}
}