package week5day1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;



public class JDBCprgm4 {

	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		//Statement st = con.createStatement();
		
		String query = "select * from pupil where id =?";	
		PreparedStatement st = con.prepareStatement(query);
		int id = 1;
		
		while(true) {
			Scanner s = new Scanner(System.in); 
			System.out.println("Enter id");
			id = s.nextInt();
			
			st.setInt(1,id);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
		
		int noofcol = rsmd.getColumnCount();
	
		System.out.println(rs);
		
		
		
		while(rs.next()) {
//			System.out.print(rs.getInt(1)+"\t");
//			System.out.print(rs.getString(2)+"\t");
//			System.out.print(rs.getString(3)+"\t");
//			System.out.print(rs.getInt(4)+"\t");
			
			for(int i = 1;i<noofcol;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
			
		}
		}
	}
	
	
}
