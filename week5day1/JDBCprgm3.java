package week5day1;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;



public class JDBCprgm3 {

	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		CallableStatement cs = con.prepareCall("{call pro1(?,?)}");
		int uid=1;
		cs.setInt(1,uid);
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.execute();
		
		System.out.println("The pupil name is "+cs.getString(2));
		
	
	}
}
