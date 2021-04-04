package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class eg14 {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from pupil");
		
		rs.afterLast();
		while(rs.previous())
		{
			String e1=rs.getString(2);
			int e=rs.getInt(1);
			System.out.println("name = " +e1 +"id = " +e);
		}
		
	}

}
