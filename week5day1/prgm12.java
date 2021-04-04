package week5day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class prgm12 {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","arun");
		
		
		System.out.println("enter Increment value ");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st=br.readLine();
		int p=Integer.parseInt(st);
		CallableStatement cs=con.prepareCall ( "{call proc(?)}" );
		cs.setInt(1,100);
		cs.execute();
		System.out.println("procedure executed ");
		cs.close();
	}

}
