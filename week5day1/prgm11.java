package week5day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class prgm11 {

	public static void main(String[] args) throws Exception{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		
		PreparedStatement stmt=con.prepareStatement("insert into pupil values(?,?,?,?)");  
		stmt.setInt(1,101);//1 specifies the first parameter in the query  
		stmt.setString(2,"Ratan");
		stmt.setString(3,"Tata");  
		stmt.setInt(4,1);
		stmt.executeUpdate();
	}
}
