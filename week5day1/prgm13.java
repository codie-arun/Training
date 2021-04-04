package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

public class prgm13 {

	public static void main(String st1[]) throws Exception
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	//establish connection
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
	Enumeration e=DriverManager.getDrivers();
	System.out.println(" " +DriverManager.getLoginTimeout());
	while(e.hasMoreElements())
	{
	System.out.println(e.nextElement());
	}
	}

}
