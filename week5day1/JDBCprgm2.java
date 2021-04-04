package week5day1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCprgm2 {

	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		Statement st = con.createStatement();
		
		String s = "insert into pupil values(2,'Sky','Jackal',0)";
		
//		int noofrowsaffected = st.executeUpdate(s);
//		
//		System.out.println("No of rows affected : "+noofrowsaffected);
//		
//		
//		s = "select * from pupil";
		s = "update pupil set flag = 1";
		boolean b = st.execute(s);
		System.out.println("Result set returned "+b);
	}
	
	
}
