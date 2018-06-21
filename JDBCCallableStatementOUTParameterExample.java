
package com.bridgelabz.jdbc;
/**
 * Created By:Medini P.D
 * Date:- 12/06/2018
 * Purpose:
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCCallableStatementOUTParameterExample
{   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/medini?useSSL=false";
    static final String USER = "root";
    static final String PASS = "root";

    public JDBCCallableStatementOUTParameterExample()
    {
        try
        {
            // Loading the driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    public Connection createConnection()
    {
        Connection con = null;
        try
		{
		   con = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		catch (Exception e)
		{
		    System.out.println(e.toString());
		}
        return con;
    }

    public static void main(String[] args)
    {
        JDBCCallableStatementOUTParameterExample calllableStatement = new JDBCCallableStatementOUTParameterExample();
        Connection connection = calllableStatement.createConnection();
        try
        {
            java.sql.CallableStatement cs = connection.prepareCall("call getEmployees()");
            ResultSet rs = cs.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}