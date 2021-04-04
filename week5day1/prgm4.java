package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class prgm4 {

	public static void main(String str[]) throws Exception
	{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	//establish connection
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
	Statement st=con.createStatement();
	st.executeUpdate(" insert into pupil values('7','Ronaldo','football',0)");
	st.executeUpdate(" insert into pupil values('10','messi','soccer',1)");
	
	st.close();
	con.close();
	System.out.println("records successfully inserted");
	}catch(Exception e){e.printStackTrace();}
	}

}
