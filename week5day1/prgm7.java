package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prgm7 {

	public static void main(String str[]) 	{

		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
	
		Statement st=con.createStatement();
		st.executeUpdate("update pupil set name='Lionel' where name='messi'");
		st.executeUpdate("update pupil set pass='spacex' where id=203");
		ResultSet rs=st.executeQuery("select * from pupil");
		
		
		
		while(rs.next())
		{
			int e1 = rs.getInt(1);
			String e2=rs.getString(2);
			String e3=rs.getString(3);
			int e4=rs.getInt(4);
			System.out.println("id = " +e1 +"\t name = " +e2+"pass = " +e3 +"\t flag = " +e4);
		}
		st.close();
		con.close();
		System.out.println("records successfully updatedd");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
