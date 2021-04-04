package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class prgm10 {

	 public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
			
		PreparedStatement ps=con.prepareStatement("select * from pupil where id>= ?");
		ps.setInt(1,207);
		
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next())
		{
		int e1=rs.getInt(1);
		String e2=rs.getString(2);
		String e3=rs.getString(3);
		int e4=rs.getInt(4);
		System.out.println("id = " +e1 +"\t name = " +e2+"pass = " +e3 +"\t flag = " +e4);
		}
	}

}
