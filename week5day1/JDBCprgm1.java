package week5day1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCprgm1 {

	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		System.out.println(con);
		
		
		DatabaseMetaData dbmd=con.getMetaData();
		
		System.out.println("DatabaseProductName :"+dbmd.getDatabaseProductName());
		System.out.println("DatabaseProductVersion:"+dbmd.getDatabaseProductVersion());
		System.out.println("getStringFunctions :"+dbmd.getStringFunctions());
		System.out.println("DriverMajorVersion :"+dbmd.getDriverMajorVersion());
		System.out.println("DriverMinorVersion :"+dbmd.getDriverMinorVersion ());
		System.out.println("DriverName : "+dbmd.getDriverName ());
		System.out.println("SQLKeywords : "+dbmd.getSQLKeywords());
		System.out.println("URL : "+dbmd.getURL());
	}
	
	
}
